<%-- 
    Document   : articleList
    Created on : May 29, 2024, 1:12:04 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Post" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <body>
        
     
        <table border="1">
            <tr>
                <th>ArticleID</th>
                <th>Tiêu đề</th>
                <th>Loại</th>
            </tr>
             <%
                List<Post> posts = (List<Post>) request.getAttribute("posts");
                if (posts != null) {
                    for (Post p : posts) {
            %>
            <tr>
                <td><%= p.getArticleId() %></td>
                <td><%= p.getTitle() %></td>
                <td><%= p.getType() %></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </body>
</html>