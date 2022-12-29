<%@include file="/views/partials/header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<main>
    <body>
        
        <h1>Llego<h1>
                
        <h2 class="mb-3">Información de Publicación:</h2>
            
            <%
            int pCreada = (int) session.getAttribute("pCreada");
            switch (pCreada) {
                case 1:
                    %>
                    <h3 class="text-success">¡Publicacion realizada!</h3>
                    <%
                    break;
                case 2:
                    %>
                    <h3 class="text-danger">¡La publicacion ya existe!</h3>
                    <%
                    break;
                default:
                    %>
                    <h3 class="text-danger">¡Publicacion fallida!</h3>
                    <%
                    break;
            }
            %>      
                
    </body>
</main>
<%@include file="/views/partials/footer.jsp" %>
