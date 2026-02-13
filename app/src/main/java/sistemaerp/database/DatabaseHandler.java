package sistemaerp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import io.github.cdimascio.dotenv.Dotenv;


//This class handles the database communication
//Program logic should be avoided here and put into Inventory Management
public class DatabaseHandler {

    public ArrayList<String> products = new ArrayList<>();
    private Dotenv dotenv = Dotenv.load();

    String url = dotenv.get("DB_URL");
    String user = dotenv.get("DB_USER");
    String password = dotenv.get("DB_PASSWORD");

    public void dbConnection(){

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado ao PostgreSQL com sucesso!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro na conexão!");
            e.printStackTrace();
        }
    }


    //There's already a table created called "usuarios" and one called "produtos"
    //This function is not widely called on the program, only when it's necessary to create or change tables
    public void createTable(){

        String sql = "ALTER TABLE produtos ALTER COLUMN productId ADD GENERATED ALWAYS AS IDENTITY;";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement stmt = conn.createStatement();

            stmt.executeUpdate(sql);

            System.out.println("Conectado ao PostgreSQL com sucesso! Tabela criada.");
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erro na conexão! Não foi possível criar a table.");
            e.printStackTrace();
        }

    }

    //Register the products into the database
    public void registerProducts(String description, String sku, int quantity, String maquina){

        String sql = "INSERT INTO produtos (description, sku,  qtd, maquina) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, description);
            stmt.setString(2, sku);
            stmt.setInt(3, quantity);
            stmt.setString(4, maquina);

            stmt.executeUpdate();

            System.out.println("Conectado ao PostgreSQL com sucesso! Produto cadastrado.");
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erro na conexão! Não foi possível cadastrar o produto.");
            e.printStackTrace();
        }
    }

    //Fix later
    public void alterProductQuant(String description, String mSku, int quantity){

        String sql = "UPDATE produtos SET qtd = ? WHERE sku = ?"; 

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, quantity);
            stmt.setString(2, mSku);

            stmt.executeUpdate();

            System.out.println("Conectado ao PostgreSQL com sucesso! Quantidade alterada.");
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erro na conexão! Não foi possível alterar quantidade.");
            e.printStackTrace();
        }


    }

    //Goes through all the data on the database to display all the products
    public ArrayList<String> showItems(){

        String sql = "SELECT * FROM produtos";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){

                products.add(rs.getString("description") + " " + rs.getString("sku") + " " + rs.getString("qtd"));
            
            }

            System.out.println("Conectado ao PostgreSQL com sucesso! Mostrando items.");
            conn.close();

            return products;
        } catch (SQLException e) {
            System.out.println("Erro na conexão! Não foi possível mostrar os items.");
            e.printStackTrace();
            return new ArrayList<String>();
        }

    }

}
