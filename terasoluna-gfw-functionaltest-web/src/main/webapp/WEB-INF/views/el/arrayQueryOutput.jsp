
<h2>Query Display f:query(Array)</h2>

<span>Input Data</span>
<form:form action="${pageContext.request.contextPath}/el/6_14/search" method="GET"
  modelAttribute="arrayForm6">
  <fieldset>
    <table>
      <caption>Nested Bean(Parent)</caption>
      <thead>
        <tr>
          <th>Type</th>
          <th>Index 0</th>
          <th>Index 1</th>
          <th>Index 2</th>
        </tr>
      </thead>
      <tr>
        <td>int</td>
        <td><form:input path="array1[0]" /></td>
        <td><form:input path="array1[1]" /></td>
        <td><form:input path="array1[2]" /></td>
      </tr>
      <tr>
        <td>double</td>
        <td><form:input path="array2[0]" /></td>
        <td><form:input path="array2[1]" /></td>
      </tr>
      <tr>
        <td>byte</td>
        <td><form:input path="array3[0]" /></td>
        <td><form:input path="array3[1]" /></td>
        <td><form:input path="array3[2]" /></td>
      </tr>
      <tr>
        <td>String</td>
        <td><form:input path="array4[0]" /></td>
        <td><form:input path="array4[1]" /></td>
        <td><form:input path="array4[2]" /></td>
      </tr>
    </table>
    <fieldset>
      <table>
        <caption>Nested Bean(Child)</caption>
        <thead>
          <tr>
            <th>Type</th>
            <th>Index 0</th>
            <th>Index 1</th>
            <th>Index 2</th>
          </tr>
        </thead>
        <tr>
          <td>int</td>
          <td><form:input path="item.array1[0]" /></td>
          <td><form:input path="item.array1[1]" /></td>
          <td><form:input path="item.array1[2]" /></td>
        </tr>
        <tr>
          <td>double</td>
          <td><form:input path="item.array2[0]" /></td>
          <td><form:input path="item.array2[1]" /></td>
        </tr>
        <tr>
          <td>byte</td>
          <td><form:input path="item.array3[0]" /></td>
          <td><form:input path="item.array3[1]" /></td>
          <td><form:input path="item.array3[2]" /></td>
        </tr>
        <tr>
          <td>String</td>
          <td><form:input path="item.array4[0]" /></td>
          <td><form:input path="item.array4[1]" /></td>
          <td><form:input path="item.array4[2]" /></td>
        </tr>
      </table>
    </fieldset>
  </fieldset>

  <input type="submit" value="search" id="searchButton" />
</form:form>
<c:if test="${page != null}">
  <div id="pagination" class="pagination">
    <t:pagination page="${page}" criteriaQuery="${f:query(arrayForm6)}" />
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