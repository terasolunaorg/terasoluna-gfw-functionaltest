
<h2>Query Display f:query(SimpleJavaBeanAndListOfJavaBean)</h2>

<span>Input Data</span>
<form:form action="${pageContext.request.contextPath}/el/6_11/search" method="GET"
  modelAttribute="searchAndBatchUpdateUserForm3">
  <fieldset>
    <legend>SimpleJavaBean</legend>
    <table>
      <thead>
        <tr>
          <th>Name</th>
          <th>Age</th>
        </tr>
      </thead>
      <tr>
        <td><form:input path="criteria.name" /></td>
        <td><form:input path="criteria.age" /></td>
      </tr>
    </table>
  </fieldset>
  <fieldset>
    <legend>ListOfJavaBean</legend>
    <table>
      <thead>
        <tr>
          <th>Name</th>
          <th>Age</th>
        </tr>
      </thead>
      <tr>
        <td><form:input path="users[0].name" /></td>
        <td><form:input path="users[0].age" /></td>
      </tr>
      <tr>
        <td><form:input path="users[1].name" /></td>
        <td><form:input path="users[1].age" /></td>
      </tr>
    </table>
  </fieldset>
  <input type="submit" value="search" id="searchButton" />
</form:form>
<c:if test="${page != null}">
  <div id="pagination" class="pagination">
    <t:pagination page="${page}" criteriaQuery="${f:query(searchAndBatchUpdateUserForm3)}" />
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