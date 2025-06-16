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

        <c:set var="titleKey" value="title.transactiontoken.transactionTokenDisplayFinish" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <form action="${pageContext.request.contextPath}/transactiontoken/flow6" method="post">
                <t:transaction />
                <b>Transaction token UPDATED value is : <span id="result"></span></b> <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> <br />
                <br />
                <input id="btn-error" name="create" class="mainbtn" style="width: 200px" type="submit" value="Next and Error" /> <br />
            </form>

            <script type="text/javascript">
                document.getElementById("result").innerHTML = document.getElementsByName("_TRANSACTION_TOKEN")[0].value;
            </script>

            <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        </div>
    </body>
</html>
