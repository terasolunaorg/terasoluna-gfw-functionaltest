
<h2>Redirect</h2>
<br>
<form:form action="${pageContext.request.contextPath}/login" method="post">
  <c:if test="${!(empty param.error)}">
    <t:messagesPanel messagesAttributeName="SPRING_SECURITY_LAST_EXCEPTION" />
  </c:if>
  <fieldset>
    <br />
    <p>
      UserName:<input type="text" id="username" name="username">
    </p>
    <p>
      PassWord:<input type="password" id="password" name="password">
    </p>

    <input id="redirect" type="hidden" name="redirectTo" value="${f:h(param.redirectTo)}" />
    <div class="right">
      <input type="submit" id="btn1" class="mainbtn" value="Login" />
    </div>
  </fieldset>

</form:form>
