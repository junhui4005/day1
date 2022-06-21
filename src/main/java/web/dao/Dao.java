package web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {

    protected Connection con;
    protected PreparedStatement ps;
    protected ResultSet rs;


    public Dao() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/day1?serverTimezone=UTC","root","1234");
            System.out.println("연동성공");
        }

        catch(Exception e) {System.out.println("sql ����" + e);}
    }

}
