
<h1>${f:h(page.number) + 1}&nbsp;Page</h1>
<div class="page">
  <t:pagination page="${page}" disabledHref="" />
</div>
<table class="maintable">
  <thead>
    <tr>
      <th>Number</th>
      <th>First Name</th>
      <th>Last Name</th>
    </tr>
  </thead>
  <c:forEach var="name" items="${page.content}" varStatus="sts">
    <tr>
      <td>${page.number * page.size + sts.index + 1}</td>
      <td>${f:h(name.firstname)}</td>
      <td>${f:h(name.lastname)}</td>
    </tr>
  </c:forEach>
</table>
<div class="page">
  <t:pagination page="${page}" disabledHref="" />
</div>
