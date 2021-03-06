<!DOCTYPE html>
<html>
<title>Service Ops</title>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: 	Georgia, Garamond, serif;
  background-color: #f2f2f2;}

  p {
    font-family: Georgia, Garamond, serif;
    font-size: 20px;
    font-weight: bold;
  }
    h3{
    font-family: Georgia, Garamond, serif;
    font-size: 20px;
    font-weight: bold;
    color: red;
  }
  
  #header {
   background:#1f618d;
   padding:10px;
}
  
/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
  position: relative;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}
img.srvc {
  width: 40%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
  padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 5% auto 1% auto; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 40%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
  position: absolute;
  right: 25px;
  top: 0;
  color: #000;
  font-size: 35px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: red;
  cursor: pointer;
}

/* Add Zoom Animation */
.animate {
  -webkit-animation: animatezoom 0.6s;
  animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
  from {-webkit-transform: scale(0)} 
  to {-webkit-transform: scale(1)}
}
  
@keyframes animatezoom {
  from {transform: scale(0)} 
  to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}

/* Footer */
.footer {
position:absolute;
bottom:5px;
   width:99%;
   height:60px;   /* Height of the footer */
   background:#666;
}

</style>
</head>
<body>
<div id="header">
  <center><h1>Service Operations & Business Intelligence</h1>
</div>  
   <br><br><br>
	<center><h4>Click on below to login</h4>
	
	<button onclick="document.getElementById('id01').style.display='block'" style="width:20%;" name="btn"><b>Login</b></button>
<br>
 <h3> <% 
   if(session.getAttribute("err_msg")!=null)
	{
	out.print(session.getAttribute("err_msg"));
	}
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	session.removeAttribute("err_msg");
	%>
</h3>
<br><br><br><br>
<img src="ServiceOps.jpg" alt="Srvc" class="Srvc">

<div id="id01" class="modal">
  
  <form class="modal-content animate" action="Login" method="Post">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="img_avatar2.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
      <label for="uname"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="uname" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw" required>
        
      <button type="submit" name="loginbtn"><b>Login</b></button>
      <label>
        <input type="checkbox" checked="checked" name="remember"> Remember me
      </label>
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
    </div>
  </form>
</div>

<div class="footer">
 <p align="right">
 <a href="#" style="color:white" class="btn"> Contact Support</a>&nbsp&nbsp&nbsp&nbsp
 <a href="#" style="color:white" class="btn">About Us</a>&nbsp&nbsp&nbsp&nbsp
 </p>
</div>
<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>

</body>
</html>
