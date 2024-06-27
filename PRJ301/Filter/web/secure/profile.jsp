<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib uri="http://example.com/mytags" prefix="my" %>

<html>
<head>
    <title>User Profile</title>
</head>
<body>
     <my:greeting name="Dat"/>
    <a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
</body>
</html>