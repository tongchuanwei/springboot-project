FROM jdk8:latest

# 复制jar包
COPY springboot-web.jar /root/springboot-web.jar

# 设置当前目录
WORKDIR /root

# 启动
ENTRYPOINT java -jar springboot-web.jar

