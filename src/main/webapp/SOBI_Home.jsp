<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SOBI Home Page</title>

</head>
<style>
  h1 {
    font-family: Constaina, Georgia, Garamond, serif;
    font-size: 30px;
    font-weight: bold;
    color:  #ecf0f1;
  }
  
   h4 {
    font-family: Constaina, Georgia, Garamond, serif;
    font-size: 20px;
    font-weight: bold;
    color: #922b21 ;
  }
  
body {
	font-family: 	Georgia, Garamond, serif;
  background-color: #5dade2;
   margin:0;
   padding:0;
   height:100%;
}
#header {
   background:#1f618d;
   padding:10px;
}
#body {
   padding:10px;
   padding-bottom:60px;   /* Height of the footer */
}
/* Footer */
#footer {
position:absolute;
bottom:0;
   width:100%;
   height:60px;   /* Height of the footer */
   background: #1f618d  ;
}

input[type=submit] {
     color:blue;
     border:none; 
     font: inherit;
}
</style>

<body>

<% 

	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("index.jsp");
	}

%>
	<div id="header">
	<marquee behavior="scroll" direction="left">
		<center><h1>Welcome to Service Operations & Business Intelligence</h1>
	</marquee>
	</div>

	
	<br>
	<div id="body" align="right">
		<form action="Logout">  
		<b>Hello <% out.print(session.getAttribute("username"));%>&nbsp&nbsp
		<u><input type="submit" value="log out"/></u>&nbsp&nbsp</b>
		</form>
		
		<h4 align="left"> <I>&nbsp&nbspIntroduction to Service Operations<br></I>
		<br>&nbsp&nbsp&nbsp&nbsp
		<center><iframe width="560" height="315" src="https://www.youtube.com/embed/9HHwZ7vFe7Q" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
		</h4>
	</div>
	<div id="footer">
		<p align="right">
 		<a href="#" style="color:white" class="btn"> Contact Support</a>&nbsp&nbsp&nbsp&nbsp
 		<a href="#" style="color:white" class="btn">About Us</a>&nbsp&nbsp&nbsp&nbsp
 		</p>
	</div>
</body>
</html>