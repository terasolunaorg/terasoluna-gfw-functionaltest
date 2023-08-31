<hr>
<p align="right">
  Application Server : <span id="apServerName"><%= application.getServerInfo() %></span>
</p>
<p style="text-align: center; background: #e5eCf9;">
  <spring:message code="copyright" htmlEscape="false" />
  <span id="xtrack">(X-Track:${f:h(requestScope["X-Track"])})</span>
</p>