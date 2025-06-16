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

        <c:set var="titleKey" value="title.codepoints.containsAll_form2" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <h2 id="page_title">CodePoints Test</h2>

            <form:form action="${pageContext.request.contextPath}/codepoints/containsAll" modelAttribute="containsAllForm2" method="post">
                <table>
                    <tr>
                        <td><form:label path="targetValue">Input value:</form:label></td>
                    </tr>
                    <tr>
                        <td><form:input type="text" path="targetValue" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><form:label path="codePoints">Input codePoints (Integer):</form:label></td>
                    </tr>
                    <c:forEach items="${containsAllForm2.codePoints}" varStatus="status">
                        <tr>
                            <td><form:input type="text" path="codePoints[${status.index}]" /></td>
                            <td><form:errors path="codePoints[${status.index}]" style="color: red" /></td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td><form:label path="useInstanceKind">Kind of use instance:</form:label></td>
                    </tr>
                    <tr>
                        <td>
                            <form:select path="useInstanceKind">
                                <form:option value="newCodePointsWithIntegerArray" label="created by \"new instance of CodePoints with Integer array\"" /> <form:option
                                value="newCodePointsWithIntegerSet" label="created by \"new instance of CodePoints with Integer Set\"" />
                            </form:select>
                        </td>
                    </tr>
                </table>

                <form:button id="containsAll">containsAll</form:button>
            </form:form>

            <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        </div>
    </body>
</html>
