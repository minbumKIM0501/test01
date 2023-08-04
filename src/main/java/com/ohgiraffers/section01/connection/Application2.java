package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application2 {

    public static void main(String[] args) {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost/employee";
        String user = "ohgiraffers";
        String password ="ohgiraffers";

        Connection con = null; // 초기화

        try {
            Class.forName(driver);

            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(con != null); {
                try {
                    con.close(); // 다 쓴 자원은 close 로 반납!
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
