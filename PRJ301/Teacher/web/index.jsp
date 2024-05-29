<%-- 
    Document   : index.jsp
    Created on : May 27, 2024, 3:33:01 PM
    Author     : admin
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>Search Teachers by Year of DOB</title>
    </head>
    <body>
        <h1>Search Teachers by Year of DOB</h1>
        <form action="TeacherServlet" method="get">
            <label for="dob">Date of Birth:</label>
            <input type="text" id="dob" name="dob" placeholder="YYYY-MM-DD">
            <input type="submit" value="Search">
        </form>
    </body>
</html>