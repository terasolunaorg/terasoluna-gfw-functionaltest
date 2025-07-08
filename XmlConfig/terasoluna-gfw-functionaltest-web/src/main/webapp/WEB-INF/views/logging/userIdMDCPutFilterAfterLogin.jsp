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

        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/style.css" type="text/css" media="screen, projection" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/jquery.js"></script>

        <c:set var="titleKey" value="title.logging.userIdMDCPutFilterAfterLogin" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <h2>logging Function Test UserIdMDCPutFilter</h2>

            after authentication test
            <table>
                <tr>
                    <td><a id="userIdMDCPutFilterDefault" href="${pageContext.request.contextPath}/logging/userIdMDCPutFilter/2_4">default attribute name</a></td>
                </tr>
                <tr>
                    <td><a id="logout" href="javascript:document.dummyForm.submit()">logout</a></td>
                </tr>
            </table>
            <form:form name="dummyForm" method="POST" action="${pageContext.request.contextPath}/logging/userIdMDCPutFilter/logout" />
            <c:if test="${!(empty userIdMDC)}">
                ${f:h(attributeName)}:
                <div id="userIdMDC">${f:h(userIdMDC)}</div>
            </c:if>
            <br />

            <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        </div>
    </body>
</html>
