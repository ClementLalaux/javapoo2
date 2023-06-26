<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 06/06/2023
  Time: 09:56
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
      <a href="pro?id=${produit.getId()}"> Lien produit </a>
    </div>
  </c:forEach>
  <div>
    <form action="produit" method="post">
      <div>
        <label for="reference">Entrer une référence: </label>
        <input type="text" name="reference" id="reference">
      </div>
      <div>
        <label for="marque">Entrer une marque: </label>
        <input type="text" name="marque" id="marque">
      </div>

      <input type="submit" value="Entrer un nouveau produit">
    </form>
  </div>

</div>
</body>
</html>
