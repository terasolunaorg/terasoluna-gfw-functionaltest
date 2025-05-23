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

        <c:set var="titleKey" value="title.transactiontoken.createInput" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <h2>Token generation and contents confirmation</h2>
            <br />
            <form:form action="${pageContext.request.contextPath}/transactiontoken/create/1_1" method="post">
                <input id="btn1" class="mainbtn" style="width: 400px" type="submit" value="Namespace with Class value only" />
            </form:form>
            <br />
            <form:form action="${pageContext.request.contextPath}/transactiontoken/create/1_2" method="post">
                <input id="btn2" class="mainbtn" style="width: 400px" type="submit" value="Namespace with Class and method value" />
            </form:form>
            <br />
            <form:form action="${pageContext.request.contextPath}/transactiontoken/create/1_3" method="post">
                <input id="btn3" class="mainbtn" style="width: 400px" type="submit" value="Namespace with method value only " />
            </form:form>
            <br />
            <form:form action="${pageContext.request.contextPath}/transactiontoken/create/1_4" method="post">
                <input id="btn4" class="mainbtn" style="width: 400px" type="submit" value="Namespace with neither class nor method value" />
            </form:form>
            <br />
            <form:form action="${pageContext.request.contextPath}/transactiontoken/createWithUnderscore/1_1" method="post">
                <input id="btn5" class="mainbtn" style="width: 400px" type="submit" value="Namespace with underscore" />
            </form:form>
            <br />

            <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        </div>
    </body>
</html>
