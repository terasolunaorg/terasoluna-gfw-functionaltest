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

<c:set var="titleKey" value="title.codepoints.containsAll_form4" />
<title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
</head>
<body>
  <div class="wrapper">
    <jsp:include page="/WEB-INF/views/layout/header.jsp" />

<h2 id="page_title">CodePoints Test</h2>

<form:form action="${pageContext.request.contextPath}/codepoints/containsAll"
  modelAttribute="containsAllForm4" method="post">

  <table>
    <tr>
      <td><form:label path="targetValue">Input value:</form:label></td>
    </tr>
    <tr>
      <td><form:input type="text" path="targetValue" /></td>
    </tr>
    <tr>
      <td colspan="2"><form:label path="codePointsA">Input codePointsA (Integer):</form:label></td>
    </tr>
    <c:forEach items="${containsAllForm4.codePointsA}" varStatus="status">
      <tr>
        <td><form:input type="text" path="codePointsA[${status.index}]" /></td>
        <td><form:errors path="codePointsA[${status.index}]" style="color:red" /></td>
      </tr>
    </c:forEach>
    <tr>
      <td colspan="2"><form:label path="codePointsB">Input codePointsB (Integer):</form:label></td>
    </tr>
    <c:forEach items="${containsAllForm4.codePointsB}" varStatus="status">
      <tr>
        <td><form:input type="text" path="codePointsB[${status.index}]" /></td>
        <td><form:errors path="codePointsB[${status.index}]" style="color:red" /></td>
      </tr>
    </c:forEach>
    <tr>
      <td><form:label path="operation">Kind of instances operation:</form:label></td>
    </tr>
    <tr>
      <td><form:select path="operation">
          <form:option value="union" label="union" />
          <form:option value="subtract" label="subtract" />
          <form:option value="intersect" label="intersect" />
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