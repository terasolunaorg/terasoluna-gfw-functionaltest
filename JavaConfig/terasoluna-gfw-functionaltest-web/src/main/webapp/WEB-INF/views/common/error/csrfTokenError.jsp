<!DOCTYPE html>
<html>
    <head>
        <title>CSRF Error</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/style.css" type="text/css" media="screen, projection" />
    </head>
    <body>
        <div class="wrapper">
            <h2>CSRF Attack Token Detected</h2>
            <h3 id="exceptionCode">${f:h(exceptionCode)}</h3>
            <t:messagesPanel />
            <hr />
            <p style="text-align: center; background: #e5ecf9">
                <spring:message code="copyright" htmlEscape="false" />
                (X-Track:${f:h(requestScope["X-Track"])})
            </p>
        </div>
    </body>
</html>
