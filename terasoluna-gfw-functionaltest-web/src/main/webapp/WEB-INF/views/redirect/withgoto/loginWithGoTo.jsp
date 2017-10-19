
<h2>Redirect</h2>
<br>
<form:form action="${pageContext.request.contextPath}/redirect/withgoto/j_spring_security_check"
  method="post">
  <c:if test="${param.error}">
    <t:messagesPanel messagesAttributeName="SPRING_SECURITY_LAST_EXCEPTION" />
  </c:if>

  <fieldset>
    <br />
    <p>
      UserName:<input type="text" id="username" name="j_username">
    </p>
    <p>
      PassWord:<input type="password" id="password" name="j_password">
    </p>

    <input id="redirect" type="hidden" name="goTo" value="${f:h(param.goTo)}" />
    <div class="right">
      <input type="submit" id="btn1" class="mainbtn" value="Login" />
    </div>
  </fieldset>
</form:form>
