<html>
<head>
<title>Insert title here</title>
</head>
<body>
  <h2>Codelist</h2>
  <br>
  <p id="defaultLocale">The default locale is ${defaultLocale}</p>
  <form:form action="${pageContext.request.contextPath}/codelist" method="get"
    modelAttribute="codeListForm">
    <table>
      <tr>
        <td><form:select path="item1" items="${CL_CODELIST11_05}" /></td>
      </tr>
      <tr>
        <td><input id="btnback" class="mainbtn" style="width: 200px;" type="submit"
          value="Back to menu" /></td>
      </tr>
    </table>
  </form:form>
</body>
</html>