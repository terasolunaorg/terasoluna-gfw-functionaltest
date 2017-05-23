<h2 id="screenTitle">Confirm of Codepoints</h2>
<p>
  ExcludedCodepointsSize: <span id="excludedCodepointsSize">${excludedCodePoints.size()}</span><br />
</p>
<c:if test="${not empty excludedCodePoints}">
  <table>
    <tr>
      <th>excludedCodePoint(s)</th>
    </tr>
    <c:forEach var="excludedCodePoint" items="${excludedCodePoints}" varStatus="status">
      <tr>
        <td><span id="excludedCodePoint${status.count}">${f:h(excludedCodePoint)}</span></td>
      </tr>
    </c:forEach>
  </table>
</c:if>
