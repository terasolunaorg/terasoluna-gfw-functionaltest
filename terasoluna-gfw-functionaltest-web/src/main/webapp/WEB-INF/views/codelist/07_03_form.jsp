<html>
<head>
<title>Insert title here</title>
</head>
<body>
  <h2>Codelist</h2>
  <br>
  <form:form action="${pageContext.request.contextPath}/codelist" method="get"
    modelAttribute="codeListForm">
    <table>
      <tr>
        <td>Codelist which must be read with the use of multiple pattern:</td>
        <td><form:select path="item1" items="${SAMPLE_CODELIST}" id="list1" /></td>
      </tr>
      <tr>
        <td>Codelist which must NOT be read with the use of multiple pattern:</td>
        <td><form:select path="item1" items="${NOPATTERN_CODELIST}" id="list2" /></td>
      </tr>
      <tr>
        <td><input id="btnback" class="mainbtn" style="width: 200px;" type="submit"
          value="Back to menu" /></td>
      </tr>
    </table>
  </form:form>
</body>
</html>