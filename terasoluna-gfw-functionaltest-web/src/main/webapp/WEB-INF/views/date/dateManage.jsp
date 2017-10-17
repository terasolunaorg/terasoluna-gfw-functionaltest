
<h2>Date Management screen</h2>

<form:form action="${pageContext.request.contextPath}/date/diff" method="post">
  <span>Diff Time Update</span>
  <br />
  <input id="diffTime" type="text" class="text" name="diffTime" />
  <input id="btn-diff" class="mainbtn" type="submit" value="Update" />
</form:form>
<br />

<span>Delete System Date</span>
<p>
  <a id="deleteSystemDate" href="${pageContext.request.contextPath}/date/deleteSystemDate">Delete_System_Date</a>
</p>

<span>Reload Operation Date</span>
<p>
  <a id="reloadAdjustedDate" href="${pageContext.request.contextPath}/date/reload">Reload_Operation_Date</a>
</p>

<span>Delete Operation Date</span>
<p>
  <a id="deleteOperationDate" href="${pageContext.request.contextPath}/date/deleteOperationDate">Delete_Operation_Date</a>
</p>

<span>Insert Operation Date</span>
<p>
  <a id="insertOperationDate" href="${pageContext.request.contextPath}/date/insertOperationDate">Insert_Operation_Date</a>
</p>

