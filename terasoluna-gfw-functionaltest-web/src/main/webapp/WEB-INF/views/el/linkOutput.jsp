
<h2>URL link f:link()</h2>

<form:form action="${pageContext.request.contextPath}/el/output_05" method="post">
  <span>Input Data</span>
  <br />
  <input id="text-output" type="text" class="text" name="outputData" />
  <input id="btn-output" class="mainbtn" type="submit" value="input" />
</form:form>
<br />

<span>Output Data</span>
<p id="linkOutput">${f:link(outputData)}</p>
