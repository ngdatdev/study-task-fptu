<%-- 
    Document   : login
    Created on : Jun 5, 2024, 11:36:58 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
//            window.onload = function () {
//                var username = getCookie("username");
//                var password = getCookie("password");
//                if (username !== "" && password !== "") {
//                    document.getElementById("username").value = username;
//                    document.getElementById("password").value = password;
//                    document.getElementById("rememberMe").checked = true;
//                }
//            };
//
//            function getCookie(cookieName) {
//                var name = cookieName + "=";
//                var decodedCookie = decodeURIComponent(document.cookie);
//                var cookieArray = decodedCookie.split(';');
//                for (var i = 0; i < cookieArray.length; i++) {
//                    var cookie = cookieArray[i].trim();
//                    if (cookie.indexOf(name) === 0) {
//                        return cookie.substring(name.length, cookie.length);
//                    }
//                }
//                return "";
//            }
//        </script>
    </head>
    <body>
        <h2>Login Page</h2>
        <%
            String username = "";
            String password = "";
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("username".equals(cookie.getName())) {
                        username = cookie.getValue();
                    } else if ("password".equals(cookie.getName())) {
                        password = cookie.getValue();
                    }
                }
            }
        %>
        <form action="LoginServlet" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="<%= username %>"><br><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="<%= password %>"><br><br>
            <input type="checkbox" id="rememberMe" name="rememberMe" <%= (!username.isEmpty() && !password.isEmpty()) ? "checked" : "" %>>
            <label for="rememberMe">Remember me</label><br>
            <input type="submit" value="Login">
        </form>
        <% if (request.getAttribute("errorMessage") != null) { %>
        <p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
        <% } %>
    </body>
</html>
