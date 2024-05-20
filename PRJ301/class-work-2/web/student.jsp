<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student List</title>
    </head>
    <body>
        <form action="StudentServlet" method="POST">        
            <label>Number of students:</label>
            <input type="text" name="number" required>
            <input type="submit" value="Generate">
        </form>


        <%
        Object studentsObj = request.getAttribute("students");
        List<Student> students = null;
        if (studentsObj instanceof List) {
            students = (List<Student>) studentsObj;
        }
        if (students != null) {
        %>
         <form action="UpdateStudentServlet" method="POST">
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Date of Birth</th>
                    <th>Action</th>
                </tr>
                <% for (Student student : students) { %>
                <tr>
                    <td><%= student.getId() %></td>
                    <td><%= student.getName() %></td>
                    <td><%= student.isGender() ? "Male" : "Female" %></td>
                    <td><%= student.getDob() %></td>
                    <td>
                        <button type="submit" name="updateId" value="<%= student.getId() %>">Update</button>
                    </td>
                </tr>
                <% } %>
            </table>
            <input type="hidden" name="students" value="<%= students %>">
        </form>
    <% } %>
</body>
</html>
