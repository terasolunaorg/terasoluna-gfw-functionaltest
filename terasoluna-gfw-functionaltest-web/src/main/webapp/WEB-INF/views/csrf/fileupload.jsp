
<h2>File Upload</h2>

<form:form action="${pageContext.request.contextPath}/csrf/fileUpload"
	method="post" modelAttribute="fileUploadForm"
	enctype="multipart/form-data">
	<table>
		<tr>
			<td width="65%"><form:input id="springFormFileBtn" type="file" path="uploadFile" /></td>
		</tr>
		<tr>
			<td><input id="springFormSubmitBtn" type="submit" value="Upload" /></td>
		</tr>
	</table>
</form:form>

<form action="${pageContext.request.contextPath}/csrf/fileUpload"
	method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td width="65%"><input id="formFileBtn" type="file" name="uploadFile" /></td>
		</tr>
		<tr>
			<td><input id="formSubmitBtn" type="submit" value="Upload" /></td>
		</tr>
	</table>
	<input type="hidden" name="${f:h(_csrf.parameterName)}"
		value="${f:h(_csrf.token)}" />
</form>

<form:form id="queryFileForm" action="${pageContext.request.contextPath}/csrf/fileUpload?${f:h(_csrf.parameterName)}=${f:h(_csrf.token)}"
	method="post" modelAttribute="fileUploadForm"
	enctype="multipart/form-data">
	<table>
		<tr>
			<td width="65%"><form:input id="queryFileBtn" type="file" path="uploadFile" /></td>
		</tr>
		<tr>
			<td><input id="querySubmitBtn" type="submit" value="Upload" /></td>
		</tr>
	</table>
</form:form>
