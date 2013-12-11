<h2>CSRF Test</h2>


<form:form
	action="${pageContext.request.contextPath}/csrf/1_1"
	method="GET">
	<input type="submit" id="csrf_1_1" class="mainbtn-wide" value="01_01_SpringFormNormalCsrfTokenSend_HttpMethodGet" />
</form:form>
<form:form
	action="${pageContext.request.contextPath}/csrf/1_2"
	method="GET">
	<input type="submit" id="csrf_1_2" class="mainbtn-wide" value="01_02_SpringFormAlterCsrfTokenSend_HttpMethodGet" />
</form:form>
<form:form
	action="${pageContext.request.contextPath}/csrf/1_3"
	method="POST">
	<input type="submit" id="csrf_1_3" class="mainbtn-wide" value="01_03_SpringFormNormalCsrfTokenSend_HttpMethodPost" />
</form:form>
<form:form
	action="${pageContext.request.contextPath}/csrf/1_4"
	method="POST">
	<input type="submit" id="csrf_1_4" class="mainbtn-wide" value="01_04_SpringFormAlterCsrfTokenSend_HttpMethodPost" />
</form:form>
<form
	action="${pageContext.request.contextPath}/csrf/1_5"
	method="POST">
	<input type="submit" id="csrf_1_5" class="mainbtn-wide" value="01_05_FormNormalCsrfTokenSend_HttpMethodPost" />
	<input type="hidden" id="csrfToken_1_5" name="${f:h(_csrf.parameterName)}" value="${f:h(_csrf.token)}"/>
</form>
<form
	action="${pageContext.request.contextPath}/csrf/1_6"
	method="POST">
	<input type="submit" id="csrf_1_6" class="mainbtn-wide" value="01_06_FormAlterCsrfTokenSend_HttpMethodPost" />
	<input type="hidden" id="csrfToken_1_6" name="${f:h(_csrf.parameterName)}" value="${f:h(_csrf.token)}"/>
</form>
<br/>

<hr/>
<a id="csrf_2_1"
			href="${pageContext.request.contextPath}/csrf/csrfHeadSet?method=GET">02_01_HeadNormalCsrfTokenSend_HttpMethodGet</a>
<br/>
<a id="csrf_2_2"
			href="${pageContext.request.contextPath}/csrf/csrfHeadSet?method=GET">02_02_HeadAlterCsrfTokenSend_HttpMethodGet</a>
<br/>
<a id="csrf_2_3"
			href="${pageContext.request.contextPath}/csrf/csrfHeadSet?method=POST">02_03_HeadNormalCsrfTokenSend_HttpMethodPost</a>
<br/>
<a id="csrf_2_4"
			href="${pageContext.request.contextPath}/csrf/csrfHeadSet?method=POST">02_04_HeadAlterCsrfTokenSend_HttpMethodPost</a>
<br/>
<a id="csrf_2_5"
			href="${pageContext.request.contextPath}/csrf/csrfTokenHeadAndFormSetting?method=POST">02_05_FormAlterCsrfTokenSendAndHeadNormalCsrfTokenSend_HttpMethodPost</a>
<br/>
<a id="csrf_2_6"
			href="${pageContext.request.contextPath}/csrf/csrfHeadSet?method=PUT">02_06_HeadNormalCsrfTokenSend_HttpMethodPut</a>
<br/>
<a id="csrf_2_7"
			href="${pageContext.request.contextPath}/csrf/csrfHeadSet?method=PUT">02_07_HeadAlterCsrfTokenSend_HttpMethodPut</a>
<br/>
<a id="csrf_2_8"
			href="${pageContext.request.contextPath}/csrf/csrfHeadSet?method=PATCH">02_08_HeadNormalCsrfTokenSend_HttpMethodPatch</a>
<br/>
<a id="csrf_2_9"
			href="${pageContext.request.contextPath}/csrf/csrfHeadSet?method=PATCH">02_09_HeadAlterCsrfTokenSend_HttpMethodPatch</a>
<br/>
<a id="csrf_2_10"
			href="${pageContext.request.contextPath}/csrf/csrfHeadSet?method=DELETE">02_10_HeadNormalCsrfTokenSend_HttpMethodDelete</a>
<br/>
<a id="csrf_2_11"
			href="${pageContext.request.contextPath}/csrf/csrfHeadSet?method=DELETE">02_11_HeadAlterCsrfTokenSend_HttpMethodDelete</a>
<br/>

<hr/>
<a id="csrf_3_1"
			href="${pageContext.request.contextPath}/csrf/fileUpload">03_01_SpringFormNormalCsrfTokenSend_HttpMethodPost_MultiPart</a>
<br/>
<a id="csrf_3_2"
			href="${pageContext.request.contextPath}/csrf/fileUpload">03_02_SpringFormAlterCsrfTokenSend_HttpMethodPost_MultiPart</a>
<br/>
<a id="csrf_3_3"
			href="${pageContext.request.contextPath}/csrf/fileUpload">03_03_FormNormalCsrfTokenSend_HttpMethodPost_MultiPart</a>
<br/>
<a id="csrf_3_4"
			href="${pageContext.request.contextPath}/csrf/fileUpload">03_04_FormAlterCsrfTokenSend_HttpMethodPost_MultiPart</a>
<br/>
<a id="csrf_3_5"
			href="${pageContext.request.contextPath}/csrf/fileUpload">03_05_SpringFormNormalCsrfTokenQuerySend_HttpMethodPost_MultiPart</a>
<br/>
<a id="csrf_3_6"
			href="${pageContext.request.contextPath}/csrf/fileUpload">03_06_SpringFormAlterCsrfTokenQuerySend_HttpMethodPost_MultiPart</a>
<br/>

<hr/>
<form:form
	action="${pageContext.request.contextPath}/csrf/errorPageNotSet/4_1"
	method="POST">
	<input type="submit" id="csrf_4_1" class="mainbtn-wide" value="04_01_ErrorPagePropertyNotSet_HttpMethodPost" />
</form:form>
<form:form
	action="${pageContext.request.contextPath}/csrf/notAcceptable/4_2"
	method="POST">
	<input type="submit" id="csrf_4_2" class="mainbtn-wide" value="04_02_406StatusCodeReturn_HttpMethodPost" />
</form:form>

