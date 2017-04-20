
<h1 class="center-content">Person Search Form</h1>

<form class="center-content" method="post">
    <spring:nestedPath path="personSearchForSessionForm">
        <form:input path="name" />
        <form:select path="sort">
            <form:option value="personId,DESC">Newest</form:option>
            <form:option value="personId,ASC">Oldest</form:option>
        </form:select>
        <form:button id="searchButton">Search</form:button>
        <sec:csrfInput />
    </spring:nestedPath>
</form>

<br>

<c:if test="${not empty page and page.totalElements != 0}">
    <h2 class="center-content">
        <span id="pagePosition">${f:h(page.number) + 1}</span> Page ( <span
            id="rangeStart">${(page.number * page.size) + 1}</span>-<span
            id="rangeEnd">${(page.number * page.size) +
            page.numberOfElements}</span> / <span id="totalResults">${page.totalElements}</span>
        results )
    </h2>
    <h3 class="center-content">SessionAttributes Function</h3>
    <div id="paginationAndSessionFunction" class="pagination">
        <t:pagination page="${page}" />
    </div>
    <table class="maintable">
        <thead>
            <tr>
                <th>Number</th>
                <th>Person ID</th>
                <th>First Name</th>
                <th>Last Name</th>
            </tr>
        </thead>
        <c:forEach var="person" items="${page.content}"
            varStatus="rowStatus">
            <tr>
                <td>${page.number * page.size + rowStatus.index +
                    1}</td>
                <td id="personId${rowStatus.index}">${f:h(person.personId)}</td>
                <td>${f:h(person.firstname)}</td>
                <td>${f:h(person.lastname)}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>