<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Fruit Shop</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="../CSS/main.css">
    </head>
    <body>
        <%  Cookie[] cookies = request.getCookies();
     String user = "";
     String role = "";
     if (cookies != null) {
         for (Cookie c : cookies) {
             if (c.getName().equals("email")) {
                 user = c.getValue();
                    
             }
             if (c.getName().equals("role")) {
                 role = c.getValue();
             }
         }
     }
     if (!user.isEmpty() && !role.isEmpty()) {
     session.setAttribute("email", user);
     session.setAttribute("role", role);
 }%>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="<%= request.getContextPath() %>">Fruit Shop</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="<%= request.getContextPath() %>">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/listProductServlet">Products</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contact</a>
                    </li>
                    <% if (session.getAttribute("email") == null) { %>
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Login</a>
                    </li>
                    <% } else { %>
                    <form action="LogoutServlet" method="post">
                        <button type="submit" class="nav-link btn btn-link">Logout</button>
                    </form>
                    <% } %>
                </ul>
            </div>
        </nav>