package DAO;

/**
 *
 * @author jefferson
 */
import Model.Client;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jefferson
 */
public class ClientDAO {
    private Connection conn;
    
    public ClientDAO()
    {
        try {
            this.conn = ConnectionFactory.getConnection();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public List list()
    {
       try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM clientes");

            ResultSet rs = pstmt.executeQuery();

            List<Client> listClients = new ArrayList<Client>();

            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setNome(rs.getString("nome"));
                client.setNascimento(rs.getString("nascimento"));
                client.setEndereco(rs.getString("endereco"));
                client.setCidade(rs.getString("cidade"));
                client.setStatus(rs.getInt("status"));

                listClients.add(client);
            }

            pstmt.close();
            rs.close();

            return listClients;

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
    public boolean insert(Client client)
    {
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO clientes (nome, nascimento, endereco, cidade, status) VALUES (?, ?, ?, ?, ?)");

            pstmt.setString(1, client.getNome());
            pstmt.setString(2, client.getNascimento());
            pstmt.setString(3, client.getEndereco());
            pstmt.setString(4, client.getCidade());
            pstmt.setInt(5, client.getStatus());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException e) {
           e.printStackTrace();
            return false;
        }
    }
    
    public boolean update(Client client)
    {
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE clientes SET nome = ?, nascimento = ?, endereco = ?, cidade = ?, status = ? WHERE id = ?");

            pstmt.setString(1, client.getNome());
            pstmt.setString(2, client.getNascimento());
            pstmt.setString(3, client.getEndereco());
            pstmt.setString(4, client.getCidade());
            pstmt.setInt(5, client.getStatus());
            pstmt.setInt(6, client.getId());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException e) {
           e.printStackTrace();
            return false;
        }
    }
    
    public Client view(int id)
    {
       try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM clientes WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            Client client = new Client();

            while (rs.next()) {
                client.setId(rs.getInt("id"));
                client.setNome(rs.getString("nome"));
                client.setNascimento(rs.getString("nascimento"));
                client.setEndereco(rs.getString("endereco"));
                client.setCidade(rs.getString("cidade"));
                client.setStatus(rs.getInt("status"));
            }

            pstmt.close();
            rs.close();

            return client;

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
    public boolean delete(Client client)
    {
        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM clientes WHERE id = ?");

            pstmt.setInt(1, client.getId());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException e) {
           e.printStackTrace();
            return false;
        }
    }
}
