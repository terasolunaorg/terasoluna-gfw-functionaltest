<script type="text/javascript">
function setTag() {
       var writeHtmlTag = '<script>${f:js(xssAttack)}<\/script> <h2>JavaScript XSS Measures f:js()</h2>';
       var createNode= document.createTextNode(writeHtmlTag);
       document.getElementById("message").appendChild(createNode);
}
</script>

<div id="message"></div>
<input id="write" type="button" value="write" class="mainbtn" onclick="setTag()">