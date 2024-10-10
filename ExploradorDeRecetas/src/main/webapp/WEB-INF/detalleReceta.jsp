<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Detalle de la Receta</title>
    <link rel="stylesheet" href="/estilos/index.css">
</head>
<body>
    <h1>Detalle de la Receta</h1>
    <c:choose>
        <c:when test="${not empty mensajeError}">
            <p>${mensajeError}</p>
        </c:when>
        <c:otherwise>
            <h2>${nombreReceta}</h2>
            <ul>
                <c:forEach var="ingrediente" items="${ingredientes}">
                    <li>${ingrediente}</li>
                </c:forEach>
            </ul>
        </c:otherwise>
    </c:choose>
</body>
</html>
