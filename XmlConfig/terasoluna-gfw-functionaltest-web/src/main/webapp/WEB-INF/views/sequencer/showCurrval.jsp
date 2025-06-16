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

        <c:set var="titleKey" value="title.sequencer.showCurrval" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <h2>Sequencer Function Test (GET CURRENT VALUE)</h2>
            <table>
                <tr>
                    <td>CURRENT VALUE</td>
                    <td id="currval">${f:h(currval)}</td>
                </tr>
            </table>
            <table>
                <tr>
                    <td>Get Next Sequence.</td>
                    <td>Get Current Sequence.</td>
                </tr>
                <tr>
                    <td><a id="1_1_next" href="${pageContext.request.contextPath}/sequencer/1_1?next">sequncer_Integer_getNext()_1_1</a></td>
                    <td><a id="1_1_current" href="${pageContext.request.contextPath}/sequencer/1_1?current">sequncer_Integer_getCurrent()_1_1</a></td>
                </tr>
                <tr>
                    <td><a id="1_2_next" href="${pageContext.request.contextPath}/sequencer/1_2?next">sequncer_Long_getNext()_1_2</a></td>
                    <td><a id="1_2_current" href="${pageContext.request.contextPath}/sequencer/1_2?current">sequncer_Long_getCurrent()_1_2</a></td>
                </tr>
                <tr>
                    <td><a id="1_3_next" href="${pageContext.request.contextPath}/sequencer/1_3?next">sequncer_BigInteger_getNext()1_3</a></td>
                    <td><a id="1_3_current" href="${pageContext.request.contextPath}/sequencer/1_3?current">sequncer_BigInteger_getCurrent()1_3</a></td>
                </tr>
                <tr>
                    <td><a id="1_4_next" href="${pageContext.request.contextPath}/sequencer/1_4?next">sequncer_String_getNext()_1_4</a></td>
                    <td><a id="1_4_current" href="${pageContext.request.contextPath}/sequencer/1_4?current">sequncer_String_getCurrent()_1_4</a></td>
                </tr>
                <tr>
                    <td><a id="2_1_not_found_next" href="${pageContext.request.contextPath}/sequencer/2_1?next">sequncer_not_found_next_2_1</a></td>
                    <td><a id="2_1_not_found_current" href="${pageContext.request.contextPath}/sequencer/2_1?current">sequncer_not_found_current_2_1</a></td>
                </tr>
            </table>
            <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        </div>
    </body>
</html>
