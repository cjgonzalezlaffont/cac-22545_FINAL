<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Motos</title>
        <link rel="stylesheet" href="/motos/css/tags.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    </head>
<body class="vh-100">
    <header class="d-flex flex-row justify-content-around align-items-center bg-secondary text-center">
            <a href="/motos">
                <img class="rounded" style="height: 75px;" src="https://images.vexels.com/media/users/3/152376/isolated/preview/c5f4390c69b1c5113cec24502b46cc8e-icono-de-motocicleta-cl-sica.png" alt="motos_logo"/>
            </a>
            <h3>Motos</h3>
            <p></p>
            <%
                boolean isLogin;
                if(session.isNew()){
                    session.setAttribute("isLogin", false); 
                }
                isLogin = (boolean) session.getAttribute("isLogin");
            %>
            
            <ul class="nav nav-pills">
                <li class="nav-item mx-2">
                    <a class="nav-link active" href="/motos/views/publicacion/publicaciones.jsp">Ver publicaciones</a>
                </li>
                <li class="nav-item mx-2" style="display: <%= isLogin?"none":"initial" %>">
                    <a class="nav-link active " href="/motos/views/usuario/login.jsp">Ingresar</a>
                </li>
                <li class="nav-item mx-2" style="display: <%= isLogin?"none":"initial" %>">
                    <a class="nav-link active" href="/motos/views/usuario/registro.jsp">Registrarme</a>
                </li>
                <li class="nav-item mx-2" style="display: <%= !isLogin?"none":"initial" %>">
                    <a class="nav-link active" href="/motos/views/publicacion/publicar.jsp">Publicar</a>
                </li>
                <li class="nav-item mx-2" style="display: <%= !isLogin?"none":"initial" %>">
                    <a class="nav-link active" href="/motos/views/publicacion/mispublicaciones.jsp">Mis publicaciones</a>
                </li>
                <li class="nav-item mx-2" style="display: <%= !isLogin?"none":"initial" %>">
                    <a class="nav-link active" href="/motos/usuario/viewUser">Mi cuenta</a>
                </li>
                <li class="nav-item mx-2" style="display: <%= !isLogin?"none":"initial" %>">
                    <a class="nav-link active" href="/motos/usuario/logoutUser">Salir</a>
                </li>
            </ul>
        
    </header>