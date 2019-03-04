<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="Flat Register Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script type="application/x-javascript"> 
addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ 
	window.scrollTo(0,1); 
	} 
	</script>
<!-- Meta tag Keywords -->
<!--css-->
<link href="../css/style.css" rel='stylesheet' type='text/css'/>
<link rel="stylesheet" href="../css/font-awesome.css"> <!-- Font-Awesome-Icons-CSS -->
<!--css-->
<!--fonts-->
<link href="//fonts.googleapis.com/css?family=Cuprum&subset=latin-ext" rel="stylesheet">
<!--//fonts-->
<title>霖霖商城注册</title>
</head>
<body>
<h1>霖霖商城   良心品质</h1>
	<div class="main-agile">
		<div class="content-wthree">
			<h2>Register Now</h2>
			<form action="${pageContext.request.contextPath}/ClientServlet?operation=register" method="post">
				<div class="w3l-forming">
					<i class="fa fa-user" aria-hidden="true"></i>
					<input type="text"  class="name" name="userName" placeholder="Your Name" required="">
				</div>
				<div class="w3l-forming">
					<i class="fa fa-envelope-o" aria-hidden="true"></i>
					<input type="email"  class="email" name="email" placeholder="E-mail" required="">
				</div>
				<div class="w3l-forming">
					<i class="fa fa-phone" aria-hidden="true"></i>
					<input type="text"  class="name" name="phone_number" placeholder="Phone Number" required="">
				</div>
				<div class="w3l-forming">
					<i class="fa fa-unlock-alt" aria-hidden="true"></i>
					<input type="password"  class="name" name="password" placeholder="Create Password" required="">
				</div>
				<div class="w3l-forming">
					<i class="fa fa-unlock-alt" aria-hidden="true"></i>
					<input type="password"  class="name" name="confirm_password" placeholder="Confirm Password" required="">
				</div>
				<input type="submit" value="Register">
			</form>
		</div>
		<div class="w3l-mk">
			<img src="../images/2.png" alt="image" />
		</div>
		<div class="clear"></div>
	</div>
	<div class="footer-w3l">
		<p class="agileinfo"> &copy; 霖霖商城. 良心品质 </p>
	</div>

</body>
</html>