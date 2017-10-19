<h2 id="page_title">CodePoints Test</h2>

<form:form action="${pageContext.request.contextPath}/codepoints/containsAll"
  modelAttribute="containsAllForm4" method="post">

  <table>
    <tr>
      <td><form:label path="targetValue">Input value:</form:label></td>
    </tr>
    <tr>
      <td><form:input type="text" path="targetValue" /></td>
    </tr>
    <tr>
      <td colspan="2"><form:label path="codePointsA">Input codePointsA (Integer):</form:label></td>
    </tr>
    <c:forEach items="${containsAllForm4.codePointsA}" varStatus="status">
      <tr>
        <td><form:input type="text" path="codePointsA[${status.index}]" /></td>
        <td><form:errors path="codePointsA[${status.index}]" style="color:red" /></td>
      </tr>
    </c:forEach>
    <tr>
      <td colspan="2"><form:label path="codePointsB">Input codePointsB (Integer):</form:label></td>
    </tr>
    <c:forEach items="${containsAllForm4.codePointsB}" varStatus="status">
      <tr>
        <td><form:input type="text" path="codePointsB[${status.index}]" /></td>
        <td><form:errors path="codePointsB[${status.index}]" style="color:red" /></td>
      </tr>
    </c:forEach>
    <tr>
      <td><form:label path="operation">Kind of instances operation:</form:label></td>
    </tr>
    <tr>
      <td><form:select path="operation">
          <form:option value="union" label="union" />
          <form:option value="subtract" label="subtract" />
          <form:option value="intersect" label="intersect" />
        </form:select></td>
    </tr>
  </table>

  <form:button id="containsAll">containsAll</form:button>
</form:form>
