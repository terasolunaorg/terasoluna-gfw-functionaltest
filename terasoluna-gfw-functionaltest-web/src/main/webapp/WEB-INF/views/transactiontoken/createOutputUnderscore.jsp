<h2>Transaction token is generated !!!</h2>
<form:form action="${pageContext.request.contextPath}/transactiontoken/createWithUnderscore/1_2"
  method="POST">

  <b>Transaction token value is : <span id="result"></span></b>
  <br>
  <br>
  <input id="btn-next" class="mainbtn" style="width: 200px;" type="submit" value="Next " />
</form:form>

<script type="text/javascript">
	document.getElementById("result").innerHTML = document
			.getElementsByName('_TRANSACTION_TOKEN')[0].value;
</script>
