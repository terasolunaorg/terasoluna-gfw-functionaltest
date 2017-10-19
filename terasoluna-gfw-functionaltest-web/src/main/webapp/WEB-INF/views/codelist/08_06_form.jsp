<html>
<head>
<title>Insert title here</title>
</head>
<body>
  <h2>Codelist</h2>
  <br>
  <form:form action="${pageContext.request.contextPath}/codelist/next" method="get"
    modelAttribute="existInCheckForm">
    <table>
      <tr>
        <td><span id="errors"><form:errors path="item6" style="color:red" /></span></td>
      </tr>
    </table>
    <table>

      <tr>
        <td>Input a key to check if it is exists in CodeList:</td>
        <td><form:input path="item6" /></td>
      </tr>
      <tr>
        <td><input id="btn1" class="mainbtn" style="width: 200px;" type="submit"
          value="Confirm" name="existInCheckExtendedCodeList" />
        <td>
        <td></td>
      </tr>
    </table>
  </form:form>
  <form:form action="${pageContext.request.contextPath}/codelist" method="get">
    <table>
      <tr>
        <td><input id="btnback" class="mainbtn" style="width: 200px;" type="submit"
          value="Back to menu" /></td>
      </tr>
    </table>
  </form:form>
</body>
</html>