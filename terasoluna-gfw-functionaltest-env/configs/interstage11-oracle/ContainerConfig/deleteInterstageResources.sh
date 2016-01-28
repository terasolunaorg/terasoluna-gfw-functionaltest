#!/bin/sh

# Source function library.
. /etc/rc.d/init.d/functions

# set environment
source /etc/profile.d/interstage.sh

asadmin=/opt/interstage/bin/asadmin
clusterName=Cluster001

    if [ -f ${asadmin} ]; then
        :
    else
        echo "file not found. ${asadmin}"
        exit 300
    fi

    ######  Delete DataSource & Connection Pool  ######
    ${asadmin} delete-jdbc-resource  --target ${clusterName} jdbc/gfwFunctionaltestDataSource

    ${asadmin} delete-jdbc-connection-pool gfwFunctionaltestDataSourcePool
    ######  Delete DataSource & Connection Pool  ######

exit 0
