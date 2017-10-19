<html>
<h2>Sequencer Function Test (GET CURRENT VALUE)</h2>
<body>
  <table>
    <tr>
      <td>CURRENT VALUE</td>
      <td id="currval">${f:h(currval)}</td>
    </tr>
  </table>
  <table>
    <tr>
      <td>Get Next Sequence.</td>
      <td>Get Current Sequence.</td>
    </tr>
    <tr>
      <td><a id="1_1_next" href="${pageContext.request.contextPath}/sequencer/1_1?next">sequncer_Integer_getNext()_1_1</a>
      </td>
      <td><a id="1_1_current" href="${pageContext.request.contextPath}/sequencer/1_1?current">sequncer_Integer_getCurrent()_1_1</a>
      </td>
    </tr>
    <tr>
      <td><a id="1_2_next" href="${pageContext.request.contextPath}/sequencer/1_2?next">sequncer_Long_getNext()_1_2</a>
      </td>
      <td><a id="1_2_current" href="${pageContext.request.contextPath}/sequencer/1_2?current">sequncer_Long_getCurrent()_1_2</a>
      </td>
    </tr>
    <tr>
      <td><a id="1_3_next" href="${pageContext.request.contextPath}/sequencer/1_3?next">sequncer_BigInteger_getNext()1_3</a>
      </td>
      <td><a id="1_3_current" href="${pageContext.request.contextPath}/sequencer/1_3?current">sequncer_BigInteger_getCurrent()1_3</a>
      </td>
    </tr>
    <tr>
      <td><a id="1_4_next" href="${pageContext.request.contextPath}/sequencer/1_4?next">sequncer_String_getNext()_1_4</a>
      </td>
      <td><a id="1_4_current" href="${pageContext.request.contextPath}/sequencer/1_4?current">sequncer_String_getCurrent()_1_4</a>
      </td>
    </tr>
    <tr>
      <td><a id="2_1_not_found_next"
        href="${pageContext.request.contextPath}/sequencer/2_1?next">sequncer_not_found_next_2_1</a>
      </td>
      <td><a id="2_1_not_found_current"
        href="${pageContext.request.contextPath}/sequencer/2_1?current">sequncer_not_found_current_2_1</a>
      </td>
    </tr>
  </table>
</body>
</html>