<h2>Transaction Token Custom Size Testing</h2>

<form:form
  action="${pageContext.request.contextPath}/transactiontoken/customTransactionStoreSize2/createFlow_1/"
  method="post">
  <input id="btn-begin1" name="confirm" class="mainbtn" style="width: 400px;" type="submit"
    value="Size = 2, Namespace Setting = Class and Method" />
  <br>
  <br>
  <input id="btn-begin1-other" name="confirmOther" class="mainbtn" style="width: 400px;"
    type="submit" value="Other non conflicting operation" />
</form:form>
<br>
<form:form
  action="${pageContext.request.contextPath}/transactiontoken/customTransactionStoreSize2/createFlow_2/"
  method="post">
  <input id="btn-begin2" name="confirm" class="mainbtn" style="width: 400px;" type="submit"
    value="Size = 2, Namespace Setting = Method only" />
</form:form>
<br>
<form:form
  action="${pageContext.request.contextPath}/transactiontoken/customTransactionStoreSize1/createFlow/"
  method="post">
  <input id="btn-begin3" name="confirm" class="mainbtn" style="width: 400px;" type="submit"
    value="Size = 1, Namespace Setting = global" />
</form:form>
<br>
