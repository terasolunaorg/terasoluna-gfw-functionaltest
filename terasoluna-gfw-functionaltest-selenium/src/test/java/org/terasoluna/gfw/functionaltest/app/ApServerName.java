package org.terasoluna.gfw.functionaltest.app;

/**
 * Enumeration class for identifying application server.
 * <p>
 * If application server name is not set in application.env.properties, <br/>
 * UNKNOWN is set.
 * </p>
 */
public enum ApServerName {
	UNKNOWN, JBOSS, TOMCAT, WEBLOGIC
}
