#!/bin/bash

##############################
# jdbc settings
##############################
####
# データソースの設定をします。
# このShellScriptはjenkinsのジョブから呼び出してください。
####

## create jndi
expect -c "
set timeout 60
spawn /opt/WebOTX/bin/otxadmin
expect \"otxadmin\>\"
send \"login --user admin --password adminadmin --host localhost --port 6212\n\"
expect \"otxadmin\>\"
send \"delete-jdbc-datasource  jdbc/gfwFunctionaltestDataSource\n\"
expect \"otxadmin\>\"
send \"create-jdbc-datasource --useJTA=true --dataSourceType=JDBC --jdbcUserName=gfw --jdbcPassword=gfw --dataSourceName=jdbc:oracle:thin:@${HOST_IP!'localhost'}:${VM_DB_PORT!'1521'}/teradb  jdbc/gfwFunctionaltestDataSource\n\"
expect \"otxadmin\>\"
send \"exit\n\"
"    
#### END OF FILE ####