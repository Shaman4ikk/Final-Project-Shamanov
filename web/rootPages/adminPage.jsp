<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="language"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <link rel="stylesheet" href="/CSSs/style.css">
    <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
            crossorigin="anonymous"
    />
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
                    <li class="nav-item active"><a class="nav-link" href="/admin"><fmt:message key="label.main"/></a></li>
                    <li class="nav-item"><a class="nav-link" href="/redLibr"><fmt:message key="label.librarian"/></a></li>
                    <li class="nav-item"><a class="nav-link" href="/getUsersAdm"><fmt:message key="label.users"/></a></li>
                    <li class="nav-item"><a class="nav-link" href="/actionPages/LogOut.jsp"><fmt:message key="label.signOut"/></a></li>
                </ul>
            </div>
        </div>
    </nav>

</header>
<form accept-charset="UTF-8" method="post" action="/redBook">
    <div
            class="modal fade modal-item"
            id="exampleModal"
            tabindex="-1"
            role="dialog"
            aria-labelledby="exampleModalLabel"
            aria-hidden="true"
    >

        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel"><fmt:message key="label.edit"/></h5>
                    <button
                            type="button"
                            class="close"
                            data-dismiss="modal"
                            aria-label="Close"
                    >
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="modal-body__edit-wrapper">
                        <div class="form-group">
                            <label for="modal-body__id">Id</label>
                            <input
                                    name="id"
                                    type="text"
                                    class="form-control"
                                    id="modal-body__id"
                                    placeholder="Id"
                            />
                        </div>
                        <div class="form-group">
                            <label for="modal-body__name"><fmt:message key="label.bookName"/></label>
                            <input
                                    name="name"
                                    type="text"
                                    class="form-control"
                                    id="modal-body__name"
                                    placeholder="Назва"
                            />
                        </div>

                        <div class="form-group">
                            <label for="modal-body__author"><fmt:message key="label.author"/></label>
                            <input
                                    name="author"
                                    type="text"
                                    class="form-control"
                                    id="modal-body__author"
                                    placeholder="Автор"
                            />
                        </div>
                        <div class="form-group">
                            <label for="modal-body__num"><fmt:message key="label.amount"/></label>
                            <input
                                    name="num"
                                    type="text"
                                    class="form-control"
                                    id="modal-body__num"
                                    placeholder="Кількість"
                            />
                        </div>
                        <div class="form-group">
                            <label for="modal-body__publisher"><fmt:message key="label.publisher"/></label>
                            <input
                                    name="publisher"
                                    type="text"
                                    class="form-control"
                                    id="modal-body__publisher"
                                    placeholder="Видання"
                            />
                        </div>
                        <div class="form-group">
                            <label for="modal-body__date"><fmt:message key="label.pubDate"/></label>
                            <input
                                    name="date"
                                    type="text"
                                    class="form-control"
                                    id="modal-body__date"
                                    placeholder="Дата видання"
                            />
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button
                            type="button"
                            class="btn btn-secondary"
                            data-dismiss="modal"
                    >
                        <fmt:message key="label.close"/>
                    </button>
                    <button type="submit" class="btn btn-primary"><fmt:message key="label.save"/></button>
                </div>
            </div>
        </div>
    </div>
</form>


<form accept-charset="UTF-8" method="post" action="${pageContext.request.contextPath}/addBook">
    <div
            class="modal fade modal-item"
            id="addBook"
            tabindex="-1"
            role="dialog"
            aria-labelledby="exampleModalLabel"
            aria-hidden="true"
    >

        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addBookLabel"><fmt:message key="label.addBook"/></h5>
                    <button
                            type="button"
                            class="close"
                            data-dismiss="modal"
                            aria-label="Close"
                    >
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="modal-body__edit-wrapper">
                        <div class="form-group">
                            <label for="modal-body__bookname"><fmt:message key="label.bookName"/></label>
                            <input
                                    name="name"
                                    type="text"
                                    class="form-control"
                                    id="modal-body__bookname"
                                    placeholder="Назва"
                                    required
                            />
                        </div>

                        <div class="form-group">
                            <label for="modal-body__bookauthor"><fmt:message key="label.author"/></label>
                            <input
                                    name="author"
                                    type="text"
                                    class="form-control"
                                    id="modal-body__bookauthor"
                                    placeholder="Автор"
                                    required
                            />
                        </div>
                        <div class="form-group">
                            <label for="modal-body__booknum"><fmt:message key="label.amount"/></label>
                            <input
                                    name="num"
                                    type="text"
                                    class="form-control"
                                    id="modal-body__booknum"
                                    placeholder="Кількість"
                                    required
                            />
                        </div>
                        <div class="form-group">
                            <label for="modal-body__bookpublisher"><fmt:message key="label.publisher"/></label>
                            <input
                                    name="publisher"
                                    type="text"
                                    class="form-control"
                                    id="modal-body__bookpublisher"
                                    placeholder="Видання"
                                    required
                            />
                        </div>
                        <div class="form-group">
                            <label for="modal-body__bookdate"><fmt:message key="label.pubDate"/></label>
                            <input
                                    name="date"
                                    type="text"
                                    class="form-control"
                                    id="modal-body__bookdate"
                                    placeholder="Дата видання"
                                    required
                            />
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button
                            type="button"
                            class="btn btn-secondary"
                            data-dismiss="modal"
                    >
                        <fmt:message key="label.close"/>
                    </button>
                    <button type="submit" class="btn btn-primary"><fmt:message key="label.save"/></button>
                </div>
            </div>
        </div>
    </div>
</form>

<div>
    <button type="button"
            class="btn btn-primary"
            data-toggle="modal"
            data-target="#addBook"
    ><fmt:message
            key="label.addBook"/>
    </button>
    <table class="table table-dark" align="center">
        <tr align="center">
            <th scope="col">ID</th>
            <th scope="col"><fmt:message key="label.bookName"/></th>
            <th scope="col"><fmt:message key="label.author"/></th>
            <th scope="col"><fmt:message key="label.amount"/></th>
            <th scope="col"><fmt:message key="label.publisher"/></th>
            <th scope="col"><fmt:message key="label.pubDate"/></th>
            <th scope="col"><fmt:message key="label.edit"/></th>
            <th scope="col"><fmt:message key="label.delete"/></th>
        </tr>
        <tbody id="table1">
        <c:forEach items="${books}" var="book">
            <tr>
                <td align="center" scope="row">${book.id}
                    <form class="form1" style="display: none">
                        <input type="text">
                    </form>
                </td>
                <td align="center" scope="row">${book.name}
                    <form class="form1" style="display: none">
                        <input type="text">
                    </form>
                </td>
                <td align="center">${book.author}
                    <form class="form1" style="display: none">
                        <input type="text">
                    </form>
                </td>
                <td align="center">${book.num}
                    <form class="form1" style="display: none">
                        <input type="text">
                    </form>
                </td>
                <td align="center">${book.publisher}
                    <form class="form1" style="display: none">
                        <input type="text">
                    </form>
                </td>
                <td align="center">${book.date}
                    <form class="form1" style="display: none">
                        <input type="text">
                    </form>
                </td>
                <td>
                    <button
                            type="button"
                            class="btn btn-primary"
                            data-toggle="modal"
                            data-target="#exampleModal"
                            data-item-id="${book.id}"
                    >
                        <fmt:message key="label.edit"/>
                    </button>
                </td>
                <td align="center">
                    <button type="button" type="button"
                            class="btn btn-primary"
                            data-toggle="modal"
                            data-target="#exampleModal"
                            onclick="location.href='/deleteBook?bookId=<c:out value="${book.id}"/>'"><fmt:message key="label.delete"/>
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
