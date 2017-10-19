<h2 id="page_title">CodePoints Test</h2>

<form:form action="${pageContext.request.contextPath}/codepoints/containsAll"
  modelAttribute="containsAllForm1" method="post">

  <table>
    <tr>
      <td><form:label path="targetValue">Input value:</form:label></td>
    </tr>
    <tr>
      <td><form:input type="text" path="targetValue" /></td>
    </tr>
    <tr>
      <td><form:label path="useInstanceKind">Kind of use instance:</form:label></td>
    </tr>
    <tr>
      <td><form:select path="useInstanceKind">
          <form:option value="codePointsOf" label="created by \"method of CodePoints\"" />
          <form:option value="newJIS_X_0208_Katakana"
            label="created by \"new instance of existing code point set(JIS_X_0208_Katakana)\"" />
          <form:option value="newCodePonitsWithString"
            label="created by \"new instance of CodePoints with String\"" />
          <form:option value="codePointsOfWithJIS_X_0208_Katakana"
            label="created by \"method of CodePoints with existing code point set(JIS_X_0208_Katakana)\"" />
        </form:select></td>
    </tr>
  </table>

  <form:button id="containsAll">containsAll</form:button>
</form:form>
