FROM adoptopenjdk:11-jre-hotspot
ADD ./build/libs/bmil_2_att-0.0.1-SNAPSHOT.jar bmil_2_att-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","bmil_2_att-0.0.1-SNAPSHOT.jar"]