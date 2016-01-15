<h2 id="page_title">CodePoints Test</h2>

<form:form action="${pageContext.request.contextPath}/codepoints"
	modelAttribute="consistOfCheckForm" method="post">

	<table>
		<c:forEach var="fieldName"
			items="${consistOfCheckForm.getFieldNames()}">
			<tr>
				<td>${f:h(fieldName)}</td>
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

	<form:button id="Send">Send</form:button>
</form:form>

