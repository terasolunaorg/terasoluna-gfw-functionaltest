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

<c:set var="titleKey" value="title.validation.compare" />
<title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
</head>
<body>
  <div class="wrapper">
    <jsp:include page="/WEB-INF/views/layout/header.jsp" />

<h2>@Compare Test</h2>

<t:messagesPanel panelElement="div id=\"message\"" outerElement="" innerElement="" />

<form:form action="${pageContext.request.contextPath}/validation/compare" method="post"
  modelAttribute="validationForm">
  <form:errors style="color:red" />
  <table>
    <tr>
      <td colspan="2"><label for="source">Input two integers:</label></td>
    </tr>
    <tr>
      <td><form:input type="text" path="left" /></td>
      <td><form:errors path="left" style="color:red" /></td>
    </tr>
    <tr>
      <td><form:input type="text" path="right" /></td>
      <td><form:errors path="right" style="color:red" /></td>
    </tr>
    <tr>
      <td colspan="2"><span>Validate full attributes settings:</span></td>
    </tr>
    <tr>
      <td colspan="2"><input id="btn_validate" type="submit" class="mainbtn" value="Validate" /></td>
    </tr>
    <tr>
      <td colspan="2"><span>Select compare operator:</span></td>
    </tr>
    <tr>
      <td colspan="2"><input id="btn_lt" type="submit" class="mainbtn" value="&lt;" name="lt" />
        <input id="btn_le" type="submit" class="mainbtn" value="&lt;=" name="le" /> <input
        id="btn_eq" type="submit" class="mainbtn" value="=" name="eq" /> <input id="btn_ne"
        type="submit" class="mainbtn" value="&ne;" name="ne" /> <input id="btn_ge" type="submit"
        class="mainbtn" value="&gt;=" name="ge" /> <input id="btn_gt" type="submit" class="mainbtn"
        value="&gt;" name="gt" /></td>
    </tr>
    <tr>
      <td colspan="3"><span>Select field to display error message (compare operator is
          equal):</span></td>
    </tr>
    <tr>
      <td colspan="2"><input id="btn_prop" type="submit" class="mainbtn" value="Property"
        name="prop" /> <input id="btn_root" type="submit" class="mainbtn" value="RootBean"
        name="root" /></td>
    </tr>
  </table>
</form:form>

<a href="${pageContext.request.contextPath}/validation">back to Validation Function Test</a>

    <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
  </div>
</body>
</html>