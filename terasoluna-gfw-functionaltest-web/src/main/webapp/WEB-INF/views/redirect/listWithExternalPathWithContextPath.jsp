
<h2>Redirect</h2>
<br>
<table class="maintable">
  <thead>
    <tr>
      <td>UserName</td>
      <td>Name</td>
      <td>Action</td>
    </tr>
  </thead>
  <c:forEach items="${users}" var="user">
    <tr>
      <td>${f:h(user.username)}</td>
      <td>${f:h(user.name)}</td>
      <td><form:form action="${pageContext.request.contextPath}/redirect/login" method="GET">
          <input type="hidden" id="hdn1" name="redirectTo"
            value="http://www.google.com/terasoluna-gfw-functionaltest-web/redirect/externalPathWithContextPath">
          <input type="submit" id="btn1" class="mainbtn" value="Login to Detail" />
        </form:form></td>
    </tr>
  </c:forEach>
</table>