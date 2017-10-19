
<h2>Query Display f:query(ListOfSimpleValue) with StringTrimmerEditor</h2>

<span>Input Data</span>
<form:form action="${pageContext.request.contextPath}/el/6_16/search" method="GET"
  modelAttribute="listForm">
  <fieldset>
    <legend>Nested Bean(Parent)</legend>
    <table>
      <thead>
        <tr>
          <th>listA(0):String</th>
          <th>listA(1):String</th>
          <th>listA(2):String</th>
          <th>listB:String</th>
          <th>listC:String</th>
        </tr>
      </thead>
      <tr>
        <td><form:input path="listA[0]" /></td>
        <td><form:input path="listA[1]" /></td>
        <td><form:input path="listA[2]" /></td>
        <td><form:checkbox path="listB" value="b0" label="b0" /><br> <form:checkbox
            path="listB" value="b1" label="b1" /><br> <form:checkbox path="listB" value="b2"
            label="b2" /><br></td>
        <td><form:select path="listC">
            <form:option value="" label="--Please Select(Multiple)" />
            <form:option value="c0">c0</form:option>
            <form:option value="c1">c1</form:option>
            <form:option value="c2">c2</form:option>
          </form:select></td>
      </tr>
    </table>
    <fieldset>
      <legend>Nested Bean(Child)</legend>
      <table>
        <thead>
          <tr>
            <th>listA(0):String</th>
            <th>listA(1):String</th>
            <th>listA(2):String</th>
            <th>listB:String</th>
            <th>listC:String</th>
          </tr>
        </thead>
        <tr>
          <td><form:input path="item.listA[0]" /></td>
          <td><form:input path="item.listA[1]" /></td>
          <td><form:input path="item.listA[2]" /></td>
          <td><form:checkbox path="item.listB" value="bb0" label="bb0" /><br> <form:checkbox
              path="item.listB" value="bb1" label="bb1" /><br> <form:checkbox
              path="item.listB" value="bb2" label="bb2" /><br></td>
          <td><form:select path="item.listC">
              <form:option value="" label="--Please Select(Multiple)" />
              <form:option value="cc0">c0</form:option>
              <form:option value="cc1">c1</form:option>
              <form:option value="cc2">c2</form:option>
            </form:select></td>
        </tr>
      </table>
    </fieldset>
  </fieldset>
  <input type="submit" value="search" id="searchButton" />
</form:form>
<c:if test="${page != null}">
  <span>Output Data</span>
  <fieldset>
    <legend>Nested Bean(Parent)</legend>
    <table>
      <thead>
        <tr>
          <th>listA(0)</th>
          <th>listA(1)</th>
          <th>listA(2)</th>
          <th>listB</th>
          <th>listC</th>
        </tr>
      </thead>
      <tr>
        <td><p id="listA0String">${f:h(listA0String)}</p></td>
        <td><p id="listA1String">${f:h(listA1String)}</p></td>
        <td><p id="listA2String">${f:h(listA2String)}</p></td>
        <td><p id="listBString">${f:h(listBString)}</p></td>
        <td><p id="listCString">${f:h(listCString)}</p></td>
      </tr>
    </table>
    <fieldset>
      <legend>Nested Bean(Child)</legend>
      <table>
        <thead>
          <tr>
            <th>listA(0)</th>
            <th>listA(1)</th>
            <th>listA(2)</th>
            <th>listB</th>
            <th>listC</th>
          </tr>
        </thead>
        <tr>
          <td><p id="listA0StringItem">${f:h(listA0StringItem)}</p></td>
          <td><p id="listA1StringItem">${f:h(listA1StringItem)}</p></td>
          <td><p id="listA2StringItem">${f:h(listA2StringItem)}</p></td>
          <td><p id="listBStringItem">${f:h(listBStringItem)}</p></td>
          <td><p id="listCStringItem">${f:h(listCStringItem)}</p></td>
        </tr>
      </table>
    </fieldset>
  </fieldset>
</c:if>
<c:if test="${page != null}">
  <div id="pagination" class="pagination">
    <t:pagination page="${page}" criteriaQuery="${f:query(listForm)}" />
  </div>
  <table class="maintable">
    <thead>
      <tr>
        <th>Number</th>
        <th>Dummy Column</th>
      </tr>
    </thead>
    <c:forEach var="dummy" items="${page.content}" varStatus="sts">
      <tr>
        <td>${page.number * page.size + sts.index + 1}</td>
        <td>${f:h(dummy)}${page.number * page.size + sts.index + 1}</td>
      </tr>
    </c:forEach>
  </table>
</c:if>