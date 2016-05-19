<%-- 
    Document   : index
    Created on : 9 Apr, 2016, 11:17:45 PM
    Author     : Maheswari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title >Web Spam Detection</title>
        <style>
.temp123
{
margin: 0 auto;
margin-left: auto;
margin-right: auto;
text-align:center;
}
</style>
    </head>
    
    <body>
      
        <h1 align="center">Web Spam Detection System</h1>
        <form action="myservlet" method="POST">
            <br>  <br>  <br>  <br>
          
    <div class ="temp123">
    

        Enter the URL: <input  name="inputurl" type="text" 
                              value=""size="40">
               
        <br>
       <br/>
        <input type="submit" value="Detect">
        </div>
      </form>  
    </body>

   
</html>
