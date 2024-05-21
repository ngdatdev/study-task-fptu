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
        Object studentsObj = request.getSession().getAttribute("students");
        List<Student> students = null;
        if (studentsObj instanceof List) {
            students = (List<Student>) studentsObj;
        }
        if (students != null) {
        %>
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
            <form action="UpdateStudentServlet" method="POST">
                <td><%= student.getId() %></td>
                <td><input type="text" name="name" value="<%= student.getName() %>"></td>
                <td><input type="text" name="gender" value="<%= student.isGender() ? "Male" : "Female" %>"></td>
                <td><input type="text" name="dob" value="<%= student.getDob() %>"></td>
                <td>
                    <input type="hidden" name="id" value="<%= student.getId() %>">
                    <input type="submit" value="Update">
                </td>
            </form>
        </tr>
        <% } %>
    </table>
    <% } %>

</body>
</html>
