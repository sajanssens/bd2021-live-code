FROM icr.io/appcafe/open-liberty:21.0.0.11-kernel-slim-java11-openj9-ubi
ADD --chown=1001:0  https://repo1.maven.org/maven2/mysql/mysql-connector-java/8.0.25/mysql-connector-java-8.0.25.jar /opt/ol/wlp/lib/mysql-connector-java-8.0.25.jar
COPY --chown=1001:0 /src/main/liberty/config/server.xml /config/
RUN features.sh
COPY --chown=1001:0 target/rest.war /config/dropins/
RUN configure.sh
