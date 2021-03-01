<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="language"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>Головна</title>
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
<table class="table table-dark" align="center">
    <tr align="center">
        <th scope="col">
            <c:choose>
                <c:when test='<%=request.getParameter("sort") != null && !request.getParameter("sort").contains("nameCBA")%>'>
                    <a href="<%=request.getContextPath()%>/bookList?sort=nameCBA"><fmt:message
                            key="label.bookName"/></a>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/bookList?sort=nameABC"><fmt:message
                            key="label.bookName"/></a>
                </c:otherwise>
            </c:choose>
        </th>
        <th scope="col"><c:choose>
            <c:when test='<%=request.getParameter("sort") != null && !request.getParameter("sort").contains("authorCBA")%>'>
                <a href="<%=request.getContextPath()%>/bookList?sort=authorCBA"><fmt:message key="label.author"/></a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/bookList?sort=authorABC"><fmt:message
                        key="label.author"/></a>
            </c:otherwise>
        </c:choose></th>
        <th scope="col"><c:choose>
            <c:when test='<%=request.getParameter("sort") != null && !request.getParameter("sort").contains("numCBA")%>'>
                <a href="<%=request.getContextPath()%>/bookList?sort=numCBA"><fmt:message key="label.amount"/></a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/bookList?sort=numABC"><fmt:message key="label.amount"/></a>
            </c:otherwise>
        </c:choose></th>
        <th scope="col"><c:choose>
            <c:when test='<%=request.getParameter("sort") != null && !request.getParameter("sort").contains("dateCBA")%>'>
                <a href="<%=request.getContextPath()%>/bookList?sort=dateCBA"><fmt:message key="label.pubDate"/></a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/bookList?sort=dateABC"><fmt:message
                        key="label.pubDate"/></a>
            </c:otherwise>
        </c:choose></th>
        <th scope="col"><c:choose>
            <c:when test='<%=request.getParameter("sort") != null && !request.getParameter("sort").contains("pubCBA")%>'>
                <a href="<%=request.getContextPath()%>/bookList?sort=pubCBA"><fmt:message key="label.publisher"/></a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/bookList?sort=pubABC"><fmt:message
                        key="label.publisher"/></a>
            </c:otherwise>
        </c:choose></th>

        <th scope="col"><fmt:message key="label.order"/></th>
    </tr>
    <tbody id="table1">
    <c:forEach items="${books}" var="book">
        <tr>
            <td align="center" scope="row">${book.name}</td>
            <td align="center">${book.author}</td>
            <td align="center">${book.num}</td>
            <td align="center">${book.date}</td>
            <td align="center">${book.publisher}</td>
            <td align="center"><a onclick="location.href='/AddBook?id=<c:out value="${book.id}"/>'"><fmt:message
                    key="label.order"/></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
