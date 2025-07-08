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

        <c:set var="titleKey" value="title.codelist.11_01_form" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <h2>Codelist</h2>
            <br />
            <form:form action="${pageContext.request.contextPath}/codelist" method="get" modelAttribute="codeListForm">
                <table>
                    <tr>
                        <td><form:select path="item1" items="${CL_CODELIST11_01}" /></td>
                    </tr>
                    <tr>
                        <td><input id="btnback" class="mainbtn" style="width: 200px" type="submit" value="Back to menu" /></td>
                    </tr>
                </table>
            </form:form>
            <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        </div>
    </body>
</html>
