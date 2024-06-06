<%-- 
    Document   : user
    Created on : Jun 3, 2024, 1:38:30 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User" %>

<!DOCTYPE html>
<html>
    <head>
        <title>User Information</title>
    </head>
    <body>
        <jsp:useBean id="userBean" type="model.User" scope="request" />
        <h1>User Information</h1>
        Name: ${userBean.name} <br/>
        Email: ${userBean.email} <br/>
        %>
        <% 
       userBean.setName("John Doe");
       out.println("Name = " + userBean.getName());
        %>
    </body>
</html>