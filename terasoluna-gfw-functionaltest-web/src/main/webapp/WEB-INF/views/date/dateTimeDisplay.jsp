
<h2>Server Time</h2>

<span>First Expected Date</span>
<p id="firstExpectedDate">
  <fmt:formatDate value="${firstExpectedDate}" pattern="yyyy-MM-dd HH:mm:ss.SSS" />
</p>
<span>Server Time</span>
<p id="serverTime">
  <joda:format value="${serverTime}" pattern="yyyy-MM-dd HH:mm:ss.SSS" />
</p>
<span>Last Expected Date</span>
<p id="lastExpectedDate">
  <fmt:formatDate value="${lastExpectedDate}" pattern="yyyy-MM-dd HH:mm:ss.SSS" />
</p>

<span>Class Type</span>
<p id="type">${f:h(type)}</p>
