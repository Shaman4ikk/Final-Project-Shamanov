<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="language"/>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="label.main"/></title>
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
                <a class="navbar-brand" href="/bookList">LibUA</a>
            </div>
            <div class="collapse navbar-collapse" id="navbar-main">
                <ul class="nav navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="/actionPages/LogOut.jsp"><fmt:message key="label.signOut"/></a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<div class="tabs">
    <input type="radio" name="inset" value="" id="tab_1" checked>
    <label for="tab_1"><a href="/OrderUserBook"></a>
        <fmt:message key="label.order"/></label>

    <input type="radio" name="inset" value="" id="tab_2">
    <label for="tab_2"><a href="/getUsers"></a><fmt:message key="label.users"/>
    </label>

    <div id="txt_2">
        <table class="table table-dark" align="center">
            <tr align="center">
                <th scope="col">Id</th>
                <th scope="col"><fmt:message key="label.login"/></th>
                <th scope="col"><fmt:message key="label.access"/></th>
                <th scope="col"><fmt:message key="label.state"/></th>
                <th scope="col"><fmt:message key="label.Debt"/></th>

            </tr>
            <tbody id="table2">
            <c:forEach items="${users}" var="user">
                <tr>
                    <td align="center" scope="row">${user.id}</td>
                    <td align="center">${user.login}</td>
                    <td align="center">${user.root}</td>
                    <td align="center">${user.condition}</td>
                    <td align="center">${user.debt}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div id="txt_1">
        <form action="status" method="get">
            <table class="table table-dark" align="center">
                <tr align="center">
                    <th scope="col">id</th>
                    <th scope="col"><fmt:message key="label.login"/></th>
                    <th scope="col"><fmt:message key="label.bookName"/></th>
                    <th scope="col"><fmt:message key="label.author"/></th>
                    <th scope="col"><fmt:message key="label.getTime"/></th>
                    <th scope="col"><fmt:message key="label.retTime"/></th>
                    <th scope="col"><fmt:message key="label.access"/></th>
                    <th scope="col"></th>
                </tr>
                <tbody id="table3">
                <c:forEach items="${ordBook}" var="order">
                    <tr>
                        <td align="center" scope="row">${order.bookId}</td>
                        <td align="center">${order.userLogin}</td>
                        <td align="center">${order.bookName}</td>
                        <td align="center">${order.author}</td>
                        <td align="center">${order.timeTake}</td>
                        <td align="center">${order.returnTime}</td>
                        <td align="center">${order.acess}</td>
                        <td>
                            <button type="button"
                                    onclick="location.href='/wait?bookId=<c:out value="${order.bookId}"/>'"><fmt:message key="label.inWait"/>
                            </button>
                            <button type="button"
                                    class="btn btn-secondary"
                                    data-dismiss="modal"
                                    onclick="location.href='/subscription?bookId=<c:out value="${order.bookId}"/>'">
                                <fmt:message key="label.subs"/>
                            </button>
                            <button type="button"
                                    class="btn btn-secondary"
                                    data-dismiss="modal"
                                    onclick="location.href='/readRoom?bookId=<c:out value="${order.bookId}"/>'">
                                <fmt:message key="label.readRoom"/>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>
    </div>

</div>
</body>
</html>
