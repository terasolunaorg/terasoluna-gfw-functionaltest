<html>
    <head>
        <title>Codelist</title>
    </head>
    <body>
        <h2>Codelist</h2>
        <br />

        <table>
            <caption>
                Database
            </caption>
            <thead>
                <tr>
                    <th>code</th>
                    <th>label(english)</th>
                    <th>label(japanese)</th>
                    <th>update</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${items}" varStatus="s">
                    <tr>
                        <form:form action="${pageContext.request.contextPath}/codelist/12_01_form?update" modelAttribute="i18nCodeListForm">
                            <td><input id="code${s.count}" name="code" value="${item.code}" /></td>
                            <td><input id="labelEn${s.count}" name="labelEn" value="${item.labelEn}" /></td>
                            <td><input id="labelJa${s.count}" name="labelJa" value="${item.labelJa}" /></td>
                            <td><form:button id="btnUpdate">update</form:button><input type="hidden" name="id" value="${item.id}" /></td>
                        </form:form>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <form:form action="${pageContext.request.contextPath}/codelist/12_01_form?refresh">
            <button id="btnRefresh1" type="submit">refresh</button>
            <button id="btnRefresh2" type="submit" formaction="${pageContext.request.contextPath}/codelist/12_01_form?refresh&recursive=false">refresh(recursive:false)</button>
            <button id="btnRefresh3" type="submit" formaction="${pageContext.request.contextPath}/codelist/12_01_form?refresh&recursive=true">refresh(recursive:true)</button>
            <button id="btnRefresh4" type="submit" formaction="${pageContext.request.contextPath}/codelist/12_01_form?refreshAll">refresh(all codelist)</button>
        </form:form>

        <br />
        <hr />

        <table>
            <caption>
                CodeList(Resolved Locale)
            </caption>
            <thead>
                <tr>
                    <th>code</th>
                    <th>label</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="entry" items="${CL_CODELIST12_01}" varStatus="s">
                    <tr>
                        <td id="cl-code${s.count}">${entry.key}</td>
                        <td id="cl-label${s.count}">${entry.value}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <table>
            <caption>
                CodeList(English)
            </caption>
            <thead>
                <tr>
                    <th>code</th>
                    <th>label</th>
                </tr>
            </thead>
            <tbody>
                <spring:eval var="EN" expression="@CL_CODELIST12_01.asMap(T(java.util.Locale).ENGLISH)" />
                <c:forEach var="entry" items="${EN}" varStatus="s">
                    <tr>
                        <td id="en-code${s.count}">${entry.key}</td>
                        <td id="en-label${s.count}">${entry.value}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <table>
            <caption>
                CodeList(Japanese)
            </caption>
            <thead>
                <tr>
                    <th>code</th>
                    <th>label</th>
                </tr>
            </thead>
            <tbody>
                <spring:eval var="JA" expression="@CL_CODELIST12_01.asMap(T(java.util.Locale).JAPANESE)" />
                <c:forEach var="entry" items="${JA}" varStatus="s">
                    <tr>
                        <td id="ja-code${s.count}">${entry.key}</td>
                        <td id="ja-label${s.count}">${entry.value}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
