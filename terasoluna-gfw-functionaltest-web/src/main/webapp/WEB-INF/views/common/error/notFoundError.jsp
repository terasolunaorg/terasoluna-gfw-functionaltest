<!DOCTYPE html>
<html>
<head>
<title>Page Not Found</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/style.css"
  type="text/css" media="screen, projection">
</head>
<body>
  <div class="wrapper">
    <h2>Page Not Found</h2>
    <h3 id="exceptionCode">${f:h(exceptionCode)}</h3>
    <t:messagesPanel />
    <hr>
    <p style="text-align: center; background: #e5eCf9;">
      <spring:message code="copyright" htmlEscape="false" />
      (X-Track:${f:h(requestScope["X-Track"])})
    </p>
  </div>
</body>
</html>