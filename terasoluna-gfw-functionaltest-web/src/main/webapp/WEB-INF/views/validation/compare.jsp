<h2>@Compare Test</h2>

<t:messagesPanel panelElement="div id=\"message\"" outerElement="" innerElement="" />

<form:form action="${pageContext.request.contextPath}/validation/compare" method="post"
  modelAttribute="validationForm">
  <form:errors style="color:red" />
  <table>
    <tr>
      <td colspan="2"><label for="source">Input two integers:</label></td>
    </tr>
    <tr>
      <td><form:input type="text" path="left" /></td>
      <td><form:errors path="left" style="color:red" /></td>
    </tr>
    <tr>
      <td><form:input type="text" path="right" /></td>
      <td><form:errors path="right" style="color:red" /></td>
    </tr>
    <tr>
      <td colspan="2"><span>Validate full attributes settings:</span></td>
    </tr>
    <tr>
      <td colspan="2"><input id="btn_validate" type="submit" class="mainbtn" value="Validate" /></td>
    </tr>
    <tr>
      <td colspan="2"><span>Select compare operator:</span></td>
    </tr>
    <tr>
      <td colspan="2"><input id="btn_lt" type="submit" class="mainbtn" value="&lt;" name="lt" />
        <input id="btn_le" type="submit" class="mainbtn" value="&lt;=" name="le" /> <input
        id="btn_eq" type="submit" class="mainbtn" value="=" name="eq" /> <input id="btn_ne"
        type="submit" class="mainbtn" value="&ne;" name="ne" /> <input id="btn_ge" type="submit"
        class="mainbtn" value="&gt;=" name="ge" /> <input id="btn_gt" type="submit" class="mainbtn"
        value="&gt;" name="gt" /></td>
    </tr>
    <tr>
      <td colspan="3"><span>Select field to display error message (compare operator is
          equal):</span></td>
    </tr>
    <tr>
      <td colspan="2"><input id="btn_prop" type="submit" class="mainbtn" value="Property"
        name="prop" /> <input id="btn_root" type="submit" class="mainbtn" value="RootBean"
        name="root" /></td>
    </tr>
  </table>
</form:form>

<a href="${pageContext.request.contextPath}/validation">back to Validation Function Test</a>
