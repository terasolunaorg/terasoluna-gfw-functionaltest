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

        <c:set var="titleKey" value="title.el.mapOfSimpleValueDefaultTrimQueryOutput" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <h2>Query Display f:query(MapOfSimpleValue) with StringTrimmerEditor</h2>

            <span>Input Data</span>
            <form:form action="${pageContext.request.contextPath}/el/6_17/search" method="GET" modelAttribute="mapForm">
                <fieldset>
                    <legend>Nested Bean(Parent)</legend>
                    <table>
                        <thead>
                            <tr>
                                <th>mapA(a):String</th>
                                <th>mapA(b):String</th>
                                <th>mapA(c):String</th>
                            </tr>
                        </thead>
                        <tr>
                            <td><form:input path="mapA[a]" /></td>
                            <td><form:input path="mapA[b]" /></td>
                            <td><form:input path="mapA[c]" /></td>
                        </tr>
                    </table>
                    <fieldset>
                        <legend>Nested Bean(Child)</legend>
                        <table>
                            <thead>
                                <tr>
                                    <th>mapA(a):String</th>
                                    <th>mapA(b):String</th>
                                    <th>mapA(c):String</th>
                                </tr>
                            </thead>
                            <tr>
                                <td><form:input path="item.mapA[d]" /></td>
                                <td><form:input path="item.mapA[e]" /></td>
                                <td><form:input path="item.mapA[f]" /></td>
                            </tr>
                        </table>
                    </fieldset>
                </fieldset>
                <input type="submit" value="search" id="searchButton" />
            </form:form>
            <c:if test="${page != null}">
                <span>Output Data</span>
                <fieldset>
                    <legend>Nested Bean(Parent)</legend>
                    <table>
                        <thead>
                            <tr>
                                <th>mapA(a):String</th>
                                <th>mapA(b):String</th>
                                <th>mapA(c):String</th>
                            </tr>
                        </thead>
                        <tr>
                            <td><p id="mapA0String">${f:h(mapA0String)}</p></td>
                            <td><p id="mapA1String">${f:h(mapA1String)}</p></td>
                            <td><p id="mapA2String">${f:h(mapA2String)}</p></td>
                        </tr>
                    </table>
                    <fieldset>
                        <legend>Nested Bean(Child)</legend>
                        <table>
                            <thead>
                                <tr>
                                    <th>mapA(a):String</th>
                                    <th>mapA(b):String</th>
                                    <th>mapA(c):String</th>
                                </tr>
                            </thead>
                            <tr>
                                <td><p id="mapA0StringItem">${f:h(mapA0StringItem)}</p></td>
                                <td><p id="mapA1StringItem">${f:h(mapA1StringItem)}</p></td>
                                <td><p id="mapA2StringItem">${f:h(mapA2StringItem)}</p></td>
                            </tr>
                        </table>
                    </fieldset>
                </fieldset>
            </c:if>
            <c:if test="${page != null}">
                <div id="pagination" class="pagination">
                    <t:pagination page="${page}" criteriaQuery="${f:query(mapForm)}" />
                </div>
                <table class="maintable">
                    <thead>
                        <tr>
                            <th>Number</th>
                            <th>Dummy Column</th>
                        </tr>
                    </thead>
                    <c:forEach var="dummy" items="${page.content}" varStatus="sts">
                        <tr>
                            <td>${page.number * page.size + sts.index + 1}</td>
                            <td>${f:h(dummy)}${page.number * page.size + sts.index + 1}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        </div>
    </body>
</html>
