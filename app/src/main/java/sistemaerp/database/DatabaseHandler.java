package sistemaerp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler {

        public static void dbConnection(){
            String url = "jdbc:postgresql://192.168.100.80:5432/sistemaerpdb";
            String user = "postgres";
            String password = "root";

            try {
                Connection conn = DriverManager.getConnection(url, user, password);
                System.out.println("✅ Conectado ao PostgreSQL com sucesso!");
                conn.close();
            } catch (SQLException e) {
                System.out.println("❌ Erro na conexão!");
                e.printStackTrace();
            }
        }

}
