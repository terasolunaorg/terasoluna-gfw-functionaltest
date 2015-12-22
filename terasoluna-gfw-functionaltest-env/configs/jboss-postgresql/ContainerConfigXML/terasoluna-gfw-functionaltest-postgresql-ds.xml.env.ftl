<datasources>
  <datasource jta="true" jndi-name="jdbc/gfwFunctionaltestDataSource" pool-name="jdbc/gfwFunctionaltestDataSource" enabled="true">
    <connection-url>jdbc:postgresql://${HOST_IP!'localhost'}:${DBSRV_DB_PORT!'5432'}/terasoluna-gfw-functionaltest</connection-url>
    <driver-class>org.postgresql.Driver</driver-class>
    <driver>${JDBC_JAR!'postgresql.jar'}</driver>
    <security>
      <user-name>postgres</user-name>
      <password>P0stgres</password>
    </security>
  </datasource>
</datasources>
