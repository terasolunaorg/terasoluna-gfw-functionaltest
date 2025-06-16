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

        <c:set var="titleKey" value="title.pagination.index" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <h2>Pagination Function Test</h2>
            <table>
                <tr>
                    <td><a id="defaultSpecified_1_1" href="${pageContext.request.contextPath}/pagination/1_1">defaultSpecified_1_1</a></td>
                </tr>
                <tr>
                    <td><a id="defaultSpecified_1_2" href="${pageContext.request.contextPath}/pagination/1_2">defaultSpecified_1_2</a></td>
                </tr>
                <tr>
                    <td><a id="defaultSpecified_1_3" href="${pageContext.request.contextPath}/pagination/1_3">defaultSpecified_1_3</a></td>
                </tr>
                <tr>
                    <td><a id="defaultSpecified_1_4" href="${pageContext.request.contextPath}/pagination/1_4">defaultSpecified_1_4</a></td>
                </tr>
                <tr>
                    <td><a id="defaultSpecified_1_5" href="${pageContext.request.contextPath}/pagination/1_5">defaultSpecified_1_5</a></td>
                </tr>
                <tr>
                    <td><a id="defaultSpecified_1_6" href="${pageContext.request.contextPath}/pagination/1_6">defaultSpecified_1_6</a></td>
                </tr>
                <tr>
                    <td><a id="defaultSpecified_1_7" href="${pageContext.request.contextPath}/pagination/1_7">defaultSpecified_1_7</a></td>
                </tr>
                <tr>
                    <td><a id="defaultSpecified_1_8" href="${pageContext.request.contextPath}/pagination/1_8">defaultSpecified_1_8</a></td>
                </tr>
                <tr>
                    <td><a id="defaultSpecified_1_9" href="${pageContext.request.contextPath}/pagination/1_9">defaultSpecified_1_9</a></td>
                </tr>
                <tr>
                    <td><a id="defaultSpecified_1_10" href="${pageContext.request.contextPath}/pagination/1_10">defaultSpecified_1_10</a></td>
                </tr>
                <tr>
                    <td><a id="defaultSpecified_1_11" href="${pageContext.request.contextPath}/pagination/1_11">defaultSpecified_1_11</a></td>
                </tr>
                <tr>
                    <td><a id="pathTmplSpecified_2_1" href="${pageContext.request.contextPath}/pagination/2_1">pathTmplSpecified_2_1</a></td>
                </tr>
                <tr>
                    <td><a id="queryTmplSpecified_3_1" href="${pageContext.request.contextPath}/pagination/3_1">queryTmplSpecified_3_1</a></td>
                </tr>
                <tr>
                    <td><a id="maxDisplayCountSpecified_4_1" href="${pageContext.request.contextPath}/pagination/4_1">maxDisplayCountSpecified_4_1</a></td>
                </tr>
                <tr>
                    <td><a id="maxDisplayCountSpecified_4_2" href="${pageContext.request.contextPath}/pagination/4_2">maxDisplayCountSpecified_4_2</a></td>
                </tr>
                <tr>
                    <td><a id="outerElementSpecified_5_1" href="${pageContext.request.contextPath}/pagination/5_1">outerElementSpecified_5_1</a></td>
                </tr>
                <tr>
                    <td><a id="innerElementSpecified_6_1" href="${pageContext.request.contextPath}/pagination/6_1">innerElementSpecified_6_1</a></td>
                </tr>
                <tr>
                    <td><a id="firstLinkTextSpecified_7_1" href="${pageContext.request.contextPath}/pagination/7_1">firstLinkTextSpecified_7_1</a></td>
                </tr>
                <tr>
                    <td><a id="firstLinkTextSpecified_7_2" href="${pageContext.request.contextPath}/pagination/7_2">firstLinkTextSpecified_7_2</a></td>
                </tr>
                <tr>
                    <td><a id="previousLinkTextSpecified_8_1" href="${pageContext.request.contextPath}/pagination/8_1">previousLinkTextSpecified_8_1</a></td>
                </tr>
                <tr>
                    <td><a id="previousLinkTextSpecified_8_2" href="${pageContext.request.contextPath}/pagination/8_2">previousLinkTextSpecified_8_2</a></td>
                </tr>
                <tr>
                    <td><a id="nextLinkTextSpecified_9_1" href="${pageContext.request.contextPath}/pagination/9_1">nextLinkTextSpecified_9_1</a></td>
                </tr>
                <tr>
                    <td><a id="nextLinkTextSpecified_9_2" href="${pageContext.request.contextPath}/pagination/9_2">nextLinkTextSpecified_9_2</a></td>
                </tr>
                <tr>
                    <td><a id="lastLinkTextSpecified_10_1" href="${pageContext.request.contextPath}/pagination/10_1">lastLinkTextSpecified_10_1</a></td>
                </tr>
                <tr>
                    <td><a id="lastLinkTextSpecified_10_2" href="${pageContext.request.contextPath}/pagination/10_2">lastLinkTextSpecified_10_2</a></td>
                </tr>
                <tr>
                    <td><a id="disabledHrefSpecified_11_1" href="${pageContext.request.contextPath}/pagination/11_1">disabledHrefSpecified_11_1</a></td>
                </tr>
                <tr>
                    <td><a id="disabledHrefSpecified_11_2" href="${pageContext.request.contextPath}/pagination/11_2">disabledHrefSpecified_11_2</a></td>
                </tr>
                <tr>
                    <td><a id="activeClassSpecified_12_1" href="${pageContext.request.contextPath}/pagination/12_1">activeClassSpecified_12_1</a></td>
                </tr>
                <tr>
                    <td><a id="activeClassSpecified_12_2" href="${pageContext.request.contextPath}/pagination/12_2">activeClassSpecified_12_2</a></td>
                </tr>
                <tr>
                    <td><a id="disabledClassSpecified_13_1" href="${pageContext.request.contextPath}/pagination/13_1">disabledClassSpecified_13_1</a></td>
                </tr>
                <tr>
                    <td><a id="disabledClassSpecified_13_2" href="${pageContext.request.contextPath}/pagination/13_2">disabledClassSpecified_13_2</a></td>
                </tr>
                <tr>
                    <td><a id="pathQueryTmplCombination_14_1" href="${pageContext.request.contextPath}/pagination/14_1">pathQueryTmplCombination_14_1</a></td>
                </tr>
                <tr>
                    <td><a id="outerInnerElementCombination_15_1" href="${pageContext.request.contextPath}/pagination/15_1">outerInnerElementCombination_15_1</a></td>
                </tr>
                <tr>
                    <td><a id="firstLastLinkCombination_16_1" href="${pageContext.request.contextPath}/pagination/16_1">firstLastLinkCombination_16_1</a></td>
                </tr>
                <tr>
                    <td><a id="firstLastLinkCombination_16_2" href="${pageContext.request.contextPath}/pagination/16_2">firstLastLinkCombination_16_2</a></td>
                </tr>
                <tr>
                    <td><a id="previousNextLinkCombination_17_1" href="${pageContext.request.contextPath}/pagination/17_1">previousNextLinkCombination_17_1</a></td>
                </tr>
                <tr>
                    <td><a id="outerElementClassSpecified_18_1" href="${pageContext.request.contextPath}/pagination/18_1">outerElementClassSpecified_18_1</a></td>
                </tr>
                <tr>
                    <td><a id="innerElementClassSpecified_18_2" href="${pageContext.request.contextPath}/pagination/18_2">innerElementClassSpecified_18_2</a></td>
                </tr>
                <tr>
                    <td><a id="anchorClassSpecified_18_3" href="${pageContext.request.contextPath}/pagination/18_3">anchorClassSpecified_18_3</a></td>
                </tr>
                <tr>
                    <td><a id="screenDrawing_19_1" href="${pageContext.request.contextPath}/pagination/19_1">screenDrawing_19_1</a></td>
                </tr>
                <tr>
                    <td><a id="search_20_1" href="${pageContext.request.contextPath}/pagination/20_1">searchWithCriteriaQueryAndFQueryFunction_20_1</a></td>
                </tr>
                <tr>
                    <td><a id="search_20_2" href="${pageContext.request.contextPath}/pagination/20_2">searchWithCriteriaQueryAndFUFunction_20_2</a></td>
                </tr>
                <tr>
                    <td><a id="search_20_3" href="${pageContext.request.contextPath}/pagination/20_3">searchWithCriteriaQueryAndDisableHtmlEscapeOfCriteriaQueryIsFalse_20_3</a></td>
                </tr>
                <tr>
                    <td><a id="search_20_4" href="${pageContext.request.contextPath}/pagination/20_4">searchWithCriteriaQueryAndFQueryFunctionAndDisableHtmlEscapeOfCriteriaQueryIsTrue_20_4</a></td>
                </tr>
                <tr>
                    <td><a id="search_20_5" href="${pageContext.request.contextPath}/pagination/20_5">searchWithCriteriaQueryAndFUFunctionAndDisableHtmlEscapeOfCriteriaQueryIsTrue_20_5</a></td>
                </tr>
                <tr>
                    <td><a id="search_21_1" href="${pageContext.request.contextPath}/pagination/21_1">searchWithPathTmplAndCriteriaQuery_21_1</a></td>
                </tr>
                <tr>
                    <td><a id="search_21_2" href="${pageContext.request.contextPath}/pagination/21_2">searchWithPathTmplAndCriteriaQuery_21_2</a></td>
                </tr>
                <tr>
                    <td><a id="search_22_1" href="${pageContext.request.contextPath}/pagination/22_1">searchWithQueryTmplAndCriteriaQuery_22_1</a></td>
                </tr>
                <tr>
                    <td><a id="search_22_2" href="${pageContext.request.contextPath}/pagination/22_2">searchWithQueryTmplAndCriteriaQuery_22_2</a></td>
                </tr>
                <tr>
                    <td><a id="search_23_1" href="${pageContext.request.contextPath}/pagination/23_1">searchWithPathTmplAndQueryTmplAndCriteriaQuery_23_1</a></td>
                </tr>
                <tr>
                    <td><a id="search_23_2" href="${pageContext.request.contextPath}/pagination/23_2">searchWithPathTmplAndQueryTmplAndCriteriaQuery_23_2</a></td>
                </tr>
                <tr>
                    <td><a id="enableLinkOfCurrentPage_24_1" href="${pageContext.request.contextPath}/pagination/24_1">enableLinkOfCurrentPage=true_24_1</a></td>
                </tr>
                <tr>
                    <td><a id="disabledPageLinkWithJavaScript_25_1" href="${pageContext.request.contextPath}/pagination/25_1">disabledPageLinkWithJavaScript_25_1</a></td>
                </tr>
                <tr>
                    <td><a id="tagConfiguration_26_1" href="${pageContext.request.contextPath}/pagination/26_1">tagConfiguration_26_1</a></td>
                </tr>
            </table>

            <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        </div>
    </body>
</html>
