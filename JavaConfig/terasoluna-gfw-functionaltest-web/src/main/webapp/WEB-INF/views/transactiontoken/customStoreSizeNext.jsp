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

        <c:set var="titleKey" value="title.transactiontoken.customStoreSizeNext" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <h2>Step-1 : Transaction token is generated !!!</h2>
            <b>Transaction token value is : <span id="result"></span></b>

            <form:form action="${pageContext.request.contextPath}/transactiontoken/customTransactionStoreSize2/createFlow_1" method="post">
                <br />
                <input id="btn-in1" name="intermediate" class="mainbtn" style="width: 400px" type="submit" value="customTransactionStoreSize2/createFlow_1 Next" />
                <br />
                <br />
                <input id="btn-in1-other" name="intermediateOther" class="mainbtn" style="width: 400px" type="submit" value="Other non conflicting Next" />
                <br />
            </form:form>

            <form:form action="${pageContext.request.contextPath}/transactiontoken/customTransactionStoreSize2/createFlow_2" method="post">
                <br />
                <input id="btn-in2" name="intermediate" class="mainbtn" style="width: 400px" type="submit" value="customTransactionStoreSize2/createFlow_2 Next" />
                <br />
            </form:form>

            <form:form action="${pageContext.request.contextPath}/transactiontoken/customTransactionStoreSize1/createFlow" method="post">
                <br />
                <input id="btn-in3" name="intermediate" class="mainbtn" style="width: 400px" type="submit" value="customTransactionStoreSize1/createFlow Next" />
                <br />
            </form:form>

            <form action="${pageContext.request.contextPath}/transactiontoken" method="get" target="_blank">
                <br />
                <input id="open-new-window" class="mainbtn" style="width: 400px" type="submit" value="Open New Window" />
            </form>

            <script type="text/javascript">
                document.getElementById("result").innerHTML = document.getElementsByName("_TRANSACTION_TOKEN")[0].value;
            </script>

            <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        </div>
    </body>
</html>
