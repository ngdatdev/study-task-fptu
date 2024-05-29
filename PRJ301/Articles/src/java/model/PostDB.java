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

/**
 *
 * @author admin
 */
public class PostDB {

    private static final String DB_URL = "jdbc:sqlserver://LAPTOP-7M53ESA2;databaseName=PRJ301_1;encrypt=false;trustServerCertificate=false;loginTimeout=30";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "zxcl123123";

    public static List<Post> listArticleByTitle() throws ClassNotFoundException {
        String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        Class.forName(driverClass);

        List<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM Articles";
        try ( Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);  PreparedStatement ps = conn.prepareStatement(sql)) {
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String articleId = rs.getString("ArticleId");
                    String title = rs.getString("Title");
                    String type = rs.getString("Type");
                    posts.add(new Post(articleId, title, type));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

}
