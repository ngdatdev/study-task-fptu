<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Room" %>
<%@ page import="model.RoomDB" %>
<%@page contentType="text/html" import="model.*,java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Available Rooms</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f8f9fa;
            }
            table {
                width: 80%;
                border-collapse: collapse;
                margin: 20px auto;
                background-color: #fff;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            }
            th, td {
                padding: 12px 15px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }
            th {
                background-color: #f2f2f2;
            }
            .btn-book {
                background-color: #4CAF50;
                color: white;
                padding: 8px 16px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                border-radius: 5px;
                cursor: pointer;
                border: none;
            }
            .navbar {
                background-color: #fff;
                box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);
            }
            .navbar-brand {
                font-weight: bold;
                color: #333;
            }
            .navbar-nav .nav-link {
                color: #333;
            }
            .nav-item.active .nav-link {
                font-weight: bold;
                color: #4CAF50;
            }
        </style>
    </head>
    <body>
        <% 
                List<Room> rooms = RoomDB.listAllAvailableRooms();
                request.setAttribute("rooms", rooms);
        %>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="<%= request.getContextPath() %>">Room Booking</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="<%= request.getContextPath() %>/RoomServlet">Rooms</a>
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
        <div class="container mt-4">
            <h2>Available Rooms</h2>
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th>ID</th>
                        <th>Room Number</th>
                        <th>Capacity</th>
                        <th>Floor</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="room" items="${rooms}">
                        <tr>
                            <td>${room.id}</td>
                            <td>${room.roomNumber}</td>
                            <td>${room.capacity}</td>
                            <td>${room.floor}</td>
                            <td>
                                <c:if test="${not empty sessionScope.email}">
                                    <form action="book_room.jsp" method="post">
                                        <input type="hidden" name="roomId" value="${room.id}">
                                        <input type="submit" value="Book" class="btn btn-success btn-book">
                                    </form>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>