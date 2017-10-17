<html>
<h2>Query Escape Function Test</h2>
<body>
  <table>
    <tr>
      <td><label class="form-label">Database ID :</label> <a id="databaseId" class="form-label">${f:h(databaseId)}</a></td>
      <td><label class="form-label">Database Version :</label> <a id="databaseVersion"
        class="form-label">${f:h(databaseVersion)}</a></td>
    </tr>
    <tr>
      <td><a id="link1" href="${pageContext.request.contextPath}/queryescape/MyBatis/">QueryEscapeUtil
          Function Test Using MyBatis</a></td>
    </tr>
    <tr>
      <td><a id="link2" href="${pageContext.request.contextPath}/queryescape/JPA/">QueryEscapeUtil
          Function Test Using JPA</a></td>
    </tr>
    <tr>
      <td><a id="link3"
        href="${pageContext.request.contextPath}/queryescape/MyBatisWithFullWidth/">QueryEscapeUtil
          Function Test Using MyBatis WithFullWidth</a></td>
    </tr>
    <tr>
      <td><a id="link4" href="${pageContext.request.contextPath}/queryescape/JPAWithFullWidth/">QueryEscapeUtil
          Function Test Using JPA WithFullWidth</a></td>
    </tr>
  </table>
</body>
</html>