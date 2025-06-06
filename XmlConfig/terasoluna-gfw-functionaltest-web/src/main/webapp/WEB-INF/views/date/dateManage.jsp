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

        <c:set var="titleKey" value="title.date.dateManage" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <h2>Date Management screen</h2>

            <form:form action="${pageContext.request.contextPath}/date/diff" method="post">
                <span>Diff Time Update</span>
                <br />
                <input id="diffTime" type="text" class="text" name="diffTime" />
                <input id="btn-diff" class="mainbtn" type="submit" value="Update" />
            </form:form>
            <br />

            <span>Delete System Date</span>
            <p>
                <a id="deleteSystemDate" href="${pageContext.request.contextPath}/date/deleteSystemDate">Delete_System_Date</a>
            </p>

            <span>Reload Operation Date</span>
            <p>
                <a id="reloadAdjustedDate" href="${pageContext.request.contextPath}/date/reload">Reload_Operation_Date</a>
            </p>

            <span>Delete Operation Date</span>
            <p>
                <a id="deleteOperationDate" href="${pageContext.request.contextPath}/date/deleteOperationDate">Delete_Operation_Date</a>
            </p>

            <span>Insert Operation Date</span>
            <p>
                <a id="insertOperationDate" href="${pageContext.request.contextPath}/date/insertOperationDate">Insert_Operation_Date</a>
            </p>

            <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        </div>
    </body>
</html>
