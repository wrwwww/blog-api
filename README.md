## rustfs
### 初始化和配置
```bash
mkdir /rustfs/data -p
chmod 766 -R /rustfs
sudo chcon -Rt svirt_sandbox_file_t /rustfs
podman pull rustfs/rustfs:latest
podman run -d \
  -p 9000:9000 \
  -p 9001:9001 \
  -v /rustfs/data:/data \
  -e RUSTFS_ACCESS_KEY=rustfsadmin \
  -e RUSTFS_SECRET_KEY=rustfsadmin \
  rustfs/rustfs:latest --privileged=true
sudo firewall-cmd --list-all
sudo firewall-cmd --add-port=9001/tcp --permanent
sudo firewall --reload

```

## rabbitmq
### 初始化配置
```bash
podman pull rabbitmq:4.1.6-management 
 
podman run -d --hostname my-rabbit -p 5672:5672 -p 15672:15672  --name some-rabbit -e TZ=Asia/Shanghai --privileged=true rabbitmq:4.1.6-management 
```

## nacos
### 初始化配置
```bash
podman pull nacos/nacos-server

podman run -it -d --name nacos -p 8848:8848 -p 9848:9848 \
--env MODE=standalone \
--name nacos \
-e TZ=Asia/Shanghai --privileged=true  \
nacos/nacos-server
```

## sentinel
### 初始化配置
```bash
podman pull bladex/sentinel-dashboard
podman run -it -d --name sentinel -p 8858:8858 \
-p 8719:8719  \
-m 200m \
-e TZ=Asia/Shanghai \
-d bladex/sentinel-dashboard

```
