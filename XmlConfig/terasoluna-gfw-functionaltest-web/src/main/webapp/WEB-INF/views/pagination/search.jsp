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

        <c:set var="titleKey" value="title.pagination.search" />
        <title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
    </head>
    <body>
        <div class="wrapper">
            <jsp:include page="/WEB-INF/views/layout/header.jsp" />

            <h1 class="center-content">Person Search Form</h1>

            <form class="center-content">
                <spring:nestedPath path="personSearchForm">
                    <form:input path="name" />
                    <form:button id="searchButton">Search</form:button>
                </spring:nestedPath>
            </form>

            <br />

            <c:if test="${not empty page and page.totalElements != 0}">
                <h2 class="center-content">
                    <span id="pagePosition">${f:h(page.number + 1) }</span> Page ( <span id="rangeStart">${(page.number * page.size) + 1}</span>-<span id="rangeEnd"
                        >${(page.number * page.size) + page.numberOfElements}</span
                    >
                    / <span id="totalResults">${page.totalElements}</span> results )
                </h2>
                <h3 class="center-content">URL Encoding is done in f:quey Function</h3>
                <div id="paginationAndFQueryFunction" class="pagination">
                    <t:pagination page="${page}" criteriaQuery="${f:query(personSearchForm)}" />
                </div>
                <h3 class="center-content">URL Encoding is done in f:u Function</h3>
                <div id="paginationAndFUFunction" class="pagination">
                    <t:pagination page="${page}" criteriaQuery="name=${f:u(personSearchForm.name)}" />
                </div>
                <table class="maintable">
                    <thead>
                        <tr>
                            <th>Number</th>
                            <th>Person ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                        </tr>
                    </thead>
                    <c:forEach var="person" items="${page.content}" varStatus="rowStatus">
                        <tr>
                            <td>${page.number * page.size + rowStatus.index + 1}</td>
                            <td id="personId${rowStatus.index}">${f:h(person.personId)}</td>
                            <td>${f:h(person.firstname)}</td>
                            <td>${f:h(person.lastname)}</td>
                        </tr>
                    </c:forEach>
                </table>

                <h3 class="center-content">URL Encoding is not done + disableHtmlEscapeOfCriteriaQuery is false</h3>
                <div id="paginationDisableHtmlEscapeOfCriteriaQueryIsFalse" class="pagination">
                    <t:pagination page="${page}" criteriaQuery="dummyParam=xxx&name=${param.name}" />
                </div>
                <h3 class="center-content">URL Encoding is done + FQueryFunction + disableHtmlEscapeOfCriteriaQuery is true</h3>
                <div id="paginationDisableHtmlEscapeByFQueryFunctionOfCriteriaQueryIsTrue" class="pagination">
                    <t:pagination page="${page}" criteriaQuery="${f:query(personSearchForm)}" disableHtmlEscapeOfCriteriaQuery="true" />
                </div>
                <h3 class="center-content">URL Encoding is done + FUFunction + disableHtmlEscapeOfCriteriaQuery is true</h3>
                <div id="paginationDisableHtmlEscapeByFUFunctionOfCriteriaQueryIsTrue" class="pagination">
                    <t:pagination page="${page}" criteriaQuery="name=${f:u(personSearchForm.name)}" disableHtmlEscapeOfCriteriaQuery="true" />
                </div>
            </c:if>
            <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        </div>
    </body>
</html>
