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
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/js/jquery-1.7.2.js"></script>

        <c:set var="titleKey" value="title.validation.bytemin" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <h2>@ByteMin Test</h2>
            <br />
            <t:messagesPanel panelElement="div id=\"message\"" outerElement="" innerElement="" />
            <form:form action="${pageContext.request.contextPath}/validation/bytemin" method="post" modelAttribute="validationForm">
                <table>
                    <tr>
                        <td colspan="2"><label for="userName">Input string with the byte length is greater than or equal to 6:</label></td>
                    </tr>
                    <tr>
                        <td><form:input type="text" path="userName" /></td>
                        <td><form:errors path="userName" style="color: red" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input id="btn_validate" type="submit" class="mainbtn" value="Validate" /></td>
                    </tr>
                </table>
            </form:form>
            <a href="${pageContext.request.contextPath}/validation">back to Validation Function Test</a>

            <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        </div>
    </body>
</html>
