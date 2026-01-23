package sistemaerp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler {

    public static void dbConnection(){
        String url = "jdbc:postgresql://26.131.56.31:5432/sistemaerpdb";
        String user = "postgres";
        String password = "root";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado ao PostgreSQL com sucesso!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro na conexão!");
            e.printStackTrace();
        }
    }


    //There's already a table created called "usuarios"
    public static void createTable(){

        String url = "jdbc:postgresql://26.131.56.31:5432/sistemaerpdb";
        String user = "postgres";
        String password = "root";

        String sql = "CREATE TABLE IF NOT EXISTS usuarios(userId INT PRIMARY KEY, name VARCHAR(25), area VARCHAR(25))";

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

}
