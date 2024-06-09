<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="banner.jsp" %>

<div class="container">
    <h2>Edit Product</h2>
    <%
        int id = Integer.parseInt(request.getParameter("id"));
        Fruit fruit = FruitDB.getFruitById(id);
    %>
    <form action="<%= request.getContextPath() %>/editProductServlet" method="post">
        <input type="hidden" name="id" value="<%= fruit.getId() %>">
        <div class="form-group">
            <label for="name">Product Name:</label>
            <input type="text" class="form-control" id="name" name="name" value="<%= fruit.getProductName() %>">
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <input type="text" class="form-control" id="description" name="description" value="<%= fruit.getDescription() %>">
        </div>
        <div class="form-group">
            <label for="price">Price:</label>
            <input type="text" class="form-control" id="price" name="price" value="<%= fruit.getPrice() %>">
        </div>
        <button type="submit" class="btn btn-primary">Update Product</button>
    </form>
</div>

