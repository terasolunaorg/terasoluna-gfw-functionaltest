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

<c:set var="titleKey" value="title.el.linkUOutput" />
<title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
</head>
<body>
  <div class="wrapper">
    <jsp:include page="/WEB-INF/views/layout/header.jsp" />


<h2>URL link f:link() and f:u()</h2>

<form:form action="${pageContext.request.contextPath}/el/output_05_04" method="post">
  <span>URLPath</span>
  <br />
  <c:set var="URLPath"
    value=" http://localhost:8080${pageContext.request.contextPath}/el/output_05_04" />
        http://localhost:8080${pageContext.request.contextPath}/el/output_05_04<br />
  <span>Input QueryParam</span>
  <br />
  <input id="text-outputQueryParam" type="text" class="text" name="outputQueryParam" />
  <br />
  <br />
  <input id="btn-output" class="mainbtn" type="submit" value="input" />
</form:form>
<br />

<span>Output Data</span>
<c:if test="${not empty outputQueryParam}" var="flg">
  <c:set var="linkPath" value="${URLPath}?name=${f:u(outputQueryParam)}" />
  <p id="linkUOutput">${f:link(linkPath)}</p>
</c:if>

    <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
  </div>
</body>
</html>