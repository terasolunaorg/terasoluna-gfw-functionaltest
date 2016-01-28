#!/bin/sh

# Source function library.
. /etc/rc.d/init.d/functions

# set environment
source /etc/profile.d/interstage.sh

asadmin=${IS_HOME!'/opt/interstage'}/bin/asadmin
clusterName=${IS_CLUSTER_NAME!'Cluster001'}
hostIP=${HOST_IP!'localhost'}
dbPort=${DBSRV_DB_PORT!'1521'}

<#noparse>
    if [ -f ${asadmin} ]; then
        :
    else
        echo "file not found. ${asadmin}"
        exit 300
    fi

    ######  DataSource & Connection Pool Settings  ######
    # データプール作成
    ${asadmin} create-jdbc-connection-pool \
        --datasourceclassname oracle.jdbc.pool.OracleDataSource \
        --restype javax.sql.DataSource \
        --property user=gfw:password=gfw:url=jdbc\\:oracle\\:thin\\:@//${hostIP}\\:${dbPort}/teradb \
        gfwFunctionaltestDataSourcePool

    # データソース作成
    ${asadmin} create-jdbc-resource \
        --target ${clusterName} \
        --connectionpoolid gfwFunctionaltestDataSourcePool \
        jdbc/gfwFunctionaltestDataSource
    ######  DataSource Settings  ######

</#noparse>

exit 0
