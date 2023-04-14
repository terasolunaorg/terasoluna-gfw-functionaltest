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

<c:set var="titleKey" value="title.transactiontoken.customStoreSizeMenu" />
<title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
</head>
<body>
  <div class="wrapper">
    <jsp:include page="/WEB-INF/views/layout/header.jsp" />

<h2>Transaction Token Custom Size Testing</h2>

<form:form
  action="${pageContext.request.contextPath}/transactiontoken/customTransactionStoreSize2/createFlow_1"
  method="post">
  <input id="btn-begin1" name="confirm" class="mainbtn" style="width: 400px;" type="submit"
    value="Size = 2, Namespace Setting = Class and Method" />
  <br>
  <br>
  <input id="btn-begin1-other" name="confirmOther" class="mainbtn" style="width: 400px;"
    type="submit" value="Other non conflicting operation" />
</form:form>
<br>
<form:form
  action="${pageContext.request.contextPath}/transactiontoken/customTransactionStoreSize2/createFlow_2"
  method="post">
  <input id="btn-begin2" name="confirm" class="mainbtn" style="width: 400px;" type="submit"
    value="Size = 2, Namespace Setting = Method only" />
</form:form>
<br>
<form:form
  action="${pageContext.request.contextPath}/transactiontoken/customTransactionStoreSize1/createFlow"
  method="post">
  <input id="btn-begin3" name="confirm" class="mainbtn" style="width: 400px;" type="submit"
    value="Size = 1, Namespace Setting = global" />
</form:form>
<br>

    <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
  </div>
</body>
</html>