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
        <h3>Adicionar Cliente</h3>
        <form method="post" action="ClientsController?action=addSave">
            Nome: <input name="nome" type="text"/><br>
            Nascimento: <input name="nascimento" type="date"/><br>
            Endereço: <input name="endereco" type="text"/><br>
            Cidade: <input name="cidade" type="text"/><br>
            Status: <input name="status" type="number"/><br>
            
            <input type="submit" value="Cadastrar">
        </form>
    </body>
</html>
