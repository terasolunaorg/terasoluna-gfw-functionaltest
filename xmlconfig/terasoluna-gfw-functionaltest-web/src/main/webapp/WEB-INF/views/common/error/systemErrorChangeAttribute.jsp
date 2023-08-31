<!DOCTYPE html>
<html>
<head>
<title>System Error</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/style.css"
  type="text/css" media="screen, projection">
</head>
<body>
  <div class="wrapper">
    <h2>System Error...</h2>
    <h3 id="exceptionCode">${f:h(errorCode)}</h3>
    <div id="messagesPanel">
      <t:messagesPanel />
    </div>
    <hr>
    <p style="text-align: center; background: #e5eCf9;">
      <spring:message code="copyright" htmlEscape="false" />
      (X-Track:${f:h(requestScope["X-Track"])})
    </p>
  </div>
</body>
</html>