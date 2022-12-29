<%@page import="java.util.ArrayList"%>
<%@page import="model.Publicacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/views/partials/header.jsp" %>

<%
    
    ArrayList<Publicacion> pubs=null;
    if(session.getAttribute("publicaciones")!=null){
    pubs = (ArrayList<Publicacion>) session.getAttribute("publicaciones");
    }          
 %>

<!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Publicaciones</title>
    </head>  
    
    
    <body>    
        <% 
        if(pubs!=null && !pubs.isEmpty()){
            for (Publicacion publicacion : pubs) {
           
        %>
                <h3 class="text-success"><%= publicacion.getUserName()%></h3>
                                                 
        <%
            }
        %>
        <%
        }else{
        %>
            <h3 class="text-success">NO HAY PUBLICACIONES</h3>
        <%
            }
        %>
    </body>