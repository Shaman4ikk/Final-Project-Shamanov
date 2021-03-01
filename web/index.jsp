<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="language"/>
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Libruary_Shamanov</title>
    <link rel="stylesheet" href="/CSSs/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body class="body">
<div>
    <h1 class="h1class"><fmt:message key="label.welcome"/></h1>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <div class="tab" role="tabpanel">
                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#Section1" aria-controls="home" role="tab" data-toggle="tab"><fmt:message key="label.signIn"/></a></li>
                    <li role="presentation"><a href="#Section2" aria-controls="profile" role="tab" data-toggle="tab"><fmt:message key="label.signOn"/></a></li>
                    <li><a onclick="location.href='/setLang?lang=ukr'" content="U+1F1E6" aria-controls="home" role="tab" data-toggle="tab">UA</a></li>
                    <li><a onclick="location.href='/setLang?lang=en'" content="U+1F1E6" aria-controls="home" role="tab" data-toggle="tab">EN</a></li>
                </ul>
                <!-- Tab panes -->
                <div class="tab-content tabs">
                    <div role="tabpanel" class="tab-pane fade in active" id="Section1">
                        <div class="h1class"><fmt:message key="label.validation"/></div>
                        <form method="post" class="form-horizontal" action="/signIn" >
                            <div class="form-group">
                                <label for="exampleInputEmail1"><fmt:message key="label.login"/></label>
                                <input name="login" type="text" class="form-control" id="exampleInputEmail1" required pattern="^[0-9a-zA-Z]+$" >
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1"><fmt:message key="label.password"/></label>
                                <input name="pass" type="password" class="form-control" id="exampleInputPassword1" required pattern="^[0-9a-zA-Z]+$"  >
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-default"><fmt:message key="label.signIn"/></button>
                            </div>
                        </form>
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="Section2">
                        <div class="h1class"><fmt:message key="label.validation"/></div>

                        <form method="post" action="/reg" class="form-horizontal" >
                            <div class="form-group">
                                <label for="exampleInputEmail1"><fmt:message key="label.login"/></label>
                                <input name="login" pattern="^[0-9a-zA-Z]+$" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1"><fmt:message key="label.password"/></label>
                                <input name="pass" type="password" class="form-control" pattern="^[0-9a-zA-Z]+$" required>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-default"><fmt:message key="label.signOn"/></button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div><!-- /.col-md-offset-3 col-md-6 -->
    </div><!-- /.row -->
</div><!-- /.container -->
</body>
</html>