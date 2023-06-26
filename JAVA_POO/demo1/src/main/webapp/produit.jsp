<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1>Produit</h1>
    <div>
        <p>Id : ${produit.getId()}</p>
        <p>Référence : ${produit.getReference()}</p>
        <p>Marque : ${produit.getMarque()}</p>
        <p>Date achat : ${produit.getDateAchat()}</p>
        <p>Prix : ${produit.getPrix()}</p>
        <p>Prix : ${produit.getStock()}</p>w
    </div>
</div>
</body>
</html>