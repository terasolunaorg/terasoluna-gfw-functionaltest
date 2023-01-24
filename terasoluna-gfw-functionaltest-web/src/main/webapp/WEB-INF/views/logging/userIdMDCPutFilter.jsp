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

<c:set var="titleKey" value="title.logging.userIdMDCPutFilter" />
<title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
</head>
<body>
  <div class="wrapper">
    <jsp:include page="/WEB-INF/views/layout/header.jsp" />

<h2>logging Function Test UserIdMDCPutFilter</h2>

after authentication test
<form:form action="${pageContext.request.contextPath}/logging/login" method="post">
    	userId:<input type="text" id="username" name="username">
    	password:<input type="password" id="password" name="password">
  <input type="submit" id="btn1" class="mainbtn" style="width: 100px;" value="Login" />
</form:form>

<br />

before authentication test
<table>
  <tr>
    <td><a id="userIdMDCPutFilterDefault"
      href="${pageContext.request.contextPath}/logging/userIdMDCPutFilter/2_1">default attribute
        name</a></td>
  </tr>
  <tr>
    <td><a id="userIdMDCPutFilterCustom"
      href="${pageContext.request.contextPath}/logging/userIdMDCPutFilter/2_2">custom attribute
        name</a></td>
  </tr>
</table>

<c:if test="${!(empty userIdMDC)}">
	${f:h(attributeName)}:<div id="userIdMDC">${f:h(userIdMDC)}</div>
</c:if>
<br />

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