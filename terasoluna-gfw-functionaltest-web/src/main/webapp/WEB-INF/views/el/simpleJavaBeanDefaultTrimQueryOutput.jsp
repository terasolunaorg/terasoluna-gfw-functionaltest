
<h2>Query Display f:query(SimpleJavaBean) with StringTrimmerEditor</h2>

<span>Input Data</span>
<form:form action="${pageContext.request.contextPath}/el/6_15/search" method="GET"
  modelAttribute="userForm">
  <fieldset>
    <legend>Nested Bean(Parent)</legend>
    <table>
      <thead>
        <tr>
          <th>Name</th>
          <th>Age</th>
        </tr>
      </thead>
      <tr>
        <td><form:input path="name" /></td>
        <td><form:input path="age" /></td>
      </tr>
    </table>
    <fieldset>
      <legend>Nested Bean(Child)</legend>
      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Age</th>
          </tr>
        </thead>
        <tr>
          <td><form:input path="item.name" /></td>
          <td><form:input path="item.age" /></td>
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
          <th>Name</th>
          <th>Age</th>
      </thead>
      <tr>
        <td><p id="nameString">${f:h(nameString)}</p></td>
        <td><p id="ageString">${f:h(ageString)}</p></td>
      </tr>
    </table>
    <fieldset>
      <legend>Nested Bean(Child)</legend>
      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Age</th>
          </tr>
        </thead>
        <tr>
          <td><p id="nameStringItem">${f:h(nameStringItem)}</p></td>
          <td><p id="ageStringItem">${f:h(ageStringItem)}</p></td>
        </tr>
      </table>
    </fieldset>
  </fieldset>
</c:if>
<c:if test="${page != null}">
  <div id="pagination" class="pagination">
    <t:pagination page="${page}" criteriaQuery="${f:query(userForm)}" />
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