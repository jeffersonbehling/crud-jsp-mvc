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
        <title>Editar</title>
    </head>
    <body>
        <% 
            Client client = (Client) request.getAttribute("client"); 
            if (String.valueOf(client.getId()) != null) {
        %>
        <h3>Editar Cliente</h3>
        <form method="post" action="ClientsController?action=editSave">
            <input name="id" type="hidden" value="<%= client.getId() %>"/><br>
            Nome: <input name="nome" type="text" value="<%= client.getNome() %>"/><br>
            Nascimento: <input name="nascimento" type="date" value="<%= client.getNascimento() %>"/><br>
            Endereço: <input name="endereco" type="text" value="<%= client.getEndereco() %>"/><br>
            Cidade: <input name="cidade" type="text" value="<%= client.getCidade() %>"/><br>
            Status: <input name="status" type="number" value="<%= client.getStatus() %>"/><br>
            
            <input type="submit" value="Salvar">
        </form>
            <% } else { %> 
                <h3 style="color: red">Cliente não encontrado</h3>
            <% } %>
    </body>
</html>
