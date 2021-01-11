### 打包与压缩

- 早期 `Linux` 的备份介质是磁带，使用命令 `tar` 进行打包。
- 之后可以使用 `gzip` 和 `bzip2` 对打包后的磁带文件进行压缩存储
- 经常使用的扩展名是 `.tar.gz` 、 `.tar.bz2` 、 `tgz`

#### 打包命令

- `tar`
- 常用参数
    - `c` 打包
    - `x` 解包
    - `f` 指定操作类型为文件
    - `z` 使用 `gzip` 进行解压缩
    - `j` 使用 `bzip` 进行解压缩

#### 举例

- 打包压缩
    - `tar czf /tmp/etc-backup.tar.gz /etc`
- 解压缩
    - `tar xzf /tmp/etc-backup.tar.gz -C /root`

### VIM

- 四种模式
    - 正常模式
        - `u` 撤销
        - `ctrl + r` 重做
        - `xxxdd` 剪切 `xxx` 行
        - `xxxyy` 复制 `xxx` 行
        - `x` 删除字符
        - `r` 替换字符
        - `gg` 跳到行首
        - `GG` 跳到行尾
        - `xxxgg` 跳到 `xxx` 行
        - `^` 跳到行首
        - `$` 跳到行尾
    - 插入模式（`i、I、o、O、a、A`）
    - 命令模式（`:`）
        - `set nu` 显示行号
        - `set nohlsearch` 关闭高亮显示
        - `!command` 临时执行 `command` 命令
        - `/xxx` 查找 `xxx`
        - `s/old/new` 替换当前行中第一个 `old` 为 `new`
        - `%s/old/new` 替换所有文本中第一个 `old` 为 `new`
        - `%s/old/new/g` 替换所有文本所有 `old` 为 `new`
        - `3,5s/old/new/g` 替换 `3 - 5` 行文本所有 `old` 为 `new`
    - 可视模式（`v 、shift + v 、 ctrl + v`）

### 用户和用户组

#### 用户

- 添加用户
    - `useradd xxx`
- 查看用户
    - `id xxx`
- 设置密码
    - `passwd xxx psw`
- 删除用户
    - `userdel -r xxx` 保证家目录被删除
- 修改用户属性
    - ` usermod`
        - `usermod -d /home/w1 w` 将用户 `w` 家目录修改为 `w1`

#### 用户组

- 添加用户组
    - `groupadd xxx`
- 添加用户到用户组
    - `usermod -g groupxxx userxxx`
- 新建用户加入用户组
    - `useradd -g groupxxx userxxx`

#### 切换用户

- 将当前用户和运行环境临时切换为userxxx
    - `su - userxxx`

- 为用户添加 `root` 权限
    - `visudo` 进入编辑器模式，在最后面添加一行并保存
        - `lollipop ALL=(ALL)`

### 文件

- 文件类型
    - `-` 普通文件
    - `d` 目录文件
    - `b` 快特殊文件（设备）
    - `c` 字符特殊文件（终端）
    - `l` 符号链接
    - `f` 命名管道
    - `s` 套接字文件

