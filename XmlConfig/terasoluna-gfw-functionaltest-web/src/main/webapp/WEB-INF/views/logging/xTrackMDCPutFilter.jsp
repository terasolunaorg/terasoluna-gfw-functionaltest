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

        <c:set var="titleKey" value="title.logging.xTrackMDCPutFilter" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <h2>logging Function Test XTrackMDCPutFilter</h2>

            <table>
                <tr>
                    <td><a id="xTrackMDCPutFilterDefault" href="${pageContext.request.contextPath}/logging/xTrackMDCPutFilter/1_1">default attribute name</a></td>
                </tr>
                <tr>
                    <td><a id="xTrackMDCPutFilterCustom" href="${pageContext.request.contextPath}/logging/xTrackMDCPutFilter/1_2">custom attribute name</a></td>
                </tr>
                <tr>
                    <td><a id="xTrackMDCPutFilterCustom" href="${pageContext.request.contextPath}/logging/xTrackMDCPutFilter/1_4">Check consistency HTTP Request Header to Response Header</a></td>
                </tr>
            </table>

            <c:if test="${!(empty xTrackMDC)}">
                ${f:h(attributeName)}：
                <div id="xTrackMDC">${f:h(xTrackMDC)}</div>
            </c:if>
            <c:if test="${!(empty checkResponseHeaderXTrack)}">
                response header X-Track：
                <div id="responseHeaderXTrack">${f:h(requestScope["X-Track"])}</div>
            </c:if>
            <br />

            <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        </div>
    </body>
</html>
