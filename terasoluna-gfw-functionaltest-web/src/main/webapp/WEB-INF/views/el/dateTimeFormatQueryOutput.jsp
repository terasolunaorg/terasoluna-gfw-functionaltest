
<h2>Query Display f:query(DateTimeFormat)</h2>

<span>Input Data</span>
<form:form action="${pageContext.request.contextPath}/el/6_13/search" method="GET"
  modelAttribute="dateForm5">
  <fieldset>
    <legend>Nested Bean(Parent)</legend>
    <p>
      <span>Date(yyyy-MM-dd)</span>
      <form:input path="date" />
      <span>LocalDate(yyyy-MM-dd)</span>
      <form:input path="localDate" />
    </p>
    <fieldset>
      <legend>Nested Bean(Child)</legend>
      <p>
        <span>Date(yyyy-MM-dd)</span>
        <form:input path="item.date" />
        <span>LocalDate(yyyy-MM-dd)</span>
        <form:input path="item.localDate" />
      </p>
    </fieldset>
  </fieldset>
  <input type="submit" value="search" id="searchButton" />
</form:form>
<c:if test="${page != null}">
  <div id="pagination" class="pagination">
    <t:pagination page="${page}" criteriaQuery="${f:query(dateForm5)}" />
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