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

        <c:set var="titleKey" value="title.queryescape.index" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <h2>Query Escape Function Test</h2>
            <table>
                <tr>
                    <td><label class="form-label">Database ID :</label> <a id="databaseId" class="form-label">${f:h(databaseId)}</a></td>
                    <td><label class="form-label">Database Version :</label> <a id="databaseVersion" class="form-label">${f:h(databaseVersion)}</a></td>
                </tr>
                <tr>
                    <td><a id="link1" href="${pageContext.request.contextPath}/queryescape/MyBatis">QueryEscapeUtil Function Test Using MyBatis</a></td>
                </tr>
                <tr>
                    <td><a id="link2" href="${pageContext.request.contextPath}/queryescape/JPA">QueryEscapeUtil Function Test Using JPA</a></td>
                </tr>
                <tr>
                    <td><a id="link3" href="${pageContext.request.contextPath}/queryescape/MyBatisWithFullWidth">QueryEscapeUtil Function Test Using MyBatis WithFullWidth</a></td>
                </tr>
                <tr>
                    <td><a id="link4" href="${pageContext.request.contextPath}/queryescape/JPAWithFullWidth">QueryEscapeUtil Function Test Using JPA WithFullWidth</a></td>
                </tr>
            </table>
            <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        </div>
    </body>
</html>
