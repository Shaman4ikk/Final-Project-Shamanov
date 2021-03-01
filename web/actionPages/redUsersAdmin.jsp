<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="language"/>
<html>
<head>
    <title>Користувачі</title>
    <link rel="stylesheet" href="/CSSs/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body class="body">
<header>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark justify-content-between">
        <div class="container-fluid">
            <!-- Заголовок -->
            <div class="navbar-header">
                <a class="navbar-brand" href="/admin">LibUA</a>
            </div>
            <!-- Основная часть меню (может содержать ссылки, формы и другие элементы) -->
            <div class="collapse navbar-collapse" id="navbar-main">
                <!-- Содержимое основной части -->
                <ul class="nav navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="/admin"><fmt:message key="label.main"/></a></li>
                    <li class="nav-item"><a class="nav-link" href="/redLibr"><fmt:message key="label.librarian"/></a></li>
                    <li class="nav-item active"><a class="nav-link" href="/getUsersAdm"><fmt:message key="label.users"/></a></li>
                    <li class="nav-item"><a class="nav-link" href="/actionPages/LogOut.jsp"><fmt:message key="label.signOut"/></a></li>
                </ul>
            </div>
        </div>
    </nav>

</header>
<div>
    <table class="table table-dark" align="center">
        <tr align="center">
            <th scope="col">Id</th>
            <th scope="col"><fmt:message key="label.login"/></th>
            <th scope="col"><fmt:message key="label.access"/></th>
            <th scope="col"><fmt:message key="label.state"/></th>
            <th scope="col"><fmt:message key="label.Debt"/></th>
            <th scope="col"><fmt:message key="label.bans"/></th>

        </tr>
        <tbody id="table3">
        <c:forEach items="${users}" var="user">
            <tr>
                <td align="center" scope="row">${user.id}</td>
                <td align="center">${user.login}</td>
                <td align="center">${user.root}</td>
                <td align="center">${user.condition}</td>
                <td align="center">${user.debt}</td>
                <td>
                    <button type="button"
                            class="btn btn-secondary"
                            data-dismiss="modal"
                            onclick="location.href='/setBan?id=<c:out value="${user.id}"/>'"><fmt:message key="label.ban"/>
                    </button>
                    <button type="button"
                            class="btn btn-secondary"
                            data-dismiss="modal"
                            onclick="location.href='/unBan?id=<c:out value="${user.id}"/>'">
                        <fmt:message key="label.unBan"/>
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
    <script
            src="https://code.jquery.com/jquery-3.5.1.min.js"
            integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
            crossorigin="anonymous"
    ></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"
    ></script>
</body>
</html>
