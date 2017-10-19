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
        <td>${f:h(map.key)}</td>
        <td id="${status1.count}_${f:h(map.key)}">${f:h(map.value)}</td>
      </tr>
    </c:forEach>

  </table>
</body>
</html>