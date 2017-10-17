<html>
<head>
<title>Insert title here</title>
</head>
<body>
  <h2>Codelist</h2>
  <br>


  <form:form method="get" modelAttribute="codeListForm"
    action="${pageContext.request.contextPath}/codelist">
    <table>
      <tr>
        <td><form:select path="item1" items="${CL_CODELIST01_02}" /></td>
      </tr>
      <tr>
        <td><br></td>
      </tr>
      <tr>
        <td><input id="btnback" class="mainbtn" style="width: 200px;" type="submit"
          value="Back to menu" /></td>
      </tr>
    </table>
  </form:form>
</body>
</html>