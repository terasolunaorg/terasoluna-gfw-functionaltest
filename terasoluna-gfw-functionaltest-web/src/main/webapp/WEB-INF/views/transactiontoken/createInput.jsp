
<h2>Token generation and contents confirmation</h2>
<br>
<form:form action="${pageContext.request.contextPath}/transactiontoken/create/1_1" method="post">
  <input id="btn1" class="mainbtn" style="width: 400px;" type="submit"
    value="Namespace with Class value only" />
</form:form>
<br>
<form:form action="${pageContext.request.contextPath}/transactiontoken/create/1_2" method="post">
  <input id="btn2" class="mainbtn" style="width: 400px;" type="submit"
    value="Namespace with Class and method value" />
</form:form>
<br>
<form:form action="${pageContext.request.contextPath}/transactiontoken/create/1_3" method="post">
  <input id="btn3" class="mainbtn" style="width: 400px;" type="submit"
    value="Namespace with method value only " />
</form:form>
<br>
<form:form action="${pageContext.request.contextPath}/transactiontoken/create/1_4" method="post">
  <input id="btn4" class="mainbtn" style="width: 400px;" type="submit"
    value="Namespace with neither class nor method value" />
</form:form>
<br>
<form:form action="${pageContext.request.contextPath}/transactiontoken/createWithUnderscore/1_1"
  method="post">
  <input id="btn5" class="mainbtn" style="width: 400px;" type="submit"
    value="Namespace with underscore" />
</form:form>
<br>
