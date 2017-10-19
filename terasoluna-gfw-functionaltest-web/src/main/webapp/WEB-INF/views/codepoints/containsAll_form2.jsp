<h2 id="page_title">CodePoints Test</h2>

<form:form action="${pageContext.request.contextPath}/codepoints/containsAll"
  modelAttribute="containsAllForm2" method="post">

  <table>
    <tr>
      <td><form:label path="targetValue">Input value:</form:label></td>
    </tr>
    <tr>
      <td><form:input type="text" path="targetValue" /></td>
    </tr>
    <tr>
      <td colspan="2"><form:label path="codePoints">Input codePoints (Integer):</form:label></td>
    </tr>
    <c:forEach items="${containsAllForm2.codePoints}" varStatus="status">
      <tr>
        <td><form:input type="text" path="codePoints[${status.index}]" /></td>
        <td><form:errors path="codePoints[${status.index}]" style="color:red" /></td>
      </tr>
    </c:forEach>
    <tr>
      <td><form:label path="useInstanceKind">Kind of use instance:</form:label></td>
    </tr>
    <tr>
      <td><form:select path="useInstanceKind">
          <form:option value="newCodePointsWithIntegerArray"
            label="created by \"new instance of CodePoints with Integer array\"" />
          <form:option value="newCodePointsWithIntegerSet"
            label="created by \"new instance of CodePoints with Integer Set\"" />
        </form:select></td>
    </tr>
  </table>

  <form:button id="containsAll">containsAll</form:button>
</form:form>
