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

<c:set var="titleKey" value="title.el.javascriptOutput" />
<title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
</head>
<body>
  <div class="wrapper">
    <jsp:include page="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
function setTag() {
       var writeHtmlTag = '<script>${f:js(xssAttack)}<\/script> <h2>JavaScript XSS Measures f:js()</h2>';
       var createNode= document.createTextNode(writeHtmlTag);
       document.getElementById("message").appendChild(createNode);
}
</script>

<div id="message"></div>
<input id="write" type="button" value="write" class="mainbtn" onclick="setTag()">
    <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
  </div>
</body>
</html>