<%-- 
    Document   : edit
    Created on : 07/06/2018, 14:04:16
    Author     : jefferson
--%>

<%@page import="Model.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View</title>
    </head>
    <body>
        <%
            Client client = (Client) request.getAttribute("client");
        %>
        <h3>Visualizar Cliente</h3>
        <p><b>Nome:</b> <%= client.getNome() %></p>
        <p><b>Nascimento:</b> <%= client.getNascimento() %></p>
        <p><b>Endereço:</b> <%= client.getEndereco() %></p>
        <p><b>Cidade:</b> <%= client.getCidade() %></p>
        <p><b>Status:</b> <%= client.getStatus() %></p>
        <br><br>
        <a href="ClientsController?action=list">Home</a>
    </body>
</html>
