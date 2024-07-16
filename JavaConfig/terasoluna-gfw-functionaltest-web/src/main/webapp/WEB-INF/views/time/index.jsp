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

        <c:set var="titleKey" value="title.time.index" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <h2>JSR-310 Test</h2>

            <table>
                <tr>
                    <td><a id="dateAndTime_01_01" href="${pageContext.request.contextPath}/time/1_1">01_01_defaultClockFactory</a></td>
                </tr>
                <tr>
                    <td><a id="dateAndTime_02_01" href="${pageContext.request.contextPath}/time/2_1">02_01_defaultConfigurableClockFactory</a></td>
                </tr>
                <tr>
                    <td><a id="dateAndTime_02_02" href="${pageContext.request.contextPath}/time/2_2">02_02_patternConfigurableClockFactory</a></td>
                </tr>
                <tr>
                    <td><a id="dateAndTime_02_03" href="${pageContext.request.contextPath}/time/2_3">02_03_dateAndTimeConfigurableClockFactory</a></td>
                </tr>
                <tr>
                    <td><a id="dateAndTime_03_01" href="${pageContext.request.contextPath}/time/3_1">03_01_configurableAdjustClockFactory</a></td>
                </tr>
                <tr>
                    <td><a id="dateAndTime_04_01" href="${pageContext.request.contextPath}/time/4_1">04_01_jdbcClockFactory</a></td>
                </tr>
                <tr>
                    <td><a id="dateAndTime_05_01" href="${pageContext.request.contextPath}/time/5_1">05_01_jdbcAdjustClockFactory</a></td>
                </tr>
            </table>

            <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        </div>
    </body>
</html>
