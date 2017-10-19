<h2>Redirect Function Test</h2>

<table>
  <tr>
    <td><a id="listWithInternalPath"
      href="${pageContext.request.contextPath}/redirect/listWithInternalPath">redirectTo element
        contains valid internal link</a></td>
  </tr>
  <tr>
    <td><a id="listWithNoPath"
      href="${pageContext.request.contextPath}/redirect/listWithNoPath">redirectTo element is
        not specified</a></td>
  </tr>
  <tr>
    <td><a id="listWithExternalPath"
      href="${pageContext.request.contextPath}/redirect/listWithExternalPath">redirectTo element
        contains external link</a></td>
  </tr>
  <tr>
    <td><a id="listWithGoTo" href="${pageContext.request.contextPath}/redirect/listWithGoTo">targetUrlParameter
        attribute is changed to goTo</a></td>
  </tr>
  <tr>
    <td><a id="listWithLinkInWhiteList"
      href="${pageContext.request.contextPath}/redirect/listWithLinkInWhiteList">RedirectStrategy
        is extended. value of redirectTo is present in whitelist</a></td>
  </tr>
  <tr>
    <td><a id="listWithLinkNotInWhiteList"
      href="${pageContext.request.contextPath}/redirect/listWithLinkNotInWhiteList">RedirectStrategy
        is extended. value of redirectTo is not present in whitelist</a></td>
  </tr>
</table>
