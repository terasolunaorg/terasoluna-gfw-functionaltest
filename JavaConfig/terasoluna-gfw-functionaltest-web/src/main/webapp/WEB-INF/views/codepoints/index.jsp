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

        <c:set var="titleKey" value="title.codepoints.index" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <h2>CodePoints Test</h2>

            <label>Change Locale Link</label>
            <a href="${pageContext.request.contextPath}/codepoints?locale=en">English</a>
            <a href="${pageContext.request.contextPath}/codepoints?locale=ja">Japanese</a>
            <table>
                <tr>
                    <td><a id="codepoints01_01" href="${pageContext.request.contextPath}/codepoints/containsAll?form1">containsAll_01_01</a></td>
                </tr>
                <tr>
                    <td><a id="codepoints01_02" href="${pageContext.request.contextPath}/codepoints/containsAll?form1">containsAll_01_02</a></td>
                </tr>
                <tr>
                    <td><a id="codepoints01_03" href="${pageContext.request.contextPath}/codepoints/containsAll?form2">containsAll_01_03</a></td>
                </tr>
                <tr>
                    <td><a id="codepoints01_04" href="${pageContext.request.contextPath}/codepoints/containsAll?form2">containsAll_01_04</a></td>
                </tr>
                <tr>
                    <td><a id="codepoints01_05" href="${pageContext.request.contextPath}/codepoints/containsAll?form1">containsAll_01_05</a></td>
                </tr>
                <tr>
                    <td><a id="codepoints01_06" href="${pageContext.request.contextPath}/codepoints/containsAll?form3">containsAll_01_06</a></td>
                </tr>
                <tr>
                    <td><a id="codepoints01_07" href="${pageContext.request.contextPath}/codepoints/containsAll?form4=union">containsAll_01_07</a></td>
                </tr>
                <tr>
                    <td><a id="codepoints01_08" href="${pageContext.request.contextPath}/codepoints/containsAll?form4=subtract">containsAll_01_08</a></td>
                </tr>
                <tr>
                    <td><a id="codepoints01_09" href="${pageContext.request.contextPath}/codepoints/containsAll?form4=intersect">containsAll_01_09</a></td>
                </tr>
                <tr>
                    <td><a id="codepoints01_10" href="${pageContext.request.contextPath}/codepoints/containsAll?form1">containsAll_01_10</a></td>
                </tr>
                <tr>
                    <td><a id="codepoints01_11" href="${pageContext.request.contextPath}/codepoints/containsAll?form1">containsAll_01_11</a></td>
                </tr>
                <tr>
                    <td><a id="codepoints01_12" href="${pageContext.request.contextPath}/codepoints/containsAll?form1">containsAll_01_12</a></td>
                </tr>
                <tr>
                    <td><a id="codepoints01_13" href="${pageContext.request.contextPath}/codepoints/firstExcludedCodePoint?form">firstExcludedCodePoint_01_13</a></td>
                </tr>
                <tr>
                    <td><a id="codepoints01_14" href="${pageContext.request.contextPath}/codepoints/firstExcludedCodePoint?form">firstExcludedCodePoint_01_14</a></td>
                </tr>
                <tr>
                    <td><a id="codepoints01_15" href="${pageContext.request.contextPath}/codepoints/firstExcludedCodePoint?form">firstExcludedCodePoint_01_15</a></td>
                </tr>
                <tr>
                    <td><a id="codepoints01_16" href="${pageContext.request.contextPath}/codepoints/firstExcludedCodePoint?form">firstExcludedCodePoint_01_16</a></td>
                </tr>
                <tr>
                    <td><a id="codepoints01_17" href="${pageContext.request.contextPath}/codepoints/excludedCodePoints?form">excludedCodePoints_01_17</a></td>
                </tr>
                <tr>
                    <td><a id="codepoints01_18" href="${pageContext.request.contextPath}/codepoints/excludedCodePoints?form">excludedCodePoints_01_18</a></td>
                </tr>
                <tr>
                    <td><a id="codepoints01_19" href="${pageContext.request.contextPath}/codepoints/excludedCodePoints?form">excludedCodePoints_01_19</a></td>
                </tr>
                <tr>
                    <td><a id="codepoints02_01" href="${pageContext.request.contextPath}/codepoints/consistOfCheck?form">consistOfCheck_02_01</a></td>
                </tr>
            </table>

            <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        </div>
    </body>
</html>
