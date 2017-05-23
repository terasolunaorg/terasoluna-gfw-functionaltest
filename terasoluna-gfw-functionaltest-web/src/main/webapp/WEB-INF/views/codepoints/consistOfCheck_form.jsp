<h2 id="page_title">CodePoints Test</h2>

<form:form action="${pageContext.request.contextPath}/codepoints/consistOfCheck"
  modelAttribute="consistOfCheckForm" method="post">

  <table>
    <c:forEach var="fieldName" items="${consistOfCheckForm.getFieldNames()}">
      <tr>
        <td><form:label path="${f:h(fieldName)}">${f:h(fieldName)}</form:label></td>
        <td><c:choose>
            <c:when test="${fieldName == 'asciiCtrlChars'}">
              <form:textarea path="${f:h(fieldName)}" />
            </c:when>
            <c:when test="${fieldName == 'crlf'}">
              <form:textarea path="${f:h(fieldName)}" />
            </c:when>
            <c:otherwise>
              <form:input path="${f:h(fieldName)}" />
            </c:otherwise>
          </c:choose> <form:errors style="color:red" path="${f:h(fieldName)}" /></td>
      </tr>
    </c:forEach>
  </table>

  <form:button id="check">check</form:button>
</form:form>
