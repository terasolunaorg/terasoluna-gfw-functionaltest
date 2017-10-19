
<h2>Query Display f:query(MapOfSimpleValue)</h2>

<span>Input Data</span>
<form:form action="${pageContext.request.contextPath}/el/6_12/search" method="GET"
  modelAttribute="searchForm4">
  <table>
    <thead>
      <tr>
        <th>Key</th>
        <th>Value(String)</th>
      </tr>
    </thead>
    <tr>
      <td>aaa</td>
      <td><form:input path="etc[aaa]" /></td>
    </tr>
    <tr>
      <td>bbb</td>
      <td><form:input path="etc[bbb]" /></td>
    </tr>
    <tr>
      <td>ccc</td>
      <td><form:input path="etc[ccc]" /></td>
    </tr>
  </table>
  <input type="submit" value="search" id="searchButton" />
</form:form>
<c:if test="${page != null}">
  <div id="pagination" class="pagination">
    <t:pagination page="${page}" criteriaQuery="${f:query(searchForm4)}" />
  </div>
  <table class="maintable">
    <thead>
      <tr>
        <th>Number</th>
        <th>Dummy</th>
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