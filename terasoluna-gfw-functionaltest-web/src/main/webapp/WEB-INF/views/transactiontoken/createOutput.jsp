<h2>Transaction token is generated !!!</h2>
<form:form action="${pageContext.request.contextPath}/transactiontoken/create" method="get">

  <b>Transaction token value is : <span id="result"></span></b>
  <br>
  <br>
  <input id="btnback" class="mainbtn" style="width: 200px;" type="submit" value="Back to menu " />
</form:form>

<script type="text/javascript">
	document.getElementById("result").innerHTML = document
			.getElementsByName('_TRANSACTION_TOKEN')[0].value;
</script>
