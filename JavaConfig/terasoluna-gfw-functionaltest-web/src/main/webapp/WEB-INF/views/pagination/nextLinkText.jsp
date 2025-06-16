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

        <c:set var="titleKey" value="title.pagination.nextLinkText" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <h1>${f:h(page.number + 1) }&nbsp;Page</h1>
            <div class="pagination">
                <t:pagination page="${page}" nextLinkText="next" />
            </div>
            <table class="maintable">
                <thead>
                    <tr>
                        <th>Number</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                    </tr>
                </thead>
                <c:forEach var="name" items="${page.content}" varStatus="sts">
                    <tr>
                        <td>${page.number * page.size + sts.index + 1}</td>
                        <td>${f:h(name.firstname)}</td>
                        <td>${f:h(name.lastname)}</td>
                    </tr>
                </c:forEach>
            </table>
            <div class="pagination">
                <t:pagination page="${page}" nextLinkText="next" />
            </div>

            <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        </div>
    </body>
</html>
