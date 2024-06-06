<%-- 
    Document   : useForm
    Created on : Jun 3, 2024, 1:38:06 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>User Form</title>
    </head>
    <body>
        <form action="UserServlet" method="post">
            Name: <input type="text" name="name" /><br/>
            Email: <input type="text" name="email" /><br/>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>