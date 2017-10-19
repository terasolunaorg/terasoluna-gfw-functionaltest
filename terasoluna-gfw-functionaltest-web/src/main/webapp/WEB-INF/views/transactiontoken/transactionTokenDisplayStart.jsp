<form action="${pageContext.request.contextPath}/transactiontoken/flow6" method="post">
  <t:transaction />
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> <b>Transaction
    token value is : <span id="result"></span>
  </b> <br> <br> <input id="btn-in" name="create" class="mainbtn" style="width: 200px;"
    type="submit" value="Next" /> <br>
</form>

<script type="text/javascript">
    document.getElementById("result").innerHTML = document
            .getElementsByName('_TRANSACTION_TOKEN')[0].value;
</script>
