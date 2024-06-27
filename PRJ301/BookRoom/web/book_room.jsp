<%-- 
    Document   : book_room
    Created on : Jun 26, 2024, 1:39:11 PM
    Author     : admin
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Room</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <style>
        .container {
            margin-top: 50px;
        }
        .form-group {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <%-- Navigation bar --%>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="<%= request.getContextPath() %>">Room Booking</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="<%= request.getContextPath() %>">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%= request.getContextPath() %>/RoomServlet">Room</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
                <% if (session.getAttribute("email") == null) { %>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Login</a>
                </li>
                <% } else { %>
                <form action="SignOutServlet" method="post">
                    <button type="submit" class="nav-link btn btn-link">Logout</button>
                </form>
                <% } %>
            </ul>
        </div>
    </nav>

    <%-- Booking form --%>
    <div class="container">
        <h2>Book Room</h2>
        <form action="RoomServlet" method="post">
            <div class="form-group">
                <label for="roomId">Room ID:</label>
                <input type="text" id="roomId" name="roomId" value="${param.roomId}" readonly="">
            </div>
            <div class="form-group">
                <label for="bookingDate">Booking Date:</label>
                <input type="date" id="bookingDate" name="bookingDate" required>
            </div>
            <div class="form-group">
                <label for="startTime">Start Time:</label>
                <input type="time" id="startTime" name="startTime" required>
            </div>
            <div class="form-group">
                <label for="endTime">End Time:</label>
                <input type="time" id="endTime" name="endTime" required>
            </div>
            <div class="form-group">
                <label for="purpose">Purpose:</label>
                <input type="text" id="purpose" name="purpose" required>
            </div>
            <button type="submit" class="btn btn-primary">Book Room</button>
        </form>
    </div>
</body>
</html>