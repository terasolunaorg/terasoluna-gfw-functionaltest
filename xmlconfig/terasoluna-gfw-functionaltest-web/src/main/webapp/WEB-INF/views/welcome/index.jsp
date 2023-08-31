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

<c:set var="titleKey" value="title.welcome.index" />
<title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
</head>
<body>
  <div class="wrapper">
    <jsp:include page="/WEB-INF/views/layout/header.jsp" />

<h2>Welcome!</h2>
  <table>
    <tr>
      <td><a id="Pagination" href="${pageContext.request.contextPath}/pagination">Pagination
          Function Test</a></td>
    </tr>
    <tr>
      <td><a id="Transaction" href="${pageContext.request.contextPath}/transactiontoken">Transaction
          Token Test</a></td>
    </tr>
    <tr>
      <td><a id="Message" href="${pageContext.request.contextPath}/message">Message
          Function Test</a></td>
    </tr>
    <tr>
      <td><a id="Codelist" href="${pageContext.request.contextPath}/codelist">CodeList
          Function Test</a></td>
    </tr>
    <tr>
      <td><a id="CodePoints" href="${pageContext.request.contextPath}/codepoints">CodePoints
          Function Test</a></td>
    </tr>
    <tr>
      <td><a id="Exception" href="${pageContext.request.contextPath}/exceptionhandling">Exception
          Function Test</a></td>
    </tr>
    <tr>
      <td><a id="Sequencer" href="${pageContext.request.contextPath}/sequencer">Sequencer
          Function Test</a></td>
    </tr>
    <tr>
      <td><a id="QueryEscape" href="${pageContext.request.contextPath}/queryescape">
          QueryEscape Function Test</a></td>
    </tr>
    <tr>
      <td><a id="Date" href="${pageContext.request.contextPath}/date">Date Function Test</a></td>
    </tr>
    <tr>
      <td><a id="Time" href="${pageContext.request.contextPath}/time">JSR-310 Date And Time Function Test</a></td>
    </tr>
    <tr>
      <td><a id="Download" href="${pageContext.request.contextPath}/download">Download
          Function Test</a></td>
    </tr>
    <tr>
      <td><a id="logging" href="${pageContext.request.contextPath}/logging">Logging
          Function Test</a></td>
    </tr>
    <tr>
      <td><a id="EL" href="${pageContext.request.contextPath}/el">EL Function Test</a></td>
    </tr>
    <tr>
      <td><a id="Validation" href="${pageContext.request.contextPath}/validation">Validation
          Function Test</a></td>
    </tr>
    <tr>
      <td><a id="String" href="${pageContext.request.contextPath}/string">String Processes
          Function Test</a></td>
    </tr>
  </table>

    <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
  </div>
</body>
</html>