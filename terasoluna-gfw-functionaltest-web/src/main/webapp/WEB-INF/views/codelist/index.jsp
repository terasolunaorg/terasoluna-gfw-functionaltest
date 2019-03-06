<h2>CodeList Function Test</h2>

<label>Change Locale Link</label>
<a href="${pageContext.request.contextPath}/codelist?locale=en">English</a>
<a href="${pageContext.request.contextPath}/codelist?locale=fr_fr">Franc</a>
<a href="${pageContext.request.contextPath}/codelist?locale=fr_ca">Canada(French)</a>
<a href="${pageContext.request.contextPath}/codelist?locale=de">German</a>
<br>
<br>
<table>
  <tr>
    <td><a id="codelist_01_01" href="${pageContext.request.contextPath}/codelist/01_01_form">SimpleCodeList
        Test</a></td>
  </tr>
  <tr>
    <td><a id="codelist_01_02" href="${pageContext.request.contextPath}/codelist/01_02_form">SimpleCodeList
        Test (CodeList is empty)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_02_01" href="${pageContext.request.contextPath}/codelist/02_01_form">
        NumberRangeCodeList Test (Ascending)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_02_02" href="${pageContext.request.contextPath}/codelist/02_02_form">NumberRangeCodeList
        Test (Descending)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_02_03" href="${pageContext.request.contextPath}/codelist/02_03_form">NumberRangeCodeList
        Test (Interval specified)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_02_04" href="${pageContext.request.contextPath}/codelist/02_04_form">NumberRangeCodeList
        Test (Format specified)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_03_01" href="${pageContext.request.contextPath}/codelist/jdbcCodeListTestReflesh">JdbcCodeList
        Test</a></td>
  </tr>
  <tr>
    <td><a id="codelist_03_02" href="${pageContext.request.contextPath}/codelist/jdbcCodeListTestCodeListIsEmpty">JdbcCodeList
        Test (CodeList is empty)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_03_03" href="${pageContext.request.contextPath}/codelist/jdbcCodeListTestDBError">JdbcCodeList
        Test (DB error occurs)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_04_02" href="${pageContext.request.contextPath}/codelist/jdbcCodeListTestReflesh">JdbcCodeList
        Test (Refresh functionality)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_06_01" href="${pageContext.request.contextPath}/codelist/06_01_form">SimpleI18nCodeList
        Test (EN and JP set using rows)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_06_02" href="${pageContext.request.contextPath}/codelist/06_02_form">SimpleI18nCodeList
        Test (EN and JP set using rowsByCodeList)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_06_03" href="${pageContext.request.contextPath}/codelist/06_03_form">SimpleI18nCodeList
        Test (EN and JP set using columns)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_07_01" href="${pageContext.request.contextPath}/codelist/07_01_form">CodeListInteceptor
        Test (codeListPattern is set)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_07_03" href="${pageContext.request.contextPath}/codelist/multiplePattern/07_03_form">CodeListInteceptor
        Test (codeListPattern is changed)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_08_01" href="${pageContext.request.contextPath}/codelist/08_01_form">@ExistInCodeList
        Test (String)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_08_02" href="${pageContext.request.contextPath}/codelist/08_02_form">@ExistInCodeList
        Test (Character)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_08_03" href="${pageContext.request.contextPath}/codelist/08_03_form">@ExistInCodeList
        Test (specified codelist does not exist)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_08_04" href="${pageContext.request.contextPath}/codelist/08_04_form">@ExistInCodeList
        Test (Used as method annotation)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_08_05" href="${pageContext.request.contextPath}/codelist/08_05_form">@ExistInCodeList
        Test (Custom message)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_08_06" href="${pageContext.request.contextPath}/codelist/08_06_form">@ExistInCodeList
        Test (Extended codelist)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_08_07" href="${pageContext.request.contextPath}/codelist/08_07_form">@ExistInCodeList
        Test (Multiple Custom codelist)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_08_08" href="${pageContext.request.contextPath}/codelist/08_08_form">@ExistInCodeList
        Test (Used as param annotation)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_09_01" href="${pageContext.request.contextPath}/codelist/09_01_form">EnumCodeList Test</a></td>
  </tr>
  <tr>
    <td><a id="codelist_10_01" href="${pageContext.request.contextPath}/codelist/10_01_form">CodeListInterceptor
        Test (Exception occurs)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_11_01" href="${pageContext.request.contextPath}/codelist/11_01_form">SimpleI18nCodeList
        Test (specified language locale and returned in same locale)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_11_02" href="${pageContext.request.contextPath}/codelist/11_01_form">SimpleI18nCodeList
        Test (specified nation locale and returned in same locale)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_11_03" href="${pageContext.request.contextPath}/codelist/11_01_form">SimpleI18nCodeList
        Test (specified nation locale and returned in fallback language locale)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_11_04" href="${pageContext.request.contextPath}/codelist/11_01_form">SimpleI18nCodeList
        Test (specified language locale and returned in fallbackTo locale)</a></td>
  </tr>
  <tr>
    <td><a id="codelist_11_05" href="${pageContext.request.contextPath}/codelist/11_05_form">SimpleI18nCodeList
        Test (specified language locale and returned in fallback default locale)</a></td>
  </tr>
</table>
