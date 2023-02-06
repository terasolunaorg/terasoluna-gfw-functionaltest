<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/style.css"
  type="text/css" media="screen, projection">
<script type="text/javascript"
  src="${pageContext.request.contextPath}/resources/vendor/js/jquery-1.7.2.js"></script>

<c:set var="titleKey" value="title.date.index" />
<title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
</head>
<body>
  <div class="wrapper">
    <jsp:include page="/WEB-INF/views/layout/header.jsp" />

<h2>Date Test</h2>

<table>
  <tr>
    <td><a id="serverTimeReturn_01_01" href="${pageContext.request.contextPath}/date/1_1">serverTimeReturn_01_01</a>
    </td>
  </tr>
  <tr>
    <td><a id="serverTimeReturn_01_02" href="${pageContext.request.contextPath}/date/1_2">serverTimeReturn_01_02</a>
    </td>
  </tr>
  <tr>
    <td><a id="serverTimeReturn_01_03" href="${pageContext.request.contextPath}/date/1_3">serverTimeReturn_01_03</a>
    </td>
  </tr>
  <tr>
    <td><a id="serverTimeReturn_01_04" href="${pageContext.request.contextPath}/date/1_4">serverTimeReturn_01_04</a>
    </td>
  </tr>
  <tr>
    <td><a id="serverTimeReturn_01_05" href="${pageContext.request.contextPath}/date/1_5">serverTimeReturn_01_05</a>
    </td>
  </tr>
  <tr>
    <td><a id="dbFixationTimeReturn_02_01" href="${pageContext.request.contextPath}/date/2_1">dbFixationTimeReturn_02_01</a>
    </td>
  </tr>
  <tr>
    <td><a id="dbFixationTimeReturn_02_02" href="${pageContext.request.contextPath}/date/2_2">dbFixationTimeReturn_02_02</a>
    </td>
  </tr>
  <tr>
    <td><a id="dbFixationTimeReturn_02_03" href="${pageContext.request.contextPath}/date/2_3">dbFixationTimeReturn_02_03</a>
    </td>
  </tr>
  <tr>
    <td><a id="dbFixationTimeReturn_02_04" href="${pageContext.request.contextPath}/date/2_4">dbFixationTimeReturn_02_04</a>
    </td>
  </tr>
  <tr>
    <td><a id="dbFixationTimeReturn_02_05" href="${pageContext.request.contextPath}/date/2_5">dbFixationTimeReturn_02_05</a>
    </td>
  </tr>
  <tr>
    <td><a id="dbFixationTimeReturn_02_06" href="${pageContext.request.contextPath}/date/2_6">dbFixationTimeReturn_02_06</a>
    </td>
  </tr>
  <tr>
    <td><a id="adjustedDateReturn_03_01" href="${pageContext.request.contextPath}/date/3_1">adjustedDateReturn_03_01</a>
    </td>
  </tr>
  <tr>
    <td><a id="adjustedDateReturn_03_02" href="${pageContext.request.contextPath}/date/3_2">adjustedDateReturn_03_02</a>
    </td>
  </tr>
  <tr>
    <td><a id="adjustedDateReturn_03_03" href="${pageContext.request.contextPath}/date/3_3">adjustedDateReturn_03_03</a>
    </td>
  </tr>
  <tr>
    <td><a id="adjustedDateReturn_03_04" href="${pageContext.request.contextPath}/date/3_4">adjustedDateReturn_03_04</a>
    </td>
  </tr>
  <tr>
    <td><a id="adjustedDateReturn_03_05" href="${pageContext.request.contextPath}/date/3_5">adjustedDateReturn_03_05</a>
    </td>
  </tr>
  <tr>
    <td><a id="adjustedDateReturn_03_06" href="${pageContext.request.contextPath}/date/3_6">adjustedDateReturn_03_06</a>
    </td>
  </tr>
  <tr>
    <td><a id="adjustedDateReturn_03_07" href="${pageContext.request.contextPath}/date/3_7">adjustedDateReturn_03_07</a>
    </td>
  </tr>
  <tr>
    <td><a id="adjustedDateReturn_03_08" href="${pageContext.request.contextPath}/date/3_8">adjustedDateReturn_03_08</a>
    </td>
  </tr>
  <tr>
    <td><a id="adjustedDateReturn_03_09" href="${pageContext.request.contextPath}/date/3_9">adjustedDateReturn_03_09</a>
    </td>
  </tr>
  <tr>
    <td><a id="adjustedDateReturn_03_10" href="${pageContext.request.contextPath}/date/3_10">adjustedDateReturn_03_10</a>
    </td>
  </tr>
  <tr>
    <td><a id="adjustedDateReturn_03_11" href="${pageContext.request.contextPath}/date/3_11">adjustedDateReturn_03_11</a>
    </td>
  </tr>
  <tr>
    <td><a id="adjustedDateReturn_03_12" href="${pageContext.request.contextPath}/date/3_12">adjustedDateReturn_03_12</a>
    </td>
  </tr>
  <tr>
    <td><a id="management" href="${pageContext.request.contextPath}/date/manage">Management
        Screen</a></td>
  </tr>
</table>

    <hr>
    <p align="right">
      Application Server : <span id="apServerName"><spring:eval
          expression="@environment.getProperty('application.server.name')" /></span> <span
        id="apServerVersion"><spring:eval
          expression="@environment.getProperty('application.server.version')" /></span>
    </p>
    <p style="text-align: center; background: #e5eCf9;">
      <spring:message code="copyright" htmlEscape="false" />
      <span id="xtrack">(X-Track:${f:h(requestScope["X-Track"])})</span>
    </p>
  </div>
</body>
</html>