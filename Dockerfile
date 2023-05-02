FROM registry.access.redhat.com/ubi8/openjdk-11:1.15

RUN mkdir /tmp/order-swf-supplier/

COPY --chown=185:root . /tmp/order-swf-supplier/

WORKDIR /tmp/order-swf-supplier/

RUN ./mvnw clean package -B -ntp -Dmaven.test.skip

EXPOSE 8080

ENTRYPOINT java -jar /tmp/order-swf-supplier/target/quarkus-app/quarkus-run.jar
