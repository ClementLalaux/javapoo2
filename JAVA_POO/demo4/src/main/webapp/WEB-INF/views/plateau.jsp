<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 15/06/2023
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <title>Title</title>
</head>
<body class="container">

    <c:if test="${plateau.getCases() != null}">
        <div class="row">
        <c:forEach items="${plateau.getCases()}" var="c">
            <p class="col-1">x : ${c.getX()} , y : ${c.getY()}</p>

            <c:if test="${c.getX() ==10}">
                <div/>
                <div class="row">
            </c:if>
        </c:forEach>
        </div>
    </c:if>
</body>
</html>
