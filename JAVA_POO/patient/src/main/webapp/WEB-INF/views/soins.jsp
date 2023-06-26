<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../includes/header.jsp" />


<div>

  <form action="" method="post">
    <div>
      <label for="soins">Ajouter une feuille de soins : </label>
      <input type="text" name="soins" id="soins">
    </div>
    <input type="submit" value="Ajouter" >
  </form>
</div>


<jsp:include page="../includes/footer.jsp" />