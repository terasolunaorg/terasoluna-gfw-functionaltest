<h2>Query Escape Function Test Using&nbsp;${f:h(targetORMapper)}</h2>

input todoTitle search word and push button. choose search pattern.

<form:form action="${pageContext.request.contextPath}/queryescape/${f:h(targetORMapper)}/search"
  method="get" modelAttribute="todoForm" enctype="UTF-8">
		TodoTitle:<form:input path="todoTitle" />
  <form:button name="prefix">prefix</form:button>
  <form:button name="suffix">suffix</form:button>
  <form:button name="partical">partical</form:button>
  <form:button name="nullTodoTitle">null todo title</form:button>
</form:form>
<br />

<c:if test="${!(empty searchPattern)}">
  <div id="searchresult">${f:h(searchPattern)}&nbsp;result&nbsp;${f:h(hitNumber)}</div>
</c:if>
<c:if test="${!(empty todoList)}">
  <table>
    <thead>
      <tr>
        <th>todo ID</th>
        <th>todo Title</th>
      </tr>
    </thead>
    <c:forEach var="todo" items="${todoList}">
      <tr>
        <td>${f:h(todo.id)}</td>
        <td>${f:h(todo.todoTitle)}</td>
      </tr>
    </c:forEach>
  </table>
</c:if>