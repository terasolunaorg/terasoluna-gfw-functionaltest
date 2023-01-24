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

<c:set var="titleKey" value="title.codepoints.containsAll_form1" />
<title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
</head>
<body>
  <div class="wrapper">
    <jsp:include page="/WEB-INF/views/layout/header.jsp" />

<h2 id="page_title">CodePoints Test</h2>

<form:form action="${pageContext.request.contextPath}/codepoints/containsAll"
  modelAttribute="containsAllForm1" method="post">

  <table>
    <tr>
      <td><form:label path="targetValue">Input value:</form:label></td>
    </tr>
    <tr>
      <td><form:input type="text" path="targetValue" /></td>
    </tr>
    <tr>
      <td><form:label path="useInstanceKind">Kind of use instance:</form:label></td>
    </tr>
    <tr>
      <td><form:select path="useInstanceKind">
          <form:option value="codePointsOf" label="created by \"method of CodePoints\"" />
          <form:option value="newJIS_X_0208_Katakana"
            label="created by \"new instance of existing code point set(JIS_X_0208_Katakana)\"" />
          <form:option value="newCodePonitsWithString"
            label="created by \"new instance of CodePoints with String\"" />
          <form:option value="codePointsOfWithJIS_X_0208_Katakana"
            label="created by \"method of CodePoints with existing code point set(JIS_X_0208_Katakana)\"" />
        </form:select></td>
    </tr>
  </table>

  <form:button id="containsAll">containsAll</form:button>
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