<h2 id="page_title">CodePoints Test</h2>

<form:form action="${pageContext.request.contextPath}/codepoints/containsAll"
  modelAttribute="containsAllForm3" method="post">

  <table>
    <tr>
      <td><form:label path="targetValue">Input value:</form:label></td>
    </tr>
    <tr>
      <td><form:input type="text" path="targetValue" /></td>
    </tr>
    <tr>
      <td colspan="2"><form:label path="codePoints">Input codePoints (String):</form:label></td>
    </tr>
    <c:forEach items="${containsAllForm3.codePoints}" varStatus="status">
      <tr>
        <td><form:input type="text" path="codePoints[${status.index}]" /></td>
        <td><form:errors path="codePoints[${status.index}]" style="color:red" /></td>
      </tr>
    </c:forEach>
  </table>

  <form:button id="containsAll" name="newCodePointsWithStringArray">containsAll</form:button>
</form:form>
