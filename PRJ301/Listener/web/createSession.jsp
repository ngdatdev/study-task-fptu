<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Session</title>
</head>
<body>
    <h1>Create Session</h1>
    <form action="MyServlet" method="get">
        <input type="submit" value="Create Session">
    </form>
    <%
        String sessionId = request.getParameter("sessionId");
        if (sessionId != null) {
    %>
        <p>Session ID: <%= sessionId %></p>
    <%
        }
    %>
</body>
</html>
