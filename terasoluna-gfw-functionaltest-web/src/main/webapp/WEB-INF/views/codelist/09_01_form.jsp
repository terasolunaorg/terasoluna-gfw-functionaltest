<html>
<head>
<title>Insert title here</title>
</head>
<body>
  <h2>EnumCodelist</h2>
  <br>
  <form:form action="${pageContext.request.contextPath}/codelist/next" method="get"
    modelAttribute="codeListForm">
    <table>
      <tr>
        <td><form:select path="item1" items="${CL_MONTH_OF_YEAR}" /></td>
      </tr>
      <tr>
        <td><input id="btn1" class="mainbtn" style="width: 200px;" type="submit"
          value="Confirm" name="confirm" /></td>
      </tr>
    </table>
  </form:form>
</body>
</html>