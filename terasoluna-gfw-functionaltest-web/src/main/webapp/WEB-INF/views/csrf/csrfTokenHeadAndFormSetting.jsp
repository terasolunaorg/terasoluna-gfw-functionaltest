
    <head>
        <meta name="_csrf" content="${f:h(_csrf.token)}"/>
        <meta name="_csrf_header" content="${f:h(_csrf.headerName)}"/>
    </head>

    <script type="text/javascript">
    var contextPath = "${pageContext.request.contextPath}";
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
    $(function() {
        var $result = $('#result');
        $('#ajaxButton').on('click', function() {
            $result.html('');
            var $form = $('#ajaxForm');
            $.ajax({
                url : contextPath + '/csrf/ajax',
                type : 'POST',
                data: $form.serialize(),
            }).done(function(data, status, xhr) {
                $result.html("<span>" + xhr.status + "</span>");
            }).fail(function(xhr) {
                // error handling
                $result.html("<span>" + xhr.status + "</span>");
            });
        });
    });
    </script>

    <h2>CsrfToken Head And Form Setting</h2>

    <form:form id="ajaxForm" action="${pageContext.request.contextPath}">
        <input id="ajaxButton" class="mainbtn" type="button" value="send">
    </form:form>
    <div id="result"></div>