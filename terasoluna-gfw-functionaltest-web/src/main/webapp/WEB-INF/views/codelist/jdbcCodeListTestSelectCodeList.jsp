<html>
<head>
<title>Insert title here</title>
</head>
<body>
  <h2>Codelist</h2>
  <br>

  <table>
    <c:forEach var="item" items="${jdbcCodeList}">

      <tr>
        <td><a href="${pageContext.request.contextPath}/codelist/next/${f:h(item.id)}">${item.code}</a></td>
        <td>${item.label}</td>
    </c:forEach>
  </table>

</body>
</html>