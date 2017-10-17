
<h2>New Line f:br()</h2>

<form:form action="${pageContext.request.contextPath}/el/output_03" method="post">
  <span>Input Data</span>
  <br />
  <textarea id="text-output" name="outputData"></textarea>
  <input id="btn-output" class="mainbtn" type="submit" value="input" />
</form:form>
<br />

<span>Output Data</span>
<p id="newLineOutput">${f:br(outputData)}</p>
