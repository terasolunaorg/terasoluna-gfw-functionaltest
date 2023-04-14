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

<c:set var="titleKey" value="title.exceptionhandling.index" />
<title><spring:message code="${titleKey}" text="terasoluna-gfw-functionaltest" /></title>
</head>
<body>
  <div class="wrapper">
    <jsp:include page="/WEB-INF/views/layout/header.jsp" />

<h2>Exception Handling Test</h2>

<table>
  <tr>
    <td><a id="requestControllerHandling_01_01"
      href="${pageContext.request.contextPath}/exceptionhandling/1_1">requestControllerHandling_01_01</a>
    </td>
  </tr>
  <tr>
    <td><a id="requestControllerHandling_01_02"
      href="${pageContext.request.contextPath}/exceptionhandling/1_2">requestControllerHandling_01_02</a>
    </td>
  </tr>
  <tr>
    <td><a id="useCaseControllerHandling_02_01"
      href="${pageContext.request.contextPath}/exceptionhandling/2_1">useCaseControllerHandling_02_01</a>
    </td>
  </tr>
  <tr>
    <td><a id="useCaseControllerHandling_02_02"
      href="${pageContext.request.contextPath}/exceptionhandling/2_2">useCaseControllerHandling_02_02</a>
    </td>
  </tr>
  <tr>
    <td><a id="useCaseControllerHandling_02_03"
      href="${pageContext.request.contextPath}/exceptionhandling/2_3">useCaseControllerHandling_02_03</a>
    </td>
  </tr>
  <tr>
    <td><a id="useCaseControllerHandling_02_04"
      href="${pageContext.request.contextPath}/exceptionhandling/2_4">useCaseControllerHandling_02_04</a>
    </td>
  </tr>
  <tr>
    <td><a id="useCaseControllerHandling_02_05"
      href="${pageContext.request.contextPath}/exceptionhandling/2_5">useCaseControllerHandling_02_05</a>
    </td>
  </tr>
  <tr>
    <td><a id="servletFrameworkHandling_03_01"
      href="${pageContext.request.contextPath}/exceptionhandling/3_1">servletFrameworkHandling_03_01</a>
    </td>
  </tr>
  <tr>
    <td><a id="servletFrameworkHandling_03_02"
      href="${pageContext.request.contextPath}/exceptionhandling/3_2">servletFrameworkHandling_03_02</a>
    </td>
  </tr>
  <tr>
    <td><a id="servletFrameworkHandling_03_03"
      href="${pageContext.request.contextPath}/exceptionHandlingChangeDefaultStatusCode/exceptionhandling/3_3">servletFrameworkHandling_03_03</a>
    </td>
  </tr>
  <tr>
    <td><a id="servletFrameworkHandling_03_04"
      href="${pageContext.request.contextPath}/exceptionHandlingRedirect/exceptionhandling/3_4">servletFrameworkHandling_03_04</a>
    </td>
  </tr>
  <tr>
    <td><a id="servletFrameworkHandling_03_05"
      href="${pageContext.request.contextPath}/exceptionhandling/3_5">servletFrameworkHandling_03_05</a>
    </td>
  </tr>
  <tr>
    <td><a id="servletFrameworkHandling_03_06"
      href="${pageContext.request.contextPath}/exceptionHandlingIgnoreResultMessages/exceptionhandling/3_6">servletFrameworkHandling_03_06</a>
    </td>
  </tr>
  <tr>
    <td><a id="servletFrameworkHandling_03_07"
      href="${pageContext.request.contextPath}/exceptionhandling/3_7">servletFrameworkHandling_03_07</a>
    </td>
  </tr>
  <tr>
    <td><a id="servletFrameworkHandling_03_08"
      href="${pageContext.request.contextPath}/exceptionHandlingChangeAttribute/exceptionhandling/3_8">servletFrameworkHandling_03_08</a>
    </td>
  </tr>
  <tr>
    <td><a id="servletFrameworkHandling_03_09"
      href="${pageContext.request.contextPath}/exceptionHandlingChangeAttribute/exceptionhandling/3_9">servletFrameworkHandling_03_09</a>
    </td>
  </tr>
  <tr>
    <td><a id="servletFrameworkHandling_03_10"
      href="${pageContext.request.contextPath}/exceptionhandling/3_10">servletFrameworkHandling_03_10</a>
    </td>
  </tr>
  <tr>
    <td><a id="webApplicationHandling_04_01"
      href="${pageContext.request.contextPath}/exceptionhandling/4_1">webApplicationHandling_04_01</a>
    </td>
  </tr>
  <tr>
    <td><a id="webApplicationHandling_04_02"
      href="${pageContext.request.contextPath}/exceptionhandling/4_2">webApplicationHandling_04_02</a>
    </td>
  </tr>
  <tr>
    <td><a id="webApplicationHandling_04_03"
      href="${pageContext.request.contextPath}/exceptionhandling/4_3">webApplicationHandling_04_03</a>
    </td>
  </tr>
  <tr>
    <td><a id="webApplicationHandling_04_04"
      href="${pageContext.request.contextPath}/exceptionhandling/4_4">webApplicationHandling_04_04</a>
    </td>
  </tr>
  <tr>
    <td><a id="exceptionLoggerVariation_05_01"
      href="${pageContext.request.contextPath}/exceptionhandling/5_1">exceptionLoggerVariation_05_01</a>
    </td>
  </tr>
  <tr>
    <td><a id="exceptionLoggerVariation_05_02"
      href="${pageContext.request.contextPath}/exceptionhandling/5_2">exceptionLoggerVariation_05_02</a>
    </td>
  </tr>
  <tr>
    <td><a id="exceptionLoggerVariation_05_03"
      href="${pageContext.request.contextPath}/exceptionhandling/5_3">exceptionLoggerVariation_05_03</a>
    </td>
  </tr>
  <tr>
    <td><a id="exceptionLoggerVariation_05_04"
      href="${pageContext.request.contextPath}/exceptionHandlingExceptionLoggerVariation/exceptionhandling/5_4">exceptionLoggerVariation_05_04</a>
    </td>
  </tr>
  <tr>
    <td><a id="exceptionLoggerVariation_05_05"
      href="${pageContext.request.contextPath}/exceptionHandlingLogFormat/exceptionhandling/5_5">exceptionLoggerVariation_05_05</a>
    </td>
  </tr>
  <tr>
    <td><a id="exceptionLoggerVariation_05_06"
      href="${pageContext.request.contextPath}/exceptionHandlingMessageExceptionCodeResolver/exceptionhandling/5_6">exceptionLoggerVariation_05_06</a>
    </td>
  </tr>
  <tr>
    <td><a id="exceptionOccuresInSharedService_06_01"
      href="${pageContext.request.contextPath}/exceptionhandling/6_1">exceptionOccuresInSharedService_06_01</a>
    </td>
  </tr>
  <tr>
    <td><a id="exceptionOccuresInSharedService_06_02"
      href="${pageContext.request.contextPath}/exceptionhandling/6_2">exceptionOccuresInSharedService_06_02</a>
    </td>
  </tr>
</table>

    <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
  </div>
</body>
</html>