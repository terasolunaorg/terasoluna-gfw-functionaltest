<html>
<h2>Transaction Token Function Test</h2>
<body>
  <table>

    <!-- Transaction token generation test scenarios -->
    <tr>
      <td><a id="link1" href="${pageContext.request.contextPath}/transactiontoken/create">Transaction
          Token Contents Confirmation</a></td>
    </tr>

    <!-- Transaction token type scenarios -->
    <tr>
      <td><a id="link2" href="${pageContext.request.contextPath}/transactiontoken/flow">TransactionTokenType
          : BEGIN-IN-CHECK-END</a></td>
    </tr>

    <!-- Transaction token store custom size scenarios -->
    <tr>
      <td><a id="link3"
        href="${pageContext.request.contextPath}/transactiontoken/customTransactionStoreSize2/index">Transaction
          Store Custom Size Testing- Custom Namespace</a></td>
    </tr>
    <tr>
      <td><a id="link4"
        href="${pageContext.request.contextPath}/transactiontoken/customTransactionStoreSize1/index">Transaction
          Store Custom Size Testing- Global Namespace</a></td>
    </tr>

    <!-- Transaction token type scenarios @AliasFor namespace-->
    <tr>
      <td><a id="link5"
        href="${pageContext.request.contextPath}/transactiontoken/flow_namespace">TransactionTokenType
          : BEGIN-IN-CHECK-END @AliasFor namespace</a></td>
    </tr>
  </table>
</body>
</html>















