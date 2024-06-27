<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Fruit" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" import="Model.*,java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    .btn-wide {
        width: 80px; 
        margin: 4px;
    }
</style>
<div class="container mt-5">

    <% 
        ArrayList<Fruit> allFruits = FruitDB.listAll();
        request.setAttribute("allFruits", allFruits);
    %>

    <div class="row">
        <c:forEach var="fruit" items="${allFruits}">
            <div class="col-md-4 mb-4">
                <div class="card h-100">
                    <div class="card-body text-center">
                        <img src="https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg" class="card-img-top"">
                        <h5 class="card-title">${fruit.productName}</h5>
                        <p class="card-text">${fruit.description}</p>
                        <p class="card-text"><strong>Price: $${fruit.price}/kg</strong></p>
                        <a href="#" class="btn btn-warning mb-2">Add to Cart</a>
                        <c:if test="${not empty sessionScope.email && sessionScope.role == 'admin'}">
                            <div class="d-flex justify-content-center">
                                <a href="edit_product.jsp?id=${fruit.productId}&name=${fruit.productName}&description=${fruit.description}&price=${fruit.price}" class="btn btn-primary mb-2 btn-wide">Edit</a>
                                <a href = "${pageContext.request.contextPath}/ProductServlet?action=DELETE&id=${fruit.productId}" class="btn btn-danger btn-sm mb-2 btn-wide">Delete</a> 
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</div>
