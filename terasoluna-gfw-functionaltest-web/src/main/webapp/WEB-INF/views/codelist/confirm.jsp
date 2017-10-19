<html>
<head>
<title>Insert title here</title>
</head>
<body>
  <h2>confirm output</h2>


  <form:form action="${pageContext.request.contextPath}/codelist" method="get">
    <table>
      <tr>
        <td><b>The key of selected code is : <label id="output">${codeListForm.item1}</label></b></td>
      </tr>
      <tr>
        <td><input id="btnback" class="mainbtn" style="width: 200px;" type="submit"
          value="Back to menu" /></td>
      </tr>
    </table>
  </form:form>
</body>
</html>