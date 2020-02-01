package com.example.doggamore.database;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class DBManager {

    public static Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
    }

    public static String selectQuery(Connection c, String s) throws SQLException {
        Statement statm = c.createStatement();
        ResultSet rs = statm.executeQuery(s);
        String out = "";
        while (rs.next()){
            out = rs.getString("animal_name");
        }
        return out;
    }
    public static void updateQuery(Connection c, String s) throws SQLException {
        Statement statm = c.createStatement();
        statm.executeUpdate(s);

    }
}
