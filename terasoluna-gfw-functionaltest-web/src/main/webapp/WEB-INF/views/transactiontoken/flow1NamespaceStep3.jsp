<h2>Step-2 : Transaction token value is updated !!!</h2>
<form:form action="${pageContext.request.contextPath}/transactiontoken/flow1_namespace" method="post">
    <b>Transaction token value is : <span id="result"></span></b>
    <br />
    <br />
    <input id="btn-end" name="finalize" class="mainbtn" style="width: 200px" type="submit" value="Next" />
    <br />
    <input id="btn-check" name="check" class="mainbtn" style="width: 200px" type="submit" value="Check" />
    <br />
</form:form>

<script type="text/javascript">
    document.getElementById("result").innerHTML = document.getElementsByName("_TRANSACTION_TOKEN")[0].value;
</script>
