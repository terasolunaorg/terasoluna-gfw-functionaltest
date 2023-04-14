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

<c:set var="titleKey" value="title.transactiontoken.flow2Step4" />
<title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
</head>
<body>
  <div class="wrapper">
    <jsp:include page="/WEB-INF/views/layout/header.jsp" />

<h2>Step-3 Flow Complete : Transaction token is destroyed !!!</h2>
<form:form action="${pageContext.request.contextPath}/transactiontoken/flow" method="get">

  <span id="result"></span>
  <br>
  <br>
  <input id="btn-back" class="mainbtn" style="width: 200px;" type="submit" value="Start Over" />
</form:form>

<script type="text/javascript">
	if (document.getElementsByName('_TRANSACTION_TOKEN')[0] == null) {
		document.getElementById("result").innerHTML = null;
	}
</script>

    <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
  </div>
</body>
</html>