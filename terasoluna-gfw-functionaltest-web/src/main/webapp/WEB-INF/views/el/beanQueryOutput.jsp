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

<c:set var="titleKey" value="title.el.beanQueryOutput" />
<title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
</head>
<body>
  <div class="wrapper">
    <jsp:include page="/WEB-INF/views/layout/header.jsp" />


<h2>Bean Query Display f:query()</h2>

<form:form action="${pageContext.request.contextPath}/el/search" method="GET"
  modelAttribute="customerSearchCriteria">
  <fieldset>
    <span>Name</span>
    <form:input path="name" type="text" />

    <span class="left">Main/Sub</span>
    <form:select path="main">
      <form:option value="">Unselected</form:option>
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