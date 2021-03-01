<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="language"/>
<html>
<head>
    <title><fmt:message key="label.edit"/></title>
    <link rel="stylesheet" href="/CSSs/style.css">
    <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
            crossorigin="anonymous"
    />
</head>
<body class="body">

<form accept-charset="UTF-8" method="get"  action="/addLibr">
    <div
            class="modal fade modal-item"
            id="addLibr"
            tabindex="-1"
            role="dialog"
            aria-labelledby="exampleModalLabel"
            aria-hidden="true"
    >

        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel"><fmt:message key="label.addLibr"/></h5>
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
                            <label for="modal-body__login"><fmt:message key="label.login"/></label>
                            <input
                                    name="login"
                                    type="text"
                                    class="form-control"
                                    id="modal-body__login"
                                    placeholder="<fmt:message key="label.login"/>"
                            />
                        </div>

                        <div class="form-group">
                            <label for="modal-body__password"><fmt:message key="label.password"/></label>
                            <input
                                    name="password"
                                    type="text"
                                    class="form-control"
                                    id="modal-body__password"
                                    placeholder="<fmt:message key="label.password"/>"
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
                    <li class="nav-item active"><a class="nav-link" href="/redLibr"><fmt:message key="label.librarian"/></a></li>
                    <li class="nav-item"><a class="nav-link" href="/getUsersAdm"><fmt:message key="label.users"/></a></li>
                    <li class="nav-item"><a class="nav-link" href="/actionPages/LogOut.jsp"><fmt:message key="label.signOut"/></a></li>
                </ul>
            </div>
        </div>
    </nav>

</header>
<div class="tabs">
    <button type="button"
            class="btn btn-primary"
            data-toggle="modal"
            data-target="#addLibr"
    ><fmt:message key="label.addLibr"/>
    </button>
    <table class="table table-dark" align="center">
        <tr align="center">
            <th scope="col">Id</th>
            <th scope="col"><fmt:message key="label.login"/></th>
            <th scope="col"><fmt:message key="label.password"/></th>
            <th scope="col"><fmt:message key="label.state"/></th>
            <th scope="col"><fmt:message key="label.delete"/></th>
        </tr>
        <tbody id="table2">
        <c:forEach items="${librarians}" var="libr">
            <tr>
                <td align="center" scope="row">${libr.id}</td>
                <td align="center">${libr.login}</td>
                <td align="center">${libr.password}</td>
                <td align="center">${libr.root}</td><td align="center">
                <button type="button" type="button"
                        class="btn btn-primary"
                        data-toggle="modal"
                        data-target="#exampleModal"
                        onclick="location.href='/deleteLibr?id=<c:out value="${libr.id}"/>'"><fmt:message key="label.delete"/>
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
