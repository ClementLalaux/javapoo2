<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../includes/header.jsp" />

<div>
    <h1>Liste des patients</h1>

    <c:forEach items="${patients}" var="patient">
    <div>
        Nom : ${patient.getNom()}
        prenom: ${patient.getPrenom()}
    </div>
    </c:forEach>

    <form action="patient" method="post">
        <div>
            <label for="recherche">Recherche : </label>
            <input type="text" name="recherche" id="recherche">
        </div>
        <input type="submit" value="Rechercher" >
    </form>
</div>


