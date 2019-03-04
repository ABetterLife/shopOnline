<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="../css/style2.css" rel="stylesheet" type="text/css" media="all" />
<link href="../css/font-awesome2.css" rel="stylesheet"> <!-- Font-Awesome-Icons-CSS -->

<!-- //Custom Theme files -->
<!-- web font --> 
<link href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=latin-ext" rel="stylesheet">
<!-- //web font --> 
</head>
<body>
<div class="main">
		<h1>霖霖商城   良心品质</h1>
		<div class="main-w3lsrow">
			<!-- login form -->
			<div class="login-form login-form-left"> 
				<div class="agile-row">
					<h2>Login to your site</h2>
					<span class="fa fa-lock"></span>
					<div class="clear"></div>
					<div class="login-agileits-top"> 	
						<form action="${pageContext.request.contextPath}/ClientServlet?operation=login" method="post"> 
							<input type="text" class="name" name="userName" Placeholder="Username" required=""/>
							<input type="password" class="password" name="password" Placeholder="Password" required=""/>
							<input type="submit" value="Login"> 
						</form> 	
					</div> 
					<div class="login-agileits-bottom"> 
						<h6><a href="#">Forgot password?</a></h6>
					</div> 

				</div>  
			</div>  
		</div>	
		
					<!--  <div class="login-agileits-bottom1"> 
						<h3>or login with</h3>
					</div> -->
					<!--  
					<div class="social_icons agileinfo">
						<ul class="top-links">
									<li><a href="#" class="facebook"><i class="fa fa-facebook"></i>facebook</a></li>
									<li><a href="#" class="twitter"><i class="fa fa-twitter"></i>twitter</a></li>
									<li><a href="#" class="linkedin"><i class="fa fa-linkedin"></i>linkedin</a></li>
								</ul>
					</div>
					-->
		
		<!-- copyright -->
		<div class="copyright">
			<p> © 霖霖商城. 良心品质 </p>
		</div>
		<!-- //copyright --> 
	</div>	
	<!-- //main --> 
${message}
</body>
</html>