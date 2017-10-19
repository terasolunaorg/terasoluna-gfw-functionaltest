
<h2>Transaction token lifecycle (flow) confirmation</h2>
<br>
<form:form action="${pageContext.request.contextPath}/transactiontoken/flow1/" method="post">
  <input id="btn-flow1" name="confirm" class="mainbtn" style="width: 400px;" type="submit"
    value="BEGIN-IN-CHECK-END (Custom namespace)" />
</form:form>
<br>
<form:form action="${pageContext.request.contextPath}/transactiontoken/flow2/" method="post">
  <input id="btn-flow2" name="confirm" class="mainbtn" style="width: 400px;" type="submit"
    value="BEGIN-IN-CHECK-END (GlobalToken)" />
</form:form>
<br>
<form:form action="${pageContext.request.contextPath}/transactiontoken/flow1/" method="post">
  <input id="btn-flow4" name="finalize" class="mainbtn" style="width: 400px;" type="submit"
    value="END Without BEGIN" />
</form:form>
<br>
<form:form action="${pageContext.request.contextPath}/transactiontoken/flow1/" method="post">
  <input id="btn-flow3" name="intermediate" class="mainbtn" style="width: 400px;" type="submit"
    value="IN Without BEGIN" />
</form:form>
<br>
<form:form action="${pageContext.request.contextPath}/transactiontoken/flow1/" method="post">
  <input id="btn-flow8" name="check" class="mainbtn" style="width: 400px;" type="submit"
    value="CHECK Without BEGIN" />
</form:form>
<br>
<form:form action="${pageContext.request.contextPath}/transactiontoken/flow1/" method="post">
  <input id="btn-flow5_1" name="confirmError" class="mainbtn" style="width: 400px;" type="submit"
    value="Begin returning Input Error" />
  <input id="btn-flow5_2" name="confirm" class="mainbtn" style="width: 400px;" type="submit"
    value="Begin called with Transaction Token" />
</form:form>
<br>
<form:form action="${pageContext.request.contextPath}/transactiontoken/flow6/" method="post">
  <input id="btn-flow6" name="confirm" class="mainbtn" style="width: 400px;" type="submit"
    value="BEGIN and display generated token using t:transaction" />
</form:form>
<br>
<form:form action="${pageContext.request.contextPath}/transactiontoken/flow1/" method="post">
  <input id="btn-flow7" name="confirmDiffNamespace" class="mainbtn" style="width: 400px;"
    type="submit" value="IN/END Token mismatch" />
</form:form>
<br>
