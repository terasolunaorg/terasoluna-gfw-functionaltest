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
  <input id="btn-in-finish" name="intermediateWithFinish" class="mainbtn" style="width: 200px;"
    type="submit" value="Next and Finish" />
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
