package zona_fit.connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnection {
    public static Connection getConnection(){
        Connection con = null;
        String database = "zonafit_db";
        String url = "jdbc:mysql://localhost:3306/" + database;
        String user = "root";
        String pass = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Error en la conexion de base de datos: " + e.getMessage());
        }

        return con;
    }
}
