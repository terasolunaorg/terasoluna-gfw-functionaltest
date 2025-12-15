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

        <c:set var="titleKey" value="title.el.dateTimeFormatQueryOutput" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <h2>Query Display f:query(DateTimeFormat)</h2>

            <span>Input Data</span>
            <form:form action="${pageContext.request.contextPath}/el/6_13/search" method="GET" modelAttribute="dateForm5">
                <fieldset>
                    <legend>Nested Bean(Parent)</legend>
                    <p>
                        <span>LocalDateTime(yyyy-MM-dd HH:mm:ss)</span>
                        <form:input path="localDateTime" />
                        <span>LocalDate(yyyy-MM-dd)</span>
                        <form:input path="localDate" />
                    </p>
                    <fieldset>
                        <legend>Nested Bean(Child)</legend>
                        <p>
                            <span>LocalDateTime(yyyy-MM-dd HH:mm:ss)</span>
                            <form:input path="item.localDateTime" />
                            <span>LocalDate(yyyy-MM-dd)</span>
                            <form:input path="item.localDate" />
                        </p>
                    </fieldset>
                </fieldset>
                <input type="submit" value="search" id="searchButton" />
            </form:form>
            <c:if test="${page != null}">
                <div id="pagination" class="pagination">
                    <t:pagination page="${page}" criteriaQuery="${f:query(dateForm5)}" />
                </div>
                <table class="maintable">
                    <thead>
                        <tr>
                            <th>Number</th>
                            <th>Dummy Column</th>
                        </tr>
                    </thead>
                    <c:forEach var="dummy" items="${page.content}" varStatus="sts">
                        <tr>
                            <td>${page.number * page.size + sts.index + 1}</td>
                            <td>${f:h(dummy)}${page.number * page.size + sts.index + 1}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        </div>
    </body>
</html>
