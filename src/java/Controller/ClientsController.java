package Controller;

import DAO.ClientDAO;
import Model.Client;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jefferson
 */
public class ClientsController extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher rd = null;
        ClientDAO clientDAO = new ClientDAO();

        if (action.equals("list")) {
            List listClients = clientDAO.list();

            request.setAttribute("listClients", listClients);

            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            
        } else if (action.equals("edit")) {
            String id = request.getParameter("id");
            Client client = clientDAO.view(Integer.parseInt(id));
            
            request.setAttribute("client", client);
            
            rd = request.getRequestDispatcher("edit.jsp");
            rd.forward(request, response);
        } else if (action.equals("editSave")) {
            
            Client client = new Client();
            client.setId(Integer.parseInt(request.getParameter("id")));
            client.setNome(request.getParameter("nome"));
            client.setNascimento(request.getParameter("nascimento"));
            client.setEndereco(request.getParameter("endereco"));
            client.setCidade(request.getParameter("cidade"));
            client.setStatus(Integer.parseInt(request.getParameter("status")));
            
            if (clientDAO.update(client)) {
                request.setAttribute("message", "Cliente alterado com sucesso!!!");
                rd = request.getRequestDispatcher("ClientsController?action=list");
                rd.forward(request, response);
            } else {
                request.setAttribute("message", "Erro ao alterar o Cliente =(");
            }
        } else if (action.equals("add")) {
            rd = request.getRequestDispatcher("add.jsp");
            rd.forward(request, response);
        } else if (action.equals("addSave")) {
            
            Client client = new Client();
            client.setNome(request.getParameter("nome"));
            client.setNascimento(request.getParameter("nascimento"));
            client.setEndereco(request.getParameter("endereco"));
            client.setCidade(request.getParameter("cidade"));
            client.setStatus(Integer.parseInt(request.getParameter("status")));
            
            if (clientDAO.insert(client)) {
                request.setAttribute("message", "Cliente cadastrado com sucesso!!!");
                rd = request.getRequestDispatcher("ClientsController?action=list");
                rd.forward(request, response);
            } else {
                request.setAttribute("message", "Erro ao cadastrar o Cliente =(");
            }
        } else if (action.equals("delete")) {
            String id = request.getParameter("id");
            Client client = new Client();
            client.setId(Integer.parseInt(id));
            
            clientDAO.delete(client);
            
            rd = request.getRequestDispatcher("ClientsController?action=list");
            rd.forward(request, response);
            
        } else if (action.equals("view")) {
            String id = request.getParameter("id");
            Client client = clientDAO.view(Integer.parseInt(id));
            
            request.setAttribute("client", client);
            
            rd = request.getRequestDispatcher("view.jsp");
            rd.forward(request, response);
        } 
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}