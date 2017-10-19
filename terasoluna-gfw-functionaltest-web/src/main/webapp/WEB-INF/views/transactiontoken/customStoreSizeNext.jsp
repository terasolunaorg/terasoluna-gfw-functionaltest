<h2>Step-1 : Transaction token is generated !!!</h2>
<b>Transaction token value is : <span id="result"></span></b>

<form:form
  action="${pageContext.request.contextPath}/transactiontoken/customTransactionStoreSize2/createFlow_1"
  method="post">
  <br>
  <input id="btn-in1" name="intermediate" class="mainbtn" style="width: 400px;" type="submit"
    value="customTransactionStoreSize2/createFlow_1 Next" />
  <br>
  <br>
  <input id="btn-in1-other" name="intermediateOther" class="mainbtn" style="width: 400px;"
    type="submit" value="Other non conflicting Next" />
  <br>
</form:form>

<form:form
  action="${pageContext.request.contextPath}/transactiontoken/customTransactionStoreSize2/createFlow_2"
  method="post">
  <br>
  <input id="btn-in2" name="intermediate" class="mainbtn" style="width: 400px;" type="submit"
    value="customTransactionStoreSize2/createFlow_2 Next" />
  <br>
</form:form>

<form:form
  action="${pageContext.request.contextPath}/transactiontoken/customTransactionStoreSize1/createFlow"
  method="post">
  <br>
  <input id="btn-in3" name="intermediate" class="mainbtn" style="width: 400px;" type="submit"
    value="customTransactionStoreSize1/createFlow Next" />
  <br>
</form:form>

<form action="${pageContext.request.contextPath}/transactiontoken" method="get" target="_blank">
  <br> <input id="open-new-window" class="mainbtn" style="width: 400px;" type="submit"
    value="Open New Window">
</form>

<script type="text/javascript">
	document.getElementById("result").innerHTML = document
			.getElementsByName('_TRANSACTION_TOKEN')[0].value;
</script>
