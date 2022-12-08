package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Util {
    // реализуйте настройку соеденения с БД
    private Util(){

    }

   private final static String user = "root";
    private final static String password = "7943579";
    private final static String url = "jdbc:mysql://localhost:3306/MainbBase";
    private  static Connection connection;

    public static Connection getConnection()  {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            // System.out.println("Есть соединение");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // System.out.println("Нет соединения");
        }
        return connection;
    }
    public static void connectionClose(){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
        }
    }
}
