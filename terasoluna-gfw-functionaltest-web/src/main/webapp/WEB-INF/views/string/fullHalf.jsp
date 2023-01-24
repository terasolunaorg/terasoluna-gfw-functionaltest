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

<c:set var="titleKey" value="title.string.fullHalf" />
<title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
</head>
<body>
  <div class="wrapper">
    <jsp:include page="/WEB-INF/views/layout/header.jsp" />

<h2 id="page_title">${f:h(targetTitle)}</h2>

<form:form action="${pageContext.request.contextPath}/string/${f:h(targetPath)}"
  modelAttribute="fullHalfForm" method="post">

  <table>
    <tr>
      <td><form:label path="halfwidth">Input a half width<br>(or half-converted is output):</form:label></td>
      <td></td>
      <td><form:label path="fullwidth">Input a full width<br>(or full-converted is output):</form:label></td>
    </tr>
    <tr>
      <td><form:input type="text" path="halfwidth" /></td>
      <td><form:button id="toFullwidth" name="full">toFullwidth--&gt;</form:button><br> <form:button
          id="toHalfwidth" name="half">&lt;--toHalfwidth</form:button></td>
      <td><form:input type="text" path="fullwidth" /></td>
    </tr>
  </table>
</form:form>

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