package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {
//실행용 파일엔 메인 메서드가 있다. 메인메서드 있는 파일이 여기부터 실행한다는 뜻으로, public부터 그게 실행 파일임.

        // DB 접속을 위한 Connection instance 생성을 위한 레퍼런스 변수 선언
        // finally 블럭에서 사용하기 위해 try 블럭 밖에 선언함
        Connection con = null;

        try {
            // 사용할 Driver 등록
            Class.forName("com.mysql.cj.jdbc.Driver"); //메모리에 할당 후 써야함
            
            //DriverManager를 이용해 Connection 생성
            con = DriverManager.getConnection("jdbc:mysql://localhost/employee", //예외처리 하기!
                    "ohgiraffers","ohgiraffers"); // 커넥션을 만들 때 매개변수 필요

            System.out.println(con);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            //오류코드가 뭔지 보여주는 명령어
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {  //달아줘야 오류가 나도 실행이 됨
            if(con != null); { // null?? !가 붙는다면 부정
                try {
                    con.close();//close로 자원 반납하기
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
