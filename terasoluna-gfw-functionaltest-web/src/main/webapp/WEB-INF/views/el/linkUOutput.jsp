
<h2>URL link f:link() and f:u()</h2>

<form:form action="${pageContext.request.contextPath}/el/output_05_04" method="post">
  <span>URLPath</span>
  <br />
  <c:set var="URLPath"
    value=" http://localhost:8080${pageContext.request.contextPath}/el/output_05_04" />
        http://localhost:8080${pageContext.request.contextPath}/el/output_05_04<br />
  <span>Input QueryParam</span>
  <br />
  <input id="text-outputQueryParam" type="text" class="text" name="outputQueryParam" />
  <br />
  <br />
  <input id="btn-output" class="mainbtn" type="submit" value="input" />
</form:form>
<br />

<span>Output Data</span>
<c:if test="${not empty outputQueryParam}" var="flg">
  <c:set var="linkPath" value="${URLPath}?name=${f:u(outputQueryParam)}" />
  <p id="linkUOutput">${f:link(linkPath)}</p>
</c:if>
