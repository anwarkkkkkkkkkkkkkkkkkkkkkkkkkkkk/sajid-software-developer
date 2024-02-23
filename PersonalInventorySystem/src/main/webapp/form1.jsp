<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.PersonalInventorySystem.bean.UsersBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style> 
 a {text-decoration: none; font-size:20px; color:blue;} 
     a:hover {background-color:orange;border:1px black solid;}
      #tablef{ border:2px dotted blue;padding:10px;background-color:black;}
 </style>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
         <script type="text/javascript" src="form.js">  </script>
             
</head>
<body>
   
 <form > <table id="tablef"> 
             <tr>
                <th> <font color="blue" size="20px">       Personal</font> 
             <!--    <th> <a href="homePageController" target="_parent" style="padding:10px ">Home</a> </th>  -->
                <th>    </th>
                <th> <a href="Registration Form.html" target="_parent" style="padding:5px">RegisterUser</a> </th>
                  <th>    </th>
                <th><a href="login" target="_parent"style="padding:5px">Login</a></th>                
             </tr>
             <tr>
               <th> <font color="orange" size="20px">Inventory</font> <font color="green" size="20px">System</font></th>
             </tr>      
           </table>
    </form>
      
    <form style=" color:blue" action="RegistrationController" method="post">    
		<fieldset>
			<legend align="left" >
				<strong>USER REGISTRATION </strong>
			</legend>
			<table >									
			     <tr> <th>Name: </th> <td><input type="text" name="name" id="n" value =<%=session.getAttribute("name")%> ></td> </tr>
			     <tr> <th>Username: </th> <td><input type="text" name="username" id="u" value=<%=session.getAttribute("username") %>></td> </tr>
			     <tr> <th>Password:</th> <td><input type="password" name="password" id="pa"value=<%=session.getAttribute("password") %> ></td> </tr>
			     <tr> <th>ConformPassword: </th> <td><input type="password" name="cpassword" id="cp"value=<%=session.getAttribute("cpassword") %> ></td> </tr>
			     <tr> <th>PhoneNumber: </th> <td><input type="number" id="ph" name="phone" max="9999999999" min="1000000000" value=<%=session.getAttribute("phone") %> ></td> </tr>
			     <tr> <th>Email: </th> <td><input type="email" name="email"id="em"value=<%=session.getAttribute("email") %> ></td> </tr>
			     <tr> <th> Address:</th> <td> <input type="text" name="address"id="a"value=<%=session.getAttribute("address") %> > </td> </tr>
			     <tr> <th> </th> <td> <input type="submit" value="Register" id="faction" >       
			     <td> <input type="reset" value="Clear"  ></td> </tr>
			     				     			     			     		     
		   </table>
	   </fieldset>
	 </form> 
     
</body>
</html>