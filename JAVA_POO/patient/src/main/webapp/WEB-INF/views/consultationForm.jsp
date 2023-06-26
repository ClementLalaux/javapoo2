<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../includes/header.jsp" />


<div>
  <form action="" method="post">
    <div>
      <label for="ajoutConsultation">Ajouter une consultation : </label>
      <input type="date" name="ajoutConsultation" id="ajoutConsultation">
    </div>
    <input type="submit" value="Ajouter une consultation" >
  </form>
</div>


<jsp:include page="../includes/footer.jsp" />