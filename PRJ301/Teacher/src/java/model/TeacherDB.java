/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDB {

    private static final String DB_URL = "jdbc:sqlserver://LAPTOP-7M53ESA2;databaseName=PRJ301_DE180922;encrypt=false;trustServerCertificate=false;loginTimeout=30";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "zxcl123123";

    public static List<Teacher> searchTeachersByYearOfDOB(String year) throws ClassNotFoundException {
        String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        Class.forName(driverClass);
        
        List<Teacher> teachers = new ArrayList<>();
        String sql = "SELECT * FROM TEACHER WHERE DOB = ?";
        try ( Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, year);
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String teacherID = rs.getString("TeacherID");
                    String name = rs.getString("Name");
                    String dob = rs.getString("DOB");
                    String tel = rs.getString("Tel");
                    teachers.add(new Teacher(teacherID, name, dob, tel));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    public static void main(String[] args) {
//        List<Teacher> teachers = searchTeachersByYearOfDOB("1975-03-12");
//        for (Teacher t : teachers) {
//            System.out.println(t);
//        }
    }
}
