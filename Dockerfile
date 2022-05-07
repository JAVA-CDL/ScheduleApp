FROM hw-cloud/library/java8u321-minimal:v3
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo Asia/Shanghai > /etc/timezone
VOLUME /tmp
EXPOSE 18080
ADD target/hot_list-1.0.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]