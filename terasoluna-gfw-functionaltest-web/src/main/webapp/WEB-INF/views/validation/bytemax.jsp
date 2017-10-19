<h2>@ByteMax Test</h2>

<t:messagesPanel panelElement="div id=\"message\"" outerElement="" innerElement="" />

<form:form action="${pageContext.request.contextPath}/validation/bytemax" method="post"
  modelAttribute="validationForm">
  <table>
    <tr>
      <td colspan="2"><label for="userName">Input string with the byte length is less
          than or equal to 6:</label></td>
    </tr>
    <tr>
      <td><form:input type="text" path="userName" /></td>
      <td><form:errors path="userName" style="color:red" /></td>
    </tr>
    <tr>
      <td colspan="2"><input id="btn_validate" type="submit" class="mainbtn" value="Validate" /></td>
    </tr>
  </table>
</form:form>

<a href="${pageContext.request.contextPath}/validation">back to Validation Function Test</a>
