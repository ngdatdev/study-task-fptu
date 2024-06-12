<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Fruit" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" import="Model.*,java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">

    <% 
        ArrayList<Fruit> allFruits = FruitDB.listAll();
        for (Fruit fruit : allFruits) {
    %>

    <div class='row'>
        <div class='col-md-12' align='center'>
            <div class='card'>
                <div class='card-body'>
                    <h5 class='card-title'> <%= fruit.getProductName() %> </h5>
                    <p class='card-text'> <%= fruit.getDescription() %> </p>
                    <p class='card-text'> Price: $<%= fruit.getPrice() %>/kg </p>
                    <a href='#' class='btn btn-warning'> Add to Cart </a>
                    <c:if test="${not empty sessionScope.email && sessionScope.role == 'admin'}">
                        <form action="edit_product.jsp" method="get">
                            <input type="hidden" name="id" value="<%= fruit.getProductId() %>">
                            <button type="submit" class="btn btn-primary">Edit</button>
                        </form>  
                        <form action="DeleteProductServlet" method="post">
                            <input type="hidden" name="id" value="<%= fruit.getProductId() %>">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>                    
                    </c:if>
                </div>
            </div>
        </div>
    </div>
    <% } %>

</div>
