<h2 id="page_title">CodePoints Test</h2>

<form:form action="${pageContext.request.contextPath}/codepoints/firstExcludedCodePoint"
  modelAttribute="firstExcludedCodePointForm" method="post">

  <table>
    <tr>
      <td><form:label path="targetValue">Input value:</form:label></td>
    </tr>
    <tr>
      <td><form:input type="text" path="targetValue" /></td>
    </tr>
  </table>

  <form:button id="getFirstExcludedCodePoint">getFirstExcludedCodePoint</form:button>
</form:form>
