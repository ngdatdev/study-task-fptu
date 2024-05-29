
<%@ page import="java.util.List" %>
<%@ page import="model.Teacher" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Teachers</title>
    </head>
    <body>
        <h2>Teachers List</h2>
        <table border="1">
            <tr>
                <th>Teacher ID</th>
                <th>Name</th>
                <th>Date of Birth</th>
                <th>Telephone</th>
            </tr>
            <%
                List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
                if (teachers != null) {
                    for (Teacher teacher : teachers) {
            %>
            <tr>
                <td><%= teacher.getTeacherID() %></td>
                <td><%= teacher.getName() %></td>
                <td><%= teacher.getDob() %></td>
                <td><%= teacher.getTel() %></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </body>
</html>

