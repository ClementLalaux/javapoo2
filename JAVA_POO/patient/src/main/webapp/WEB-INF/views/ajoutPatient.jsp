<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../includes/header.jsp" />

<h1>Ajouter des patients</h1>
<div>
  <form action="ajoutPatient" method="post">
    <div>
      <label for="nom">Nom : </label>
      <input type="text" name="nom" id="nom">
    </div>
    <div>
      <label for="prenom">Prenom : </label>
      <input type="text" name="prenom" id="prenom">
    </div>
    <input type="submit" value="Entrer un nouveau patient" >
  </form>
  <hr/>
</div>

<jsp:include page="../includes/footer.jsp" />
