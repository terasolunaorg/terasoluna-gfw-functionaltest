<host xmlns="http://caucho.com/ns/resin" xmlns:resin="urn:java:com.caucho.resin">

  <web-app id="/terasoluna-gfw-functionaltest-web" root-directory="webapps/terasoluna-gfw-functionaltest-web">
    <!-- settings of DataSource -->
    <database jndi-name="jdbc/gfwFunctionaltestDataSource">
      <driver>
        <type>org.postgresql.Driver</type>
        <url>jdbc:postgresql://${HOST_IP!'localhost'}:${DBSRV_DB_PORT!'5432'}/terasoluna-gfw-functionaltest</url>
        <user>postgres</user>
        <password>P0stgres</password>
      </driver>
    </database>
    <!-- settings of class loader for web application -->
    <class-loader>
      <library-loader path="${VM_TOMCAT_ENV_JAR_DIR!'/opt/resin/resin/webapps-env-jars/terasoluna-gfw-functionaltest-env-resin-postgresql'}" />
    </class-loader>
  </web-app>

</host>

