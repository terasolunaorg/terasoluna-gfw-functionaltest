<h2 id="page_title">${f:h(targetTitle)}</h2>

<form:form action="${pageContext.request.contextPath}/string/${f:h(targetPath)}"
  modelAttribute="fullHalfPairForm" method="post">

  <table>
    <tr>
      <td><form:label path="fullwidth">Input value (Fullwidth):</form:label></td>
    </tr>
    <tr>
      <td><form:input type="text" path="fullwidth" /></td>
    </tr>
    <tr>
      <td><form:label path="halfwidth">Input value (Halfwidth):</form:label></td>
    </tr>
    <tr>
      <td><form:input type="text" path="halfwidth" /></td>
    </tr>
  </table>

  <form:button id="pair">pair</form:button>
</form:form>

<br>
<c:if test="${not empty resultMessage}">
  <p>
    <span id="resultMessage">"${f:h(resultMessage)}"</span><br />
  </p>
</c:if>
