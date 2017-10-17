
<h2>Bean Query Display f:query()</h2>

<form:form action="${pageContext.request.contextPath}/el/search" method="GET"
  modelAttribute="customerSearchCriteria">
  <fieldset>
    <span>Name</span>
    <form:input path="name" type="text" />

    <span class="left">Main/Sub</span>
    <form:select path="main">
      <form:option value="false">NO</form:option>
      <form:option value="true">YES</form:option>
    </form:select>

    <span>Age</span>
    <form:input path="age" type="text" />
    <br /> <span class="left">Date Of Birth(yyyy-MM-dd)</span>
    <form:input path="dateOfBirth" type="text" placeholder="yyyy-MM-dd" />

    <span>Country</span>
    <form:select path="countries" multiple="true">
      <form:option value="JA">JA</form:option>
      <form:option value="US">US</form:option>
      <form:option value="FR">FR</form:option>
    </form:select>

    <input id="btn-output" class="mainbtn-left" type="submit" value="search" />

  </fieldset>
</form:form>

<c:if test="${page != null}">
  <div class="pagination">
    <t:pagination page="${page}" criteriaQuery="${f:query(customerSearchCriteria)}" />
  </div>
  <table class="maintable">
    <thead>
      <tr>
        <th>Number</th>
        <th>Name</th>
      </tr>
    </thead>
    <c:forEach var="customer" items="${page.content}" varStatus="sts">
      <tr>
        <td>${page.number * page.size + sts.index + 1}</td>
        <td>${f:h(customer)}${page.number * page.size + sts.index + 1}</td>
      </tr>
    </c:forEach>
  </table>
  <div class="pagination">
    <t:pagination page="${page}" criteriaQuery="${f:query(customerSearchCriteria)}" />
  </div>
</c:if>