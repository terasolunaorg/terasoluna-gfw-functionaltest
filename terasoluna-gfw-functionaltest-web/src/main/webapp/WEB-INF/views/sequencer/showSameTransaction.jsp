<html>
<h2>Sequencer Function Test (GET NEXT VALUE AND CURRENT VALUE BY SAME TRANSACTION)</h2>
<body>
	<table>
		<tr>
			<td>Mode</td>
			<td id="mode">${f:h(mode)}</td>
		</tr>
		<c:forEach var="map" items="${valuesMap}" varStatus="status1">
			<tr>
				<td> ${f:h(map.key)} </td>
				<td id="${f:h(map.key)}"> ${f:h(map.value)} </td>
			</tr>
		</c:forEach>

	</table>
	<table>
		<tr>
			<td>
				<a id="3_1_same_transaction" href="${pageContext.request.contextPath}/sequencer/3_1">sequncer_same_transaction_integer_3_1</a>
			</td>
		</tr>
		<tr>
			<td>
				<a id="3_2_same_transaction" href="${pageContext.request.contextPath}/sequencer/3_2">sequncer_same_transaction_Long_3_2</a>
			</td>
		</tr>
		<tr>
			<td>
				<a id="3_3_same_transaction" href="${pageContext.request.contextPath}/sequencer/3_3">sequncer_same_transaction_BigInteger_3_3</a>
			</td>
		</tr>
		<tr>
			<td>
				<a id="3_4_same_transaction" href="${pageContext.request.contextPath}/sequencer/3_4">sequncer_same_transaction_String_3_4</a>
			</td>
		</tr>
	</table>
</body>
</html>