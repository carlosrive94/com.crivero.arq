FROM jboss/wildfly
ADD com.crivero.app/target/com.crivero.app.war /opt/jboss/wildfly/standalone/deployments/
USER root
RUN chown jboss:jboss /opt/jboss/wildfly/standalone/deployments/*
USER jboss
