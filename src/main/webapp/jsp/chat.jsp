<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>

<c:url value="/logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}" />
</form>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>
</c:if>

<div class="container">
    <div class="contacts">
        <div class="buttons">
            <button class="logout fa-sign-out" title="Sign out" onclick="formSubmit()"></button>
            <button class="new-message fa-envelope-o"></button>
            <button class="search fa-search"></button>
        </div>
        <ul>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
    <div class="messages">
        <ul>
            <li>
                Is this the real life?
            </li>
            <li>
                Is this just fantasy?
            </li>
        </ul>
    </div>
    <div class="stack-wrap"></div>
    <div class="form">
        <div class="form-inner">
            <button>+</button>
        </div>
    </div>
</div>

<script src="/resources/js/index.js"></script>

</body>
</html>