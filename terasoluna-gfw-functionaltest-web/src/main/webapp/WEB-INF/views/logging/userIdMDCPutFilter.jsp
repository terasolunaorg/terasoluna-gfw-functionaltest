<h2>logging Function Test UserIdMDCPutFilter</h2>

after authentication test
<form:form action="${pageContext.request.contextPath}/logging/login" method="post">
    	userId:<input type="text" id="username" name="username">
    	password:<input type="password" id="password" name="password">
  <input type="submit" id="btn1" class="mainbtn" style="width: 100px;" value="Login" />
  <input type="hidden" name="redirectTo"
    value="${pageContext.request.contextPath}/logging/userIdMDCPutFilter/login" />
</form:form>

<br />

before authentication test
<table>
  <tr>
    <td><a id="userIdMDCPutFilterDefault"
      href="${pageContext.request.contextPath}/logging/userIdMDCPutFilter/2_1">default attribute
        name</a></td>
  </tr>
  <tr>
    <td><a id="userIdMDCPutFilterCustom"
      href="${pageContext.request.contextPath}/logging/userIdMDCPutFilter/2_2">custom attribute
        name</a></td>
  </tr>
</table>

<c:if test="${!(empty userIdMDC)}">
	${f:h(attributeName)}:<div id="userIdMDC">${f:h(userIdMDC)}</div>
</c:if>
<br />
