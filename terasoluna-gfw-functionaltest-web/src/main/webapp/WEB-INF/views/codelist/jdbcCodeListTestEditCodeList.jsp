<html>
<head>
<title>Insert title here</title>
</head>
<body>
  <h2>Codelist</h2>
  <br>
  <form:form action="${pageContext.request.contextPath}/codelist/next" method="POST"
    modelAttribute="codeListMngForm">
    <table>
      <tr>
        <td><form:label path="code"> Code </form:label></td>
        <td><form:input path="code" /></td>
      </tr>
      <tr>
        <td><form:label path="value"> Value </form:label></td>
        <td><form:input path="value" /></td>
      </tr>
      <tr>
        <td><form:hidden path="id" /><input id="btn1" class="mainbtn" style="width: 200px;"
          type="submit" value="Update Table" name="jdbcCodeListTestUpdateCodeList" /></td>
      </tr>
    </table>
  </form:form>
</body>
</html>