<?xml version='1.0' encoding='utf-8'?>
<!-- web application context file for tomcat. -->
<!-- this file should be place at CATALINA_HOME/conf/Catalina/localhost/terasoluna-gfw-functionaltest-web.xml -->
<Context>

    <Resource name="jdbc/gfwFunctionaltestDataSource" type="javax.sql.DataSource"
        driverClassName="org.postgresql.Driver" username="postgres" password="P0stgres"
        url="jdbc:postgresql://${HOST_IP!'localhost'}:${DBSRV_DB_PORT!'5432'}/terasoluna-gfw-functionaltest"
        maxIdle="16" minIdle="0" maxWaitMillis="60000" maxTotal="96" />

    <Resources className="org.apache.catalina.webresources.StandardRoot">
        <PreResources className="org.apache.catalina.webresources.DirResourceSet"
            base="${VM_TOMCAT_ENV_JAR_DIR!'/opt/tomcat/tomcat/webapps-env-jars/terasoluna-gfw-functionaltest-env-tomcat10-postgresql'}/"
            internalPath="/" webAppMount="/WEB-INF/lib" />
    </Resources>
    <JarScanner scanAllDirectories="true" />

</Context>