#!/bin/sh

# Source function library.
. /etc/rc.d/init.d/functions

# set environment
source /etc/profile.d/interstage.sh

asadmin=/opt/interstage/bin/asadmin
clusterName=Cluster001
hostIP=localhost
dbPort=1521

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

exit 0
