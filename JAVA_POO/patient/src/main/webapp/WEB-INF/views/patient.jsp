<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../includes/header.jsp" />

<div>
    <h1>Description du patient : ${patient.getNom()} ${patient.getPrenom()}</h1>
    <div>
        <c:if test="${consultations != null}">
            <c:forEach items="${consultations}" var="consultation">
                <div>.
                    Id : ${consultation.getId()} <a href="consultationForm?id=${consultation.getId()}">Voir plus</a>
                </div>
            </c:forEach>
        </c:if>
        <a href="consultationForm}">Ajouter une consultation</a>
    </div>
</div>


<jsp:include page="../includes/footer.jsp" />