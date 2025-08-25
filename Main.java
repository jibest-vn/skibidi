package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String driverName = "com.mysql.cj.jdbc.Driver";
        String jdbcUrl = "jdbc:mysql://localhost:3306/daustudent2025?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            Class.forName(driverName);
            try (Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
                 Statement stmt = myConn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT id, firstname, lastname, email FROM studenttbl")) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String firstname = rs.getString("firstname").trim();
                    String lastname = rs.getString("lastname").trim();
                    String email = rs.getString("email").trim();

                    Student s = new Student(id, firstname, lastname, email);
                    System.out.println(s.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
