<h2>CodeList Function Test</h2>

<label>Change Locale Link</label>
<a href="${pageContext.request.contextPath}/codelist?locale=en">English</a>
<a href="${pageContext.request.contextPath}/codelist?locale=ja_JP">Japanese</a>
<a href="${pageContext.request.contextPath}/codelist?locale=fr">French</a>
<a href="${pageContext.request.contextPath}/codelist?locale=cn">Chinese</a>
<br>
<br>
<table>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/01_01_form">SimpleCodeList
        Test</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/01_02_form">SimpleCodeList
        Test (CodeList is empty)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/02_01_form">
        NumberRangeCodeList Test (Ascending)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/02_02_form">NumberRangeCodeList
        Test (Descending)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/02_03_form">NumberRangeCodeList
        Test (Interval specified)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/02_04_form">NumberRangeCodeList
        Test (Format specified)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/jdbcCodeListTestReflesh">JdbcCodeList
        Test</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/jdbcCodeListTestCodeListIsEmpty">JdbcCodeList
        Test (CodeList is empty)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/jdbcCodeListTestDBError">JdbcCodeList
        Test (DB error occurs)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/jdbcCodeListTestReflesh">JdbcCodeList
        Test (Refresh functionality)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/06_01_form">SimpleI18nCodeList
        Test (EN and JP set using rows. Click English)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/06_01_form">SimpleI18nCodeList
        Test (EN and JP set using rows. Click Japanese)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/06_01_form">SimpleI18nCodeList
        Test (EN and JP set using rows. fallbackTo not set. Click French)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/fallbackToEn/06_04_form">SimpleI18nCodeList
        Test (EN and JP set using rows. fallbackTo is set to EN. Click French)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/fallbackToFr/06_05_form">SimpleI18nCodeList
        Test (EN and JP set using rows. fallbackTo is set to FR. Click Chinese)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/06_06_form">SimpleI18nCodeList
        Test (EN and JP set using rowsByCodeList. Click English)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/06_07_form">SimpleI18nCodeList
        Test (EN and JP set using rowsByCodeList. Click Japanese)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/06_08_form">SimpleI18nCodeList
        Test (EN and JP set using rowsByCodeList. fallbackTo not set. Click French)</a></td>
  </tr>

  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/06_09_form">SimpleI18nCodeList
        Test (EN and JP set using columns. Click English)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/06_10_form">SimpleI18nCodeList
        Test (EN and JP set using columns. Click Japanese)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/06_11_form">SimpleI18nCodeList
        Test (EN and JP set using columns. fallbackTo not set. Click French)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/07_01_form">CodeListInteceptor
        Test (codeListPattern is set)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/multiplePattern/07_03_form">CodeListInteceptor
        Test (codeListPattern is changed)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/08_01_form">@ExistInCodeList
        Test (String)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/08_02_form">@ExistInCodeList
        Test (Character)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/08_03_form">@ExistInCodeList
        Test (specified codelist does not exist)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/08_04_form">@ExistInCodeList
        Test (Used as method annotation)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/08_05_form">@ExistInCodeList
        Test (Custom message)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/08_06_form">@ExistInCodeList
        Test (Extended codelist)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/08_07_form">@ExistInCodeList
        Test (Multiple Custom codelist)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/08_08_form">@ExistInCodeList
        Test (Used as param annotation)</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/09_01_form">EnumCodeList Test</a></td>
  </tr>
  <tr>
    <td><a href="${pageContext.request.contextPath}/codelist/10_01_form">CodeListInterceptor
        Test (Exception occurs)</a></td>
  </tr>
</table>
