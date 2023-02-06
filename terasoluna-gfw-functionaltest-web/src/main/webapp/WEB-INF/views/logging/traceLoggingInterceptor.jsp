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

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/style.css"
  type="text/css" media="screen, projection">
<script type="text/javascript"
  src="${pageContext.request.contextPath}/resources/vendor/js/jquery-1.7.2.js"></script>

<c:set var="titleKey" value="title.logging.traceLoggingInterceptor" />
<title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
</head>
<body>
  <div class="wrapper">
    <jsp:include page="/WEB-INF/views/layout/header.jsp" />

<h2>logging Function Test traceLoggingInterceptor</h2>

<table>
  <tr>
    <td><a id="traceLoggingDefaultAsTraceLevel"
      href="${pageContext.request.contextPath}/logging/traceLoggingInterceptor/defaultWarnHandling/4_1">Default
        traceLogging as trace level</a></td>
  </tr>
  <tr>
    <td><a id="traceLoggingDefaultAsWarnLevel"
      href="${pageContext.request.contextPath}/logging/traceLoggingInterceptor/defaultWarnHandling/4_2">Default
        traceLogging as warm level</a></td>
  </tr>
  <tr>
    <td><a id="traceLoggingCustomAsTraceLevel"
      href="${pageContext.request.contextPath}/logging/traceLoggingInterceptor/customWarnHandling/4_3">Custom
        traceLogging as trace level</a></td>
  </tr>
  <tr>
    <td><a id="traceLoggingCustomAsWarnLevel"
      href="${pageContext.request.contextPath}/logging/traceLoggingInterceptor/customWarnHandling/4_4">Custom
        traceLogging as warm level</a></td>
  </tr>
</table>

<c:if test="${!(empty processingTime)}">
	 ${f:h(requestType)}
	<br />
	server proccessing time is ：&nbsp;${f:h(processingTime)}ms
</c:if>


    <hr>
    <p align="right">
      Application Server : <span id="apServerName"><spring:eval
          expression="@environment.getProperty('application.server.name')" /></span> <span
        id="apServerVersion"><spring:eval
          expression="@environment.getProperty('application.server.version')" /></span>
    </p>
    <p style="text-align: center; background: #e5eCf9;">
      <spring:message code="copyright" htmlEscape="false" />
      <span id="xtrack">(X-Track:${f:h(requestScope["X-Track"])})</span>
    </p>
  </div>
</body>
</html>