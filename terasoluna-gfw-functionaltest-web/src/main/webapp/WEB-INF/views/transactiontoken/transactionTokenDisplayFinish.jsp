<form action="${pageContext.request.contextPath}/transactiontoken/flow6" method="post">
  <t:transaction />
  <b>Transaction token UPDATED value is : <span id="result"></span></b> <input type="hidden"
    name="${_csrf.parameterName}" value="${_csrf.token}" /> <br> <br> <input
    id="btn-error" name="create" class="mainbtn" style="width: 200px;" type="submit"
    value="Next and Error" /> <br>
</form>

<script type="text/javascript">
    document.getElementById("result").innerHTML = document
            .getElementsByName('_TRANSACTION_TOKEN')[0].value;
</script>
