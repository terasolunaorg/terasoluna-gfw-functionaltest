
<h2>Redirect</h2>
<br>
<form:form action="${pageContext.request.contextPath}/redirect" method="get"
  modelAttribute="detailForm">

  <table class="maintable">
    <tr>
      <td>UserName</td>
      <td><label id="username"><sec:authentication property="principal.username" /></label></td>
    </tr>
    <tr>
      <td>Name</td>
      <td><form:label path="name" id="name">${f:h(detailForm.name)}</form:label></td>
    </tr>
    <tr>
      <td>User Address</td>
      <td><form:label path="address" id="address">${f:h(detailForm.address)}</form:label></td>
    </tr>
  </table>
  <div class="right">
    <input id="btn1" class="mainbtn" type="submit" value="Back" />
  </div>
</form:form>
