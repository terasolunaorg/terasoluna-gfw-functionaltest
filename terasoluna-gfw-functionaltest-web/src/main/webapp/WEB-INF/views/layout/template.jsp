<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/style.css"
	type="text/css" media="screen, projection">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/vendor/js/jquery-1.7.2.js"></script>

<c:set var="titleKey">
  <tiles:insertAttribute name="title" ignore="true" />
</c:set>
<title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
</head>
<body>
  <div class="wrapper">
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="body" />
    <hr>
    <p align="right">
        Application Server : 
            <span id="apServerName"><spring:eval expression="@environment.getProperty('application.server.name')"/></span>
            <span id="apServerVersion"><spring:eval expression="@environment.getProperty('application.server.version')"/></span>
    </p>
    <p style="text-align: center; background: #e5eCf9;">
        <spring:message code="copyright" htmlEscape="false" />
        <span id="xtrack">(X-Track:${f:h(requestScope["X-Track"])})</span></p>
  </div>
</body>
</html>
