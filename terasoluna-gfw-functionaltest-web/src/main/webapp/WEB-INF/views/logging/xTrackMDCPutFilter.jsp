<h2>logging Function Test XTrackMDCPutFilter</h2>

<table>
  <tr>
    <td><a id="xTrackMDCPutFilterDefault"
      href="${pageContext.request.contextPath}/logging/xTrackMDCPutFilter/1_1">default attribute
        name</a></td>
  </tr>
  <tr>
    <td><a id="xTrackMDCPutFilterCustom"
      href="${pageContext.request.contextPath}/logging/xTrackMDCPutFilter/1_2">custom attribute
        name</a></td>
  </tr>
  <tr>
    <td><a id="xTrackMDCPutFilterCustom"
      href="${pageContext.request.contextPath}/logging/xTrackMDCPutFilter/1_4">Check consistency
        HTTP Request Header to Response Header</a></td>
  </tr>
</table>

<c:if test="${!(empty xTrackMDC)}">
	${f:h(attributeName)}：<div id="xTrackMDC">${f:h(xTrackMDC)}</div>
</c:if>
<c:if test="${!(empty checkResponseHeaderXTrack)}">
	response header X-Track：<div id="responseHeaderXTrack">${f:h(requestScope["X-Track"])}</div>
</c:if>
<br />
