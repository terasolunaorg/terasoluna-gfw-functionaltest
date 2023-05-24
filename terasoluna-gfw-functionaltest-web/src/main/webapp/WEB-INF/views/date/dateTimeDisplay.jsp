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

<c:set var="titleKey" value="title.date.dateTimeDisplay" />
<title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
</head>
<body>
  <div class="wrapper">
    <jsp:include page="/WEB-INF/views/layout/header.jsp" />


<h2>Server Time</h2>

<span>First Expected Date</span>
<p id="firstExpectedDate">
  <fmt:formatDate value="${firstExpectedDate}" pattern="yyyy-MM-dd HH:mm:ss.SSS" />
</p>
<span>Server Time</span>
<p id="serverTime">
  ${serverTime}
</p>
<span>Last Expected Date</span>
<p id="lastExpectedDate">
  <fmt:formatDate value="${lastExpectedDate}" pattern="yyyy-MM-dd HH:mm:ss.SSS" />
</p>

<span>Class Type</span>
<p id="type">${f:h(type)}</p>

    <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
  </div>
</body>
</html>