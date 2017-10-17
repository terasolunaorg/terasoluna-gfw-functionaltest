
<h2>Server Time</h2>

<span>First Expected Date</span>
<p id="firstExpectedDate">
  <fmt:formatDate value="${firstExpectedDate}" pattern="HH:mm:ss.SSS" />
</p>
<span>Server Time</span>
<p id="serverTime">
  <fmt:formatDate value="${serverTime}" pattern="HH:mm:ss.SSS" />
</p>
<span>Last Expected Date</span>
<p id="lastExpectedDate">
  <fmt:formatDate value="${lastExpectedDate}" pattern="HH:mm:ss.SSS" />
</p>

<span>Class Type</span>
<p id="type">${f:h(type)}</p>

