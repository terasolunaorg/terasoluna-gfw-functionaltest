<form>
    <t:transaction />
    <b>Transaction token value is : <span id="result"></span></b>

</form>

<script type="text/javascript">
    document.getElementById("result").innerHTML = document
            .getElementsByName('_TRANSACTION_TOKEN')[0].value;
</script>
