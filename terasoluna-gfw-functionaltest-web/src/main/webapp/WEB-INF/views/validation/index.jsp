<h2>Validation Function Test</h2>

<label>Change Locale Link</label>
<a href="${pageContext.request.contextPath}/validation?locale=en">English</a>
<a href="${pageContext.request.contextPath}/validation?locale=ja">Japanese</a>
<br />
<br />
<table>
    <tr>
        <td><a href="${pageContext.request.contextPath}/validation/bytemin">@ByteMin Test</a></td>
    </tr>
    <tr>
        <td><a href="${pageContext.request.contextPath}/validation/bytemax">@ByteMax Test</a></td>
    </tr>
    <tr>
        <td><a href="${pageContext.request.contextPath}/validation/bytesize">@ByteSize Test</a></td>
    </tr>
    <tr>
        <td><a href="${pageContext.request.contextPath}/validation/compare">@Compare Test</a></td>
    </tr>
</table>
