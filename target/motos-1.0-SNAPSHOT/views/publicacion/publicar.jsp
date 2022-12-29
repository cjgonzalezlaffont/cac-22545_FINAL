
<%@include file="/views/partials/header.jsp" %>


<main class="container d-flex justify-content-center align-items-center">

    <form method="POST" action="/motos/publicacion/publicar" class="w-50 px-5 py-4 rounded" >
        <h2 class="mb-4 text-center">Crear Publicacion</h2>
        
        <div class="row mb-3">
            <label for="username" class="col-4 formlabel">NombreUsuario:</label>
            <input type="text" id="username" name="username" class="col-8 formcontrol">
        </div>
        
        <div class="row mb-3">
            <label for="modelo" class="col-4 formlabel">Modelo:</label>
            <input type="text" id="modelo" name="modelo" class="col-8 formcontrol">
        </div>

        <div class="row mb-3">
            <label for="descripcion" class="col-4 formlabel">Descripcion:</label>
            <input type="text" id="name" name="descripcion" class="col-8 formcontrol">
        </div>

        <div class="row mb-3">
            <label for="cilindrada" class="col-4 formlabel">Cilindrada:</label>
            <input type="text" id="cilindrada" name="cilindrada" class="col-8 formcontrol">
        </div>

        <div class="row mb-3">
            <label for="urlfoto" class="col-4 formlabel">URL-Foto:</label>
            <input type="text" id="urlfoto" name="urlfoto" class="col-8 formcontrol">
        </div>

        <div class="row align-items-center justify-content-between">
            <div class="col-auto">
                <button class="btn btn-dark" type="submit">Publicar</button>
            </div>
            <div class="col-auto">
                <a href="/motos" class="link-primary">Inicio</a>
            </div>
        </div>
    </form>
</main>

<%@include file="/views/partials/footer.jsp" %>

