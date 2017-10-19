<h2>EL Function Test</h2>

<table>
  <tr>
    <td><a id="01" href="${pageContext.request.contextPath}/el/1">XSS_Measures(f:h())</a></td>
  </tr>
  <tr>
    <td><a id="02" href="${pageContext.request.contextPath}/el/2">URL_Encoding(f:u())</a></td>
  </tr>
  <tr>
    <td><a id="03" href="${pageContext.request.contextPath}/el/3">New_Line(f:br())</a></td>
  </tr>
  <tr>
    <td><a id="04" href="${pageContext.request.contextPath}/el/4">Cut_String(f:cut())</a></td>
  </tr>
  <tr>
    <td><a id="05" href="${pageContext.request.contextPath}/el/5">URL_Link(f:link())</a></td>
  </tr>
  <tr>
    <td><a id="05_04" href="${pageContext.request.contextPath}/el/5_4">URL_Link(f:link()
        and f:u())</a></td>
  </tr>
  <tr>
    <td><a id="06_01-02" href="${pageContext.request.contextPath}/el/6_1-2">Query_Display(f:query(Map))</a>
    </td>
  </tr>
  <tr>
    <td><a id="06_03-" href="${pageContext.request.contextPath}/el/6_3-">Query_Display(f:query(Bean))</a>
    </td>
  </tr>
  <tr>
    <td><a id="06_07" href="${pageContext.request.contextPath}/el/6_7">Query_Display(f:query(No
        Support Object))</a></td>
  </tr>
  <tr>
    <td><a id="06_09" href="${pageContext.request.contextPath}/el/6_9">Query_Display(f:query(NestedJavaBean))</a></td>
  </tr>
  <tr>
    <td><a id="06_10" href="${pageContext.request.contextPath}/el/6_10">Query_Display(f:query(ListOfJavaBean))</a></td>
  </tr>
  <tr>
    <td><a id="06_11" href="${pageContext.request.contextPath}/el/6_11">Query_Display(f:query(SimpleJavaBeanAndListOfJavaBean))</a></td>
  </tr>
  <tr>
    <td><a id="06_12" href="${pageContext.request.contextPath}/el/6_12">Query_Display(f:query(MapOfSimpleValue))</a></td>
  </tr>
  <tr>
    <td><a id="06_13" href="${pageContext.request.contextPath}/el/6_13">Query_Display(f:query(DateTimeFormat))</a></td>
  </tr>
  <tr>
    <td><a id="06_14" href="${pageContext.request.contextPath}/el/6_14">Query_Display(f:query(Array))</a></td>
  </tr>
  <tr>
    <td><a id="06_15" href="${pageContext.request.contextPath}/el/6_15">Query_Display(f:query(SimpleJavaBean))
        with StringTrimmerEditor</a></td>
  </tr>
  <tr>
    <td><a id="06_16" href="${pageContext.request.contextPath}/el/6_16">Query_Display(f:query(ListOfSimpleValue))
        with StringTrimmerEditor</a></td>
  </tr>
  <tr>
    <td><a id="06_17" href="${pageContext.request.contextPath}/el/6_17">Query_Display(f:query(MapOfSimpleValue))
        with StringTrimmerEditor</a></td>
  </tr>
  <tr>
    <td><a id="07_01" href="${pageContext.request.contextPath}/el/7_1">JavaScript_XSS_Measures(f:js(''))</a>
    </td>
  </tr>
  <tr>
    <td><a id="07_02" href="${pageContext.request.contextPath}/el/7_2">JavaScript_XSS_Measures(f:js(""))</a>
    </td>
  </tr>
  <tr>
    <td><a id="07_03" href="${pageContext.request.contextPath}/el/7_3">JavaScript_XSS_Measures(f:js(no
        escape string))</a></td>
  </tr>
  <tr>
    <td><a id="08_01" href="${pageContext.request.contextPath}/el/8_1">EventHandler_XSS_Measures(f:hjs(''))</a>
    </td>
  </tr>
  <tr>
    <td><a id="08_02" href="${pageContext.request.contextPath}/el/8_2">EventHandler_XSS_Measures(f:hjs(""))</a>
    </td>
  </tr>
  <tr>
    <td><a id="08_03" href="${pageContext.request.contextPath}/el/8_3">EventHandler_XSS_Measures(f:hjs(no
        escape string))</a></td>
  </tr>
</table>