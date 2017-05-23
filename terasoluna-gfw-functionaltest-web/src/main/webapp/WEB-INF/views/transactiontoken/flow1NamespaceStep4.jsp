<h2>Step-3 Flow Complete : Transaction token is destroyed !!!</h2>
<form:form action="${pageContext.request.contextPath}/transactiontoken/flow_namespace" method="get">

  <span id="result"></span>
  <br>
  <br>
  <input id="btn-back" class="mainbtn" style="width: 200px;" type="submit" value="Start Over" />
</form:form>

<script type="text/javascript">
	if (document.getElementsByName('_TRANSACTION_TOKEN')[0] == null) {
		document.getElementById("result").innerHTML = null;
	}
</script>
