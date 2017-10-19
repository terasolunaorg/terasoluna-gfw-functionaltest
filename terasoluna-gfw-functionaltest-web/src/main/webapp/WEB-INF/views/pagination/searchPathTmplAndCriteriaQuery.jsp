
<h1 class="center-content">Person Search Form</h1>

<form class="center-content">
  <spring:nestedPath path="personSearchForm">
    <form:input path="name" />
    <form:button id="searchButton">Search</form:button>
  </spring:nestedPath>
</form>

<br>

<c:if test="${not empty page and page.totalElements != 0}">
  <h2 class="center-content">
    <span id="pagePosition">${f:h(page.number) + 1}</span> Page ( <span id="rangeStart">${(page.number * page.size) + 1}</span>-<span
      id="rangeEnd">${(page.number * page.size) +
            page.numberOfElements}</span> / <span
      id="totalResults">${page.totalElements}</span> results )
  </h2>
  <h3 class="center-content">Combination of pathTmpl And criteriaQuery (f:query)</h3>
  <div id="paginationCombinationOfPathTmplAndCriteriaQueryAndFQuery" class="pagination">
    <t:pagination page="${page}"
      pathTmpl="${pageContext.request.contextPath}/pagination/21_1/{page}/{size}"
      criteriaQuery="${f:query(personSearchForm)}" />
  </div>
  <h3 class="center-content">Combination of pathTmpl And criteriaQuery (f:u)</h3>
  <div id="paginationCombinationOfPathTmplAndCriteriaQueryAndFU" class="pagination">
    <t:pagination page="${page}"
      pathTmpl="${pageContext.request.contextPath}/pagination/21_1/{page}/{size}"
      criteriaQuery="name=${f:u(personSearchForm.name)}" />
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
        <td>${page.number * page.size + rowStatus.index +
                    1}</td>
        <td id="personId${rowStatus.index}">${f:h(person.personId)}</td>
        <td>${f:h(person.firstname)}</td>
        <td>${f:h(person.lastname)}</td>
      </tr>
    </c:forEach>
  </table>
</c:if>