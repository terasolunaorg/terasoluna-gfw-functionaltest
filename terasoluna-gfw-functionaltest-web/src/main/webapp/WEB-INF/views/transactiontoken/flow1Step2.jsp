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

<c:set var="titleKey" value="title.transactiontoken.flow1Step2" />
<title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
</head>
<body>
  <div class="wrapper">
    <jsp:include page="/WEB-INF/views/layout/header.jsp" />

<h2>Step-1 : Transaction token is generated !!!</h2>
<form:form action="${pageContext.request.contextPath}/transactiontoken/flow1" method="post">

  <b>Transaction token value is : <span id="result"></span></b>
  <br>
  <br>
  <input id="btn-in" name="intermediate" class="mainbtn" style="width: 200px;" type="submit"
    value="Next" />
  <br>
  <input id="btn-end" name="finalize" class="mainbtn" style="width: 200px;" type="submit"
    value="Finish" />
  <br>
  <input id="btn-in-finish-error" name="intermediateWithFinishError" class="mainbtn"
    style="width: 200px;" type="submit" value="Next and Finish with Error" />
  <br>
  <input id="btn-end-error" name="finalizeError" class="mainbtn" style="width: 200px;" type="submit"
    value="Finish with Error" />
  <br>
  <input id="btn-download01" name="download01" class="mainbtn" style="width: 200px;" type="button"
    value="File download (CHECK)" />
  <br>
  <input name="redo1" class="mainbtn" style="width: 200px;" type="submit" value="Back" />
</form:form>
<br>
<form action="${pageContext.request.contextPath}/transactiontoken" method="get" target="_blank">
  <input id="open-new-window" class="mainbtn" style="width: 200px;" type="submit"
    value="Open New Window">
</form>

<script type="text/javascript">
document.getElementById("result").innerHTML = document
			.getElementsByName('_TRANSACTION_TOKEN')[0].value;


</script>

<script type="text/javascript">
function dummyDownload ( buttonId ) {
    var param = {};
    param[$(buttonId).attr('name')]=$(buttonId).attr('value');
    param["_TRANSACTION_TOKEN"]=$('input[name="_TRANSACTION_TOKEN"]').attr('value')
    $.get(
            $('#command').attr('action'), param);
    return false;
};

$(document).ready(
        function(){
            $('#btn-download01').on('click', function(){dummyDownload('#btn-download01');});
        }
    );
</script>

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