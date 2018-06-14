<%-- 
    Document   : index
    Created on : 07/06/2018, 13:56:52
    Author     : jefferson
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Model.Client"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
    </head>
    <body>
        <h1>Clientes Cadastrados</h1>
        <% if (request.getAttribute("message") != null) { %>
            <span style="color: green"><%= request.getAttribute("message") %></span><br>
        <% } %>
        <table border="1">
            <thead>
                <th>ID</th>
                <th>Nome</th>
                <th>Nascimento</th>
                <th>Endereco</th>
                <th>Cidade</th>
                <th>Status</th>
                <th>Ações</th>
            </thead>
            <tbody>
                <%
                    List<Client> listaDeClientes = (List<Client>) request.getAttribute("listClients");
                    Iterator i = listaDeClientes.iterator();
                    while (i.hasNext()) {
                        Client client = (Client) i.next();
                %>
                <tr>
                    <td><%= client.getId() %></td>
                    <td><%= client.getNome() %></td>
                    <td><%= client.getNascimento() %></td>
                    <td><%= client.getEndereco()%></td>
                    <td><%= client.getCidade()%></td>
                    <td><%= client.getStatus() %></td>
                    <td>
                        <a href="ClientsController?action=view&id=<%= client.getId() %>">View</a><br>
                        <a href="ClientsController?action=edit&id=<%= client.getId() %>">Edit</a><br>
                        <a href="ClientsController?action=delete&id=<%= client.getId() %>">Delete</a><br>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <a href="ClientsController?action=add" style="text-decoration: none">
            <input type="button" value="Novo Cliente"/>
        </a>
    </body>
</html>
