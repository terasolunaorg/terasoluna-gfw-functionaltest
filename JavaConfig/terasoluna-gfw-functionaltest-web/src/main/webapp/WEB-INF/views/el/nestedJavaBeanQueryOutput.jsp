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

        <c:set var="titleKey" value="title.el.nestedJavaBeanQueryOutput" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <h2>Query Display f:query(NestedJavaBean)</h2>

            <span>Input Data</span>
            <form:form action="${pageContext.request.contextPath}/el/6_9/search" method="GET" modelAttribute="searchUserForm1">
                <fieldset>
                    <span>Name</span>
                    <form:input path="criteria.name" />
                    <span>Age</span>
                    <form:input path="criteria.age" />
                    <span>Main/Sub</span>
                    <form:select path="criteria.main">
                        <form:option value="">Unselected</form:option>
                        <form:option value="false">NO</form:option>
                        <form:option value="true">YES</form:option>
                    </form:select>
                    <span>RememberCriteria</span>
                    <form:select path="rememberCriteria">
                        <form:option value="false">NO</form:option>
                        <form:option value="true">YES</form:option>
                    </form:select>
                </fieldset>
                <input type="submit" value="search" id="searchButton" />
            </form:form>
            <c:if test="${page != null}">
                <div id="pagination" class="pagination">
                    <t:pagination page="${page}" criteriaQuery="${f:query(searchUserForm1)}" />
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
