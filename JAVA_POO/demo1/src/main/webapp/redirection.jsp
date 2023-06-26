<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 06/06/2023
  Time: 09:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1>Liste des produits</h1>
    <c:forEach items="${produits}" var="produit">
        <div>
            Référence : ${produit.getReference()}
            Marque: ${produit.getMarque()}
        </div>
    </c:forEach>
</div>
</body>
</html>
