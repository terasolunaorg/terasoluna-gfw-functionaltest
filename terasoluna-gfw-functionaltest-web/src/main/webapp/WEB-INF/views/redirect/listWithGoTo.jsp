
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
      <td><form:form
          action="${pageContext.request.contextPath}/redirect/withgoto/loginWithGoTo" method="GET">
          <input type="hidden" id="hdn1" name="goTo"
            value="${pageContext.request.contextPath}/redirect/detail/${f:h(user.username)}">
          <input type="submit" id="btn1" class="mainbtn" value="Login to Detail" />
        </form:form></td>
    </tr>
  </c:forEach>
</table>
