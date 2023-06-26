<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../includes/header.jsp" />


<div>
  <form action="" method="post" enctype="multipart/form-data">
    <div>
      <input type="file" name="fichier" />
    </div>
    <input type="submit" name="prescription" value="Ajouter prescription" >
  </form>
</div>


<jsp:include page="../includes/footer.jsp" />