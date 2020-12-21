1.  安装 `docker` 和 `docker-compose`

2.  创建 `docker-compose.yaml`文件，内容如下：

    ``` yaml
    version: '3.8'
    services:
      cerebro:
        container_name: cerebro
        image: lmenezes/cerebro:0.8.3
        ports:
          - 9000:9000
        command:
          - -Dhosts.0.host=http://es01:9200
        networks:
          - elastic
      kibana:
        container_name: kibana
        image: kibana:7.10.1
        environment:
          - I18N_LOCALE=zh-CN
          - XPACK_GRAPH_ENABLED=true
          - TIMELION_ENABLED=true
          - XPACK_MONITORING_COLLECTION_ENABLED="true"
          - ELASTICSEARCH_HOSTS="http://es01:9200"
        ports:
          - 5601:5601
        networks:
          - elastic
      logstash:
        container_name: logstash
        image: logstash:7.10.1
        volumes:
          - ./data/logstash/conf/logstash.conf:/usr/share/logstash/pipeline/logstash.conf
          - ./data/logstash/data:/usr/share/logstash/data
        networks:
          - elastic
      es01:
        image: elasticsearch:7.10.1
        container_name: es01
        environment:
          - node.name=es01
          - cluster.name=lollipop
          - discovery.seed_hosts=es02
          - cluster.initial_master_nodes=es01,es02
          - bootstrap.memory_lock=true
          - "ES_JAVA_OPTS=-Xms512m -Xmx512m"
        ulimits:
          memlock:
            soft: -1
            hard: -1
        volumes:
          - ./data/elasticsearch/es01/data:/usr/share/elasticsearch/data
          - ./data/elasticsearch/es01/logs:/usr/share/elasticsearch/logs
        ports:
          - 9200:9200
          - 9300:9300
        networks:
          - elastic
      es02:
        image: elasticsearch:7.10.1
        container_name: es02
        environment:
          - node.name=es02
          - cluster.name=lollipop
          - discovery.seed_hosts=es01
          - cluster.initial_master_nodes=es01,es02
          - bootstrap.memory_lock=true
          - "ES_JAVA_OPTS=-Xms512m -Xmx512m"
        ulimits:
          memlock:
            soft: -1
            hard: -1
        volumes:
          - ./data/elasticsearch/es02/data:/usr/share/elasticsearch/data
          - ./data/elasticsearch/es02/logs:/usr/share/elasticsearch/logs
        ports:
          - 9201:9200
          - 9301:9300
        networks:
          - elastic
    
    networks:
      elastic:
        driver: bridge
    ```

3.  进入 `docker-compose.yaml` 同级目录

4.  执行 `docker-compose up -d`命令

5.  如果遇到容器启动失败，请手动调整 `docker` 内存资源大小 

