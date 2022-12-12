package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Util {
    // реализуйте настройку соеденения с БД
    private Util(){

    }

   private final static String USER = "root";
    private final static String PASSWORD = "7943579";
    private final static String URL = "jdbc:mysql://localhost:3306/MainbBase";
    private  static Connection CONNECTION;

    public static Connection getConnection()  {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
            CONNECTION.setAutoCommit(false);
            // System.out.println("Есть соединение");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // System.out.println("Нет соединения");
        }
        return CONNECTION;
    }
    public static void connectionClose(){
        if (CONNECTION !=null){
            try {
                CONNECTION.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
        }
    }
}
