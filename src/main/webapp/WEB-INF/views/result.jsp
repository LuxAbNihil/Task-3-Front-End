
<html>
   <head>
      <title>Spring MVC Form Handling</title>
      <link rel="stylesheet" href="/resources/bootstrap.min.css"/>
   </head>

   <body>
      <jsp:include page="navbar.jsp">
         <jsp:param name="Navigation Bar" value=""/>
      </jsp:include>
      <h2>Submitted User Information</h2>
      <table>
         <tr>
            <td>Username</td>
            <td>${username}</td>
         </tr>
         <tr>
            <td>Address</td>
            <td>${address}</td>
         </tr>
         <tr>
            <td>Phone Number</td>
            <td>${phoneNumber}</td>
         </tr>
         <tr>
            <td>Age</td>
            <td>${age}</td>
         </tr>
      </table>  
   </body>
   
</html>