<!DOCTYPE html>
<html>
    <head>
        <title>Servlet Error</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/style.css" type="text/css" media="screen, projection" />
    </head>
    <body>
        <div class="wrapper">
            <h2>Servlet Error...</h2>
            <h3 id="exceptionCode">${f:h(exceptionCode)}</h3>

            <hr />
            <p style="text-align: center; background: #e5ecf9">
                <spring:message code="copyright" htmlEscape="false" />
                (X-Track:${f:h(requestScope["X-Track"])})
            </p>
        </div>
    </body>
</html>
