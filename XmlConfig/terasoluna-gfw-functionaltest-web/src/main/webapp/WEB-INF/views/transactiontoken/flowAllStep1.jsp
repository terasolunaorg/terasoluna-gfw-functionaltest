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

        <c:set var="titleKey" value="title.transactiontoken.flowAllStep1" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <h2>Transaction token lifecycle (flow) confirmation</h2>
            <br />
            <form:form action="${pageContext.request.contextPath}/transactiontoken/flow1" method="post">
                <input id="btn-flow1" name="confirm" class="mainbtn" style="width: 400px" type="submit" value="BEGIN-IN-CHECK-END (Custom namespace)" />
            </form:form>
            <br />
            <form:form action="${pageContext.request.contextPath}/transactiontoken/flow2" method="post">
                <input id="btn-flow2" name="confirm" class="mainbtn" style="width: 400px" type="submit" value="BEGIN-IN-CHECK-END (GlobalToken)" />
            </form:form>
            <br />
            <form:form action="${pageContext.request.contextPath}/transactiontoken/flow1" method="post">
                <input id="btn-flow4" name="finalize" class="mainbtn" style="width: 400px" type="submit" value="END Without BEGIN" />
            </form:form>
            <br />
            <form:form action="${pageContext.request.contextPath}/transactiontoken/flow1" method="post">
                <input id="btn-flow3" name="intermediate" class="mainbtn" style="width: 400px" type="submit" value="IN Without BEGIN" />
            </form:form>
            <br />
            <form:form action="${pageContext.request.contextPath}/transactiontoken/flow1" method="post">
                <input id="btn-flow8" name="check" class="mainbtn" style="width: 400px" type="submit" value="CHECK Without BEGIN" />
            </form:form>
            <br />
            <form:form action="${pageContext.request.contextPath}/transactiontoken/flow1" method="post">
                <input id="btn-flow5_1" name="confirmError" class="mainbtn" style="width: 400px" type="submit" value="Begin returning Input Error" />
                <input id="btn-flow5_2" name="confirm" class="mainbtn" style="width: 400px" type="submit" value="Begin called with Transaction Token" />
            </form:form>
            <br />
            <form:form action="${pageContext.request.contextPath}/transactiontoken/flow6" method="post">
                <input id="btn-flow6" name="confirm" class="mainbtn" style="width: 400px" type="submit" value="BEGIN and display generated token using t:transaction" />
            </form:form>
            <br />
            <form:form action="${pageContext.request.contextPath}/transactiontoken/flow1" method="post">
                <input id="btn-flow7" name="confirmDiffNamespace" class="mainbtn" style="width: 400px" type="submit" value="IN/END Token mismatch" />
            </form:form>
            <br />

            <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        </div>
    </body>
</html>
