<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="language"/>
<html>
<head>
    <title>Акаунт</title>
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
            <!-- Основная часть меню (может содержать ссылки, формы и другие элементы) -->
            <div class="collapse navbar-collapse" id="navbar-main">
                <!-- Содержимое основной части -->
                <ul class="nav navbar-nav">
                    <li class="nav-item active"><a class="nav-link" href="/bookList"><fmt:message key="label.main"/></a>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="/UserAcc"><fmt:message key="label.account"/></a></li>
                    <li class="nav-item"><a class="nav-link" href="/actionPages/LogOut.jsp"><fmt:message
                            key="label.signOut"/></a></li>
                    <form class="form-inline my-2 my-lg-0" method="get" action="/searchBook">
                        <label>
                            <input class="form-control mr-sm-2" type="text" name="<fmt:message key="label.search"/>"
                                   placeholder="Пошук у каталозі">
                        </label>
                        <button class="btn btn-success my-2 my-sm-0" type="submit"><fmt:message
                                key="label.search"/></button>
                    </form>
                </ul>
            </div>
        </div>
    </nav>
</header>
<h2 class="h1class"><fmt:message
        key="label.yDebt"/> = ${user.debt}</h2>
<h1 align="center" class="h1class"><fmt:message
        key="label.ybooks"/></h1>
<br/>
<table class="table table-dark" align="center">
    <tr align="center">
        <th scope="col">
            <a><fmt:message key="label.bookName"/></a>
        </th>
        <th scope="col">
            <a><fmt:message key="label.author"/></a>
        </th>
        <th scope="col">
            <a><fmt:message key="label.amount"/></a>
        </th>
        <th scope="col">
            <a><fmt:message key="label.pubDate"/></a>
        </th>
        <th scope="col">
            <a><fmt:message key="label.getTime"/></a>
        </th>
        <th scope="col">
            <a><fmt:message key="label.retTime"/></a>
        </th>
        <th scope="col">
            <a><fmt:message key="label.return"/></a>
        </th>
    </tr>
    <tbody id="table1">
    <c:forEach items="${books}" var="book">
        <tr>
            <td align="center" scope="row">${book.name}</td>
            <td align="center">${book.author}</td>
            <td align="center">${book.publisher}</td>
            <td align="center">${book.date}</td>
            <td align="center">${book.getDate}</td>
            <td align="center">${book.retDate}</td>
            <td><button type="button" type="button"
                        class="btn btn-primary"
                        data-toggle="modal"
                        data-target="#exampleModal"
                        onclick="location.href='/returnBook?bookId=<c:out value="${book.id}"/>'"><fmt:message key="label.return"/>
            </button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
