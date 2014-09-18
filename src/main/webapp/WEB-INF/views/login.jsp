<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
  <meta charset="utf-8">
  <title>Testing of JavaRush</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

	<!--link rel="stylesheet/less" href="resources/less/bootstrap.less" type="text/css" /-->
	<!--link rel="stylesheet/less" href="resources/less/responsive.less" type="text/css" /-->
	<!--script src="js/less-1.3.3.min.js"></script-->
	<!--append ‘#!watch’ to the browser URL, then refresh the page. -->

	<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet"><!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Testing of JavaRush</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

	<!--link rel="stylesheet/less" href="resources/less/bootstrap.less" type="text/css" /-->
	<!--link rel="stylesheet/less" href="resources/less/responsive.less" type="text/css" /-->
	<!--script src="resources/js/less-1.3.3.min.js"></script-->
	<!--append ‘#!watch’ to the browser URL, then refresh the page. -->

	<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">

  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
    <script src="resources/js/html5shiv.js"></script>
  <![endif]-->

  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="resources/img/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="resources/img/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="resources/img/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="resources/img/apple-touch-icon-57-precomposed.png">
  <link rel="shortcut icon" href="resources/img/favicon.png">

	<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/scripts.js"></script>
</head>

<body>
<form method="POST"
		action="<%=request.getContextPath()%>/j_spring_security_check"
		class="box login">
   <div class="container-fluid">
       <div class="header">
           <div class="col-lg-12">
               <a href ="#"><img alt="" src="resources/img/header-2%20new.png" style="margin: 5px 0px 5px"></a>
           </div>
       </div>
       <div class="header2" >
           <div class="col-md-2">
               <a href ="registerPage"><img alt="" src="resources/img/Logo2.png" style="margin: 7px auto 5px"></a>
           </div>
           <div class="col-md-10">
               <div class="collapse navbar-collapse" id="responsive-menu">
                   <ul class="nav navbar-nav">
                       <li><a href ="#">МОЯ СТРАНИЦА</a></li>
                       <li><a href ="#">НАЧАТЬ ТЕСТИРОВАНИЕ</a></li>
                       <li><a href ="#">КОМАНДА</a></li>
                       <li><a href ="http://info.javarush.ru/">СООБЩЕСТВО</a></li>
                       <li><a href ="#">ПОМОЩЬ</a></li>
                   </ul>
               </div>
           </div>
       </div>
       <div class="container">
           <div class="row">
           <div class="col-md-8">
               <div class="carousel slide" id="carousel-161012" style="margin: 20px auto auto">
                   <ol class="carousel-indicators">
                       <li class="active" data-slide-to="0" ></li>
                       <li data-slide-to="1" ></li>
                       <li data-slide-to="2" ></li>
                   </ol>
                   <div class="carousel-inner">
                       <div class="item active">
                           <img alt="" src="http://javarush.ru/images/main/4.gif">
                       </div>
                       <div class="item">
                           <img alt="" src="http://javarush.ru/images/main/4.gif">
                           <div class="carousel-caption">
                               <h4>Название картинки 2</h4>
                               <p>какой нибудь текст на картинке 2</p>
                           </div>
                       </div>
                       <div class="item">
                           <img alt="" src="http://javarush.ru/images/main/4.gif">
                           <div class="carousel-caption">
                               <h4>Название картинки 3</h4>
                               <p>какой нибудь текст на картинке 3</p>
                           </div>
                       </div>
                   </div>
                   <a class="left carousel-control" href="#carousel-161012" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
                   <a class="right carousel-control" href="#carousel-161012" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
               </div>
           </div>
           <div class="col-md-4" style="margin: 20px auto auto">
               <form class="form-horizontal" role="form">
                   <div class="form-group">
                       <div class="col-sm-8">
                           <input class="form-control preFilter email" id="user_login" name='user_login' type="text" placeholder="Имя пользователя" >
                       </div>
                   </div>
                   <div class="form-group">
                       <div class="col-sm-8">
                           <input class="form-control" id="password_login" name='password_login' type="password" placeholder="Пароль" style="margin: 15px auto auto">
                       </div>
                   </div>
                   <div class="form-group">
                       <div class="col-sm-10">
                           <div class="checkbox">
                               <label><input type="checkbox"> Запомнить меня</label>
                           </div>
                       </div>
                   </div>
                   <div class="form-group">
                       <div class="col-sm-10">
                           <button type="submit" class="btn btn-success">Войти</button>
                           <a href="registerPage"><input type="button" class="btn btn-primary" value="Регистрация"></input></a>
                       </div>
                   </div>
               </form>
           </div>
           <a href="forgotPassword"><input type="button" class="btn btn-danger" value="Забыли пароль?" style="margin: 10px 28px auto"></input></a>
       </div>
   </div>
   </form>
</body>
</html>