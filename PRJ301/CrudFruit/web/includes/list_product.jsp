<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Fruit" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" import="Model.*,java.util.*" pageEncoding="UTF-8"%>
<!-- Product Listings Section -->
<div class="container">
    <% 
        ArrayList<Fruit> allFruits = FruitDB.listAll();
        int row = allFruits.size(); 
        for (int i = 0; i < row; i+=2) {
            Fruit fruit1 = allFruits.get(i);
            Fruit fruit2 = (i+1 < row) ? allFruits.get(i+1) : null;
    %>

    <div class='row'>
        <div class='col-md-6' align='center'>
            <div class='card'>
                <div class='card-body'>
                    <h5 class='card-title'> <%= fruit1.getProductName() %> </h5>
                    <p class='card-text'> <%= fruit1.getDescription() %> </p>
                    <p class='card-text'> Price: $<%= fruit1.getPrice() %>/kg </p>
                    <a href='#' class='btn btn-warning'> Add to Cart </a>
                    <c:if test="${not empty sessionScope.email}">
                        <a href="${request.contextPath}/EditProduct?id=${fruit1.productId}" class="btn btn-success">Edit</a>
                        <form action="DeleteProductServlet" method="post">
                            <input type="hidden" name="id" value="<%= fruit1.getProductId() %>">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>                    
                    </c:if>
                    </div>
                </div>
            </div>
        <% if (fruit2 != null) { %>
        <div class='col-md-6' align='center'>
            <div class='card'>
                <div class='card-body'>
                    <h5 class='card-title'> <%= fruit2.getProductName() %> </h5>
                    <p class='card-text'> <%= fruit2.getDescription() %> </p>
                    <p class='card-text'> Price: $<%= fruit2.getPrice() %>/kg </p>
                    <a href='#' class='btn btn-warning'> Add to Cart </a>

                    <c:if test="${not empty sessionScope.email}">
                        <a href="${request.contextPath}/EditProduct?id=${fruit2.productId}" class="btn btn-success">Edit</a>
                        <form action="DeleteProductServlet" method="post">
                            <input type="hidden" name="id" value="<%= fruit2.getProductId() %>">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                    </c:if>
                </div>
            </div>
        </div>
        <% } %>
    </div>
    <% } %>
</div>