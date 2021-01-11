### Kubernetes的本质

容器是一个由 Linux Namespace、Linux Cgroups 和 rootfs 三种技术构建出来的进程的隔离环境。所以一个正在运行的 Linux 容器，可以被“一分为二”地看待：

1.  一组联合挂载在 /var/lib/docker/aufs/mnt 上的 rootfs，这一部分我们称为“容器镜像”，是容器的静态视图。
2.  一个由 Namespace + Cgroups 构成的隔离环境，这一部分我们称为“容器运行时”，是容器的动态视图。

真正承载着容器信息进行传递的，是容器镜像。容器编排技术是一种能将用户提交的 Docker 镜像以容器的方式运行起来的承载点，最具代表性的容器编排工具有：

1.  Docker Compose + Swarm 组合，比较轻量适用于个人学习。
2.  Kubernetes 项目，为用户提供一个具有普遍意义的容器编排工具，能够胜任大规模集群中的容器编排任务。

Kubernetes 能够将容器镜像在一个给定的集群上运行起来，同时还能提供路由网关、水平扩展、监控、备份、灾难恢复等一系列运维能力。

![img](assets/8ee9f2fa987eccb490cfaa91c6484f67.png)

从上图可以看出，Kubernetes 由 Master 和 Node 两种节点组成，分别对应着控制节点和计算节点。

1. 控制节点由三个独立组件组合而成，分别是负责 API 服务的 kube-apiserver、负责调度的 kube-scheduler，和负责容器编排的 kube-controller-manager。整个集群的持久化数据，则由 kube-apiserver 处理后保存在 Etcd 中。

2. 计算节点上最核心的部分是 kubelet 组件，主要负责同容器运行时打交道。这个交互所依赖的，是 CRI（Container Runtime Interface）远程调用接口，这个接口定义了容器运行时的各项核心操作，比如：启动一个容器需要的所有参数。所以只要容器运行时能够运行标准的容器镜像，它就可以通过实现 CRI 接入到 Kubernetes 项目当中。而具体的容器运行时，比如 Docker 项目，则一般通过 OCI 这个容器运行时规范同底层的 Linux 操作系统进行交互，即：把 CRI 请求翻译成对 Linux 操作系统的调用（操作 Linux Namespace 和 Cgroups 等）。

    kubelet 通过 gRPC 协议同 Device Plugin 插件进行交互。它是 Kubernetes 项目用来管理 GPU 等宿主机物理设备的主要组件，也是基于 Kubernetes 项目进行机器学习训练、高性能作业支持等工作必须关注的功能。kubelet 的另一个重要功能，是调用网络插件和存储插件为容器配置网络和持久化存储。这两个插件与 kubelet 进行交互的接口，分别是 CNI（Container Networking Interface）和 CSI（Container Storage Interface）。

**Kubernetes 没有像其他“容器云”项目那样，把 Docker 作为整个架构的核心，而仅仅把它作为最底层的一个容器运行时实现。Kubernetes 着重解决的问题是如何处理运行在大规模集群中的各种任务之间的关系，这是作业编排和管理系统最困难的地方。**

**Kubernetes 最主要的设计思想是，从更宏观的角度，以统一的方式来定义任务之间的各种关系，并且为将来支持更多种类的关系留有余地。**

> 常见的容器间“紧密交互”关系：
>
> 通常一些应用往往会被直接部署在同一台机器上，通过 localhost 通信，通过本地磁盘目录交换文件。而在 Kubernetes 中，这些容器则会被划分为一个 Kubernetes 中最基础的对象“Pod”，Pod 里的容器共享同一个 Network Namespace、同一组数据卷，从而达到高效率交换信息的目的。
>
> 又比如 Web 应用与数据库之间的访问关系，Kubernetes 项目则提供了一种叫作“Service”的服务。像这样的两个应用，往往故意不部署在同一台机器上，这样即使 Web 应用所在的机器宕机了，数据库也完全不受影响。对于一个容器来说，它的 IP 地址等信息不是固定的，所以 Kubernetes 给 Pod 绑定一个 Service 服务，而 Service 服务声明的 IP 地址等信息是“终生不变”的。它作为 Pod 的代理入口（Portal），从而代替 Pod 对外暴露一个固定的网络地址。这样，对于 Web 应用的 Pod 来说，它需要关心的就是数据库 Pod 的 Service 信息。而 Service 后端真正代理的 Pod 的 IP 地址、端口等信息的自动更新、维护，则是 Kubernetes 项目的职责。

![img](assets/16c095d6efb8d8c226ad9b098689f306.png)

按照上图的线索，从容器这个最基础的概念出发：

1. 首先遇到了容器间“紧密协作”关系的难题，于是就扩展到了 Pod
2. 有了 Pod 之后，希望能一次启动多个应用的实例，这样就需要 Deployment 这个 Pod 的多实例管理器
3. 一组相同的 Pod 后，需要通过一个固定的 IP 地址和端口以负载均衡的方式访问它，于是就有了 Service
4. 如果两个不同 Pod 之间不仅有“访问关系”，要求在发起时加上授权信息。于是就有了 Secret 对象，它是一个保存在 Etcd 里的键值对数据。把 Credential 信息以 Secret 的方式存在 Etcd 里，Kubernetes 就会在指定的 Pod 启动时，自动把 Secret 里的数据以 Volume 的方式挂载到容器里。

**除了应用与应用之间的关系外，应用运行的形态是影响“如何容器化这个应用”的第二个重要因素。**

Kubernetes 定义了基于 Pod 改进后的对象。

1. Job，用来描述一次性运行的 Pod（比如，大数据任务）
2. DaemonSet，用来描述每个宿主机上必须且只能运行一个副本的守护进程服务
3. CronJob，用于描述定时任务

Kubernetes 中所推崇的使用方法是：

1. 首先，通过一个“编排对象”，比如 Pod、Job、CronJob 等，来描述试图管理的应用
2. 然后，再为它定义一些“服务对象”，比如 Service、Secret、Horizontal Pod Autoscaler 等。这些对象，会负责具体的平台级功能。

这种使用方法，就是“声明式 API”。这种 API 对应的“编排对象”和“服务对象”，都是 Kubernetes 项目中的 API 对象（API Object）。