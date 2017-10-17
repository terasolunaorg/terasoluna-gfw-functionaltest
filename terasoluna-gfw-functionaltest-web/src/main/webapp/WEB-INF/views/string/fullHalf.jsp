<h2 id="page_title">${f:h(targetTitle)}</h2>

<form:form action="${pageContext.request.contextPath}/string/${f:h(targetPath)}"
  modelAttribute="fullHalfForm" method="post">

  <table>
    <tr>
      <td><form:label path="halfwidth">Input a half width<br>(or half-converted is output):</form:label></td>
      <td></td>
      <td><form:label path="fullwidth">Input a full width<br>(or full-converted is output):</form:label></td>
    </tr>
    <tr>
      <td><form:input type="text" path="halfwidth" /></td>
      <td><form:button id="toFullwidth" name="full">toFullwidth--&gt;</form:button><br> <form:button
          id="toHalfwidth" name="half">&lt;--toHalfwidth</form:button></td>
      <td><form:input type="text" path="fullwidth" /></td>
    </tr>
  </table>
</form:form>
