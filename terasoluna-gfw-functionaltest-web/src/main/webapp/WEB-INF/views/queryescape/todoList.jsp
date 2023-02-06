<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/style.css"
  type="text/css" media="screen, projection">
<script type="text/javascript"
  src="${pageContext.request.contextPath}/resources/vendor/js/jquery-1.7.2.js"></script>

<c:set var="titleKey" value="title.queryescape.todoList" />
<title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
</head>
<body>
  <div class="wrapper">
    <jsp:include page="/WEB-INF/views/layout/header.jsp" />

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
    <hr>
    <p align="right">
      Application Server : <span id="apServerName"><spring:eval
          expression="@environment.getProperty('application.server.name')" /></span> <span
        id="apServerVersion"><spring:eval
          expression="@environment.getProperty('application.server.version')" /></span>
    </p>
    <p style="text-align: center; background: #e5eCf9;">
      <spring:message code="copyright" htmlEscape="false" />
      <span id="xtrack">(X-Track:${f:h(requestScope["X-Track"])})</span>
    </p>
  </div>
</body>
</html>