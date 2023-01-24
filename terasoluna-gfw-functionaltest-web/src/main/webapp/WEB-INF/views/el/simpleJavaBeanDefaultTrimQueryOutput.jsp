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

<c:set var="titleKey" value="title.el.simpleJavaBeanDefaultTrimQueryOutput" />
<title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
</head>
<body>
  <div class="wrapper">
    <jsp:include page="/WEB-INF/views/layout/header.jsp" />


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