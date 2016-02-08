import sys

######  Connect WeblogicServer and start edit  ######
wlsuser = sys.argv[1]
wlspw = sys.argv[2]
wlsurl = sys.argv[3]

connect(wlsuser, wlspw, wlsurl)
edit()
startEdit()
######  Connect WeblogicServer and start edit.  ######



######  DataSource Settings  ######
dbService='${DB_SRVC_NAME!'teradb'}'
dbPort='${DBSRV_DB_PORT!'1521'}'
hostIp='${DB_HOST_IP!'localhost'}'
jndiNameList = ['gfwFunctionaltestDataSource', 'springFunctionaltestDataSource', 'springFunctionaltestDataSourceOpen', 'springFunctionaltestDataSourceClose']
userIdList = ['gfw', 'cfw', 'cfw_open', 'cfw_close']
passwordList = ['gfw', 'cfw', 'cfw_open', 'cfw_close']


for i in range(len(jndiNameList)):

    cd('/JDBCSystemResources/' + jndiNameList[i] + '/JDBCResource/' + jndiNameList[i] + '/JDBCDriverParams/' + jndiNameList[i])

    ### Connection Setting
#    cmo.setUrl('jdbc:oracle:thin:@' + hostIp + ':' + dbPort + '/teradb')
    cmo.setUrl('jdbc:oracle:thin:@' + hostIp + ':' + dbPort + '/' + dbService)

    ### Password Setting
    set('Password', passwordList[i])

    cd('/JDBCSystemResources/' + jndiNameList[i] + '/JDBCResource/' + jndiNameList[i] + '/JDBCDriverParams/' + jndiNameList[i] + '/Properties/' + jndiNameList[i] + '/Properties/user')

    ### UserName Setting
    cmo.setValue(userIdList[i])

######  DataSource Settings  ######



###### Save settings and activate ######
save()

activate()
###### Save settings and activate ######



exit()

