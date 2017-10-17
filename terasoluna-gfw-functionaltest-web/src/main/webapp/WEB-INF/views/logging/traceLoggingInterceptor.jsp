<h2>logging Function Test traceLoggingInterceptor</h2>

<table>
  <tr>
    <td><a id="traceLoggingDefaultAsTraceLevel"
      href="${pageContext.request.contextPath}/logging/traceLoggingInterceptor/defaultWarnHandling/4_1">Default
        traceLogging as trace level</a></td>
  </tr>
  <tr>
    <td><a id="traceLoggingDefaultAsWarnLevel"
      href="${pageContext.request.contextPath}/logging/traceLoggingInterceptor/defaultWarnHandling/4_2">Default
        traceLogging as warm level</a></td>
  </tr>
  <tr>
    <td><a id="traceLoggingCustomAsTraceLevel"
      href="${pageContext.request.contextPath}/logging/traceLoggingInterceptor/customWarnHandling/4_3">Custom
        traceLogging as trace level</a></td>
  </tr>
  <tr>
    <td><a id="traceLoggingCustomAsWarnLevel"
      href="${pageContext.request.contextPath}/logging/traceLoggingInterceptor/customWarnHandling/4_4">Custom
        traceLogging as warm level</a></td>
  </tr>
</table>

<c:if test="${!(empty processingTime)}">
	 ${f:h(requestType)}
	<br />
	server proccessing time is ：&nbsp;${f:h(processingTime)}ms
</c:if>

