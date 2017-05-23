<h2>Step-1 : Transaction token is generated !!!</h2>
<form:form action="${pageContext.request.contextPath}/transactiontoken/flow1_namespace"
  method="post">

  <b>Transaction token value is : <span id="result"></span></b>
  <br>
  <br>
  <input id="btn-in" name="intermediate" class="mainbtn" style="width: 200px;" type="submit"
    value="Next" />
  <br>
</form:form>

<script type="text/javascript">
	document.getElementById("result").innerHTML = document
			.getElementsByName('_TRANSACTION_TOKEN')[0].value;
</script>
