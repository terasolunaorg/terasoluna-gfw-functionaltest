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

        <c:set var="titleKey" value="title.transactiontoken.index" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <h2>Transaction Token Function Test</h2>
            <table>
                <!-- Transaction token generation test scenarios -->
                <tr>
                    <td><a id="link1" href="${pageContext.request.contextPath}/transactiontoken/create">Transaction Token Contents Confirmation</a></td>
                </tr>

                <!-- Transaction token type scenarios -->
                <tr>
                    <td><a id="link2" href="${pageContext.request.contextPath}/transactiontoken/flow">TransactionTokenType : BEGIN-IN-CHECK-END</a></td>
                </tr>

                <!-- Transaction token store custom size scenarios -->
                <tr>
                    <td><a id="link3" href="${pageContext.request.contextPath}/transactiontoken/customTransactionStoreSize2/index">Transaction Store Custom Size Testing- Custom Namespace</a></td>
                </tr>
                <tr>
                    <td><a id="link4" href="${pageContext.request.contextPath}/transactiontoken/customTransactionStoreSize1/index">Transaction Store Custom Size Testing- Global Namespace</a></td>
                </tr>

                <!-- Transaction token type scenarios @AliasFor namespace-->
                <tr>
                    <td><a id="link5" href="${pageContext.request.contextPath}/transactiontoken/flow_namespace">TransactionTokenType : BEGIN-IN-CHECK-END @AliasFor namespace</a></td>
                </tr>
            </table>

            <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        </div>
    </body>
</html>
