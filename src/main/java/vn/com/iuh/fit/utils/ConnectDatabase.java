package vn.com.iuh.fit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    public static String url = "jdbc:mariadb://localhost:3306/thuoc_db";
    public static String user = "root";
    public static String password = "123456";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
