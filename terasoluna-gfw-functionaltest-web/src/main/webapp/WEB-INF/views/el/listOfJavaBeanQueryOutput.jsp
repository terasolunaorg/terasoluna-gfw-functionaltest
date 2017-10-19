
<h2>Query Display f:query(ListOfJavaBean)</h2>

<span>Input Data</span>
<form:form action="${pageContext.request.contextPath}/el/6_10/search" method="GET"
  modelAttribute="batchUpdateUserForm2">
  <table>
    <thead>
      <tr>
        <th>Index</th>
        <th>Name</th>
        <th>Age</th>
      </tr>
    </thead>
    <tr>
      <td>0</td>
      <td><form:input path="criteria[0].name" /></td>
      <td><form:input path="criteria[0].age" /></td>
    </tr>
    <tr>
      <td>1</td>
      <td><form:input path="criteria[1].name" /></td>
      <td><form:input path="criteria[1].age" /></td>
    </tr>
  </table>
  <form:select path="operator">
    <form:option value="AND">AND</form:option>
    <form:option value="OR">OR</form:option>
  </form:select>
  <input type="submit" value="search" id="searchButton" />
</form:form>
<c:if test="${page != null}">
  <div id="pagination" class="pagination">
    <t:pagination page="${page}" criteriaQuery="${f:query(batchUpdateUserForm2)}" />
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