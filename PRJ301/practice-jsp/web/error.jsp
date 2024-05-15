<%-- 
    Document   : error
    Created on : May 15, 2024, 1:16:26 PM
    Author     : admin
--%>

<%@page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Sorry an exception occured!</h3>  
        Exception is: <%= exception %>   
    </body>
</html>
