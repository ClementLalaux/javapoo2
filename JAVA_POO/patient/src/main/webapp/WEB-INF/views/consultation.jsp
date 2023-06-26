<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../includes/header.jsp" />

<div>
  <h1>Consultation: </h1>

    <h2>Soins</h2>
      <div>.
        Id : ${soins.getId()}
      </div>

    <h2>Precription: </h2>
    <div>.
        Id : ${prescription.getId()}
    </div>

  <div>
    <h3><a href="soins?id=${id}">Ajouter feuille de soins</a></h3>
  </div>

  <div>
    <h3><a href="prescription?id=${id}">Ajouter prescription</a></h3>
  </div>
</div>

<jsp:include page="../includes/footer.jsp" />