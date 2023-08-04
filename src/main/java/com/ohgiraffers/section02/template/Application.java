package com.ohgiraffers.section02.template;

import java.sql.Connection;
import java.sql.SQLException;

import static com.ohgiraffers.section02.template.JDBCTemplate.getConnection;

public class Application {

    public static void main(String[] args) {

        Connection con = getConnection(); //import를 할때 와일드 카드 쓰는 걸 지향
        System.out.println(con);

        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
