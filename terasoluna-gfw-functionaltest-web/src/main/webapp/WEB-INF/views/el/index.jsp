<h2>EL Function Test</h2>

<table>
	<tr>
		<td><a id="01" href="${pageContext.request.contextPath}/el/1">XSS_Measures(f:h())</a>
		</td>
	</tr>
	<tr>
		<td><a id="02" href="${pageContext.request.contextPath}/el/2">URL_Encoding(f:u())</a>
		</td>
	</tr>
	<tr>
		<td><a id="03" href="${pageContext.request.contextPath}/el/3">New_Line(f:br())</a>
		</td>
	</tr>
	<tr>
		<td><a id="04" href="${pageContext.request.contextPath}/el/4">Cut_String(f:cut())</a>
		</td>
	</tr>
	<tr>
		<td><a id="05" href="${pageContext.request.contextPath}/el/5">URL_Link(f:link())</a>
		</td>
	</tr>
	<tr>
		<td><a id="05_04" href="${pageContext.request.contextPath}/el/5_4">URL_Link(f:link() and f:u())</a>
		</td>
	</tr>
	<tr>
		<td><a id="06_01-02"
			href="${pageContext.request.contextPath}/el/6_1-2">Query_Display(f:query(Map))</a>
		</td>
	</tr>
	<tr>
		<td><a id="06_03-"
			href="${pageContext.request.contextPath}/el/6_3-">Query_Display(f:query(Bean))</a>
		</td>
	</tr>
	<tr>
		<td><a id="06_07"
			href="${pageContext.request.contextPath}/el/6_7">Query_Display(f:query(No
				Support Object))</a></td>
	</tr>
	<tr>
		<td><a id="07_01"
			href="${pageContext.request.contextPath}/el/7_1">JavaScript_XSS_Measures(f:js(''))</a>
		</td>
	</tr>
	<tr>
		<td><a id="07_02"
			href="${pageContext.request.contextPath}/el/7_2">JavaScript_XSS_Measures(f:js(""))</a>
		</td>
	</tr>
	<tr>
		<td><a id="07_03"
			href="${pageContext.request.contextPath}/el/7_3">JavaScript_XSS_Measures(f:js(no
				escape string))</a></td>
	</tr>
	<tr>
		<td><a id="08_01"
			href="${pageContext.request.contextPath}/el/8_1">EventHandler_XSS_Measures(f:hjs(''))</a>
		</td>
	</tr>
	<tr>
		<td><a id="08_02"
			href="${pageContext.request.contextPath}/el/8_2">EventHandler_XSS_Measures(f:hjs(""))</a>
		</td>
	</tr>
	<tr>
		<td><a id="08_03"
			href="${pageContext.request.contextPath}/el/8_3">EventHandler_XSS_Measures(f:hjs(no
				escape string))</a></td>
	</tr>
</table>