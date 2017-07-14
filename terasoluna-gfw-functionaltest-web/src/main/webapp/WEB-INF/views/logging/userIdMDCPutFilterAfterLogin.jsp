<h2>logging Function Test UserIdMDCPutFilter</h2>

after authentication test
<table>
  <tr>
    <td><a id="userIdMDCPutFilterDefault"
      href="${pageContext.request.contextPath}/logging/userIdMDCPutFilter/2_4">default attribute
        name</a></td>
  </tr>
  <tr>
    <td><a id="logout"
      href="${pageContext.request.contextPath}/logging/userIdMDCPutFilter/logout">logout</a></td>
  </tr>
</table>

<c:if test="${!(empty userIdMDC)}">
	${f:h(attributeName)}:<div id="userIdMDC">${f:h(userIdMDC)}</div>
</c:if>
<br />
