<%-- 
    Document   : CVMenu
    Created on : 5 jun 2024, 23:59:32
    Author     : user
--%>

<%@page import="com.mycompany.hojascv.models.CV"%>
<%@page import="com.mycompany.hojascv.models.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CV Menu</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <%
            CV cv = (CV) request.getAttribute("CV");
        %>
        <div class="container">
            <div class="row">
                <div class="col-3"></div>
                <div class="col-6">
                    <form method="POST" action="Servlet" class="border px-3 py-3 mt-5 rounded">
                        <div class="row align-items-center">
                            <input name="Id" value="<%=cv.getId()%>"  readonly>
                            <% if (cv.getPerson().getName() == null) {
                            %>
                            <div class="col-8">
                                <label for="inputId" class="form-label">Name</label>
                                <input type="text" class="form-control" name="Name" value="" aria-describedby="Id" required>
                            </div>
                            <div class="col-2">
                                <label for="inputTitle" class="form-label">Age</label>
                                <input type="number" class="form-control" name="Age" value="" aria-describedby="Title" required>
                            </div>
                            <div class="col-2">
                                <label for="inputTitle" class="form-label">Sex (M/F)</label>
                                <input type="text" maxlength="1" class="form-control" name="Sex" value="" aria-describedby="Title" pattern="[MF]" required>
                            </div>
                            <%} else {%>
                            <div class="col-8">
                                <label for="inputId" class="form-label">Name</label>
                                <input type="text" class="form-control" name="Name" value="<%=cv.getPerson().getName()%>" aria-describedby="Id" required>
                            </div>
                            <div class="col-2">
                                <label for="inputTitle" class="form-label">Age</label>
                                <input type="number" class="form-control" name="Age" value="<%=cv.getPerson().getAge()%>" aria-describedby="Title" required>
                            </div>
                            <div class="col-2">
                                <label for="inputTitle" class="form-label">Sex (M/F)</label>
                                <input type="text" maxlength="1" class="form-control" name="Sex" value="<%=cv.getPerson().getSex()%>" aria-describedby="Title" pattern="[MF]" required>
                            </div>
                            <%}%>
                        </div>
                        <div class="row align-items-center">
                            <label for="inputTitle" class="form-label">General Information</label>
                            <input type="text" class="form-control" name="General" value="<%=cv.getGeneral()%>" aria-describedby="Title">
                        </div>
                        <div class="row align-items-center">
                            <label for="inputTitle" class="form-label">Experience</label>
                            <input type="text" class="form-control" name="Experience" value="<%=cv.getExperience()%>" aria-describedby="Title">
                        </div>
                        <div class="row align-items-center">
                            <label for="inputTitle" class="form-label">Skills</label>
                            <input type="text" class="form-control" name="Skills" value="<%=cv.getSkills()%>" aria-describedby="Title">
                        </div>
                        <div class="row align-items-center mt-3 px-2">
                            <button type="Guardar" class="btn btn-primary">Save</button>
                        </div>
                    </form>
                </div>
                <div class="col-3"></div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>
</html>
