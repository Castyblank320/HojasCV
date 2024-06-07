<%-- 
    Document   : List
    Created on : 5 jun 2024, 23:16:20
    Author     : user
--%>

<%@page import="com.mycompany.hojascv.models.CV"%>
<%@page import="com.mycompany.hojascv.models.Person"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List</title>
        <link rel="stylesheet" href="https://cdn.datatables.net/2.0.8/css/dataTables.dataTables.css" />
        <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
        <script src="https://cdn.datatables.net/2.0.8/js/dataTables.js"></script>
    </head>
    <body>
        <h1>CV list</h1>
        <table id="tblProducts">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Sex</th>
                    <th> </th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<CV> CVs = (ArrayList<CV>) request.getAttribute("CVs");
                    if (CVs.size() > 0) {
                        for (CV cv : CVs) {
                %>
                <tr>
                    <td><%=cv.getPerson().getName()%></td>
                    <td><%=cv.getPerson().getAge()%></td>
                    <td><%=cv.getPerson().getSex()%></td>
                    <td>
                        <a href="/HojasCV/index?id=<%=cv.getId()%>" >Edit CV</a>
                    </td>
                    <td>
                        <a href="/HojasCV/index?id=<%=cv.getId()%>&delete=True" >Delete</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
        <a href="/HojasCV/index?id=-1" >Add CV</a>
        <script>
            new DataTable('#tblProducts');
        </script>
    </body>
</html>
