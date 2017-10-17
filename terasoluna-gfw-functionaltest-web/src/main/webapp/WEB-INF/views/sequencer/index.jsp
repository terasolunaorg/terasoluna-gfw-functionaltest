<html>
<h2>Sequencer Function Test</h2>
<body>
  <table>
    <tr>
      <td><a id="1_1_same_transaction"
        href="${pageContext.request.contextPath}/sequencer/1_1?sameTransaction">sequncer_Integer_same_transaction()_1_1</a>
      </td>
    </tr>
    <tr>
      <td><a id="1_2_same_transaction"
        href="${pageContext.request.contextPath}/sequencer/1_2?sameTransaction">sequncer_Long_same_transaction()_1_2</a>
      </td>
    </tr>
    <tr>
      <td><a id="1_3_same_transaction"
        href="${pageContext.request.contextPath}/sequencer/1_3?sameTransaction">sequncer_BigInteger_same_transaction()_1_3</a>
      </td>
    </tr>
    <tr>
      <td><a id="1_4_same_transaction"
        href="${pageContext.request.contextPath}/sequencer/1_4?sameTransaction">sequncer_String_same_transaction()_1_4</a>
      </td>
    </tr>
    <tr>
      <td><a id="2_1_not_found_next"
        href="${pageContext.request.contextPath}/sequencer/2_1?next">sequncer_not_found_next_2_1</a>
      </td>
    </tr>
    <tr>
      <td><a id="2_1_not_found_current"
        href="${pageContext.request.contextPath}/sequencer/2_1?current">sequncer_not_found_current_2_1</a>
      </td>
    </tr>
  </table>
</body>
</html>