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

        <c:set var="titleKey" value="title.string.index" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <h2>String Processes Function Test</h2>

            <table>
                <tr>
                    <td><a id="fullHalfConverter01" href="${pageContext.request.contextPath}/string/fullHalfConverter?form">FullHalfConverter_01</a></td>
                </tr>
                <tr>
                    <td><a id="customFullHalfConverter02" href="${pageContext.request.contextPath}/string/customFullHalfConverter?form">CustomFullHalfConverter_02</a></td>
                </tr>
                <tr>
                    <td><a id="fullHalfPairsBuilder03" href="${pageContext.request.contextPath}/string/fullHalfPairsBuilder?form">FullHalfPairsBuilder_03</a></td>
                </tr>
                <tr>
                    <td>
                        <a id="fullHalfPairsBuilderWithStringTrimmer03" href="${pageContext.request.contextPath}/string/fullHalfPairsBuilderWithStringTrimmer?form"
                            >FullHalfPairsBuilderWithStringTrimmer_03</a
                        >
                    </td>
                </tr>
            </table>

            <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        </div>
    </body>
</html>
