
<h2>Query Display f:query(NestedJavaBean)</h2>

<span>Input Data</span>
<form:form action="${pageContext.request.contextPath}/el/6_9/search" method="GET"
  modelAttribute="searchUserForm1">
  <fieldset>
    <span>Name</span>
    <form:input path="criteria.name" />
    <span>Age</span>
    <form:input path="criteria.age" />
    <span>RememberCriteria</span>
    <form:select path="rememberCriteria">
      <form:option value="false">NO</form:option>
      <form:option value="true">YES</form:option>
    </form:select>
  </fieldset>
  <input type="submit" value="search" id="searchButton" />
</form:form>
<c:if test="${page != null}">
  <div id="pagination" class="pagination">
    <t:pagination page="${page}" criteriaQuery="${f:query(searchUserForm1)}" />
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