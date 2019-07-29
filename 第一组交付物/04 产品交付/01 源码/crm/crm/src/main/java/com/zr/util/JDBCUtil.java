package com.zr.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
    public static String DRIVERNAME = "com.mysql.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/dbbase";
    public static String USER = "root";
    public static String PASSWORD = "123456";
 
    public static Connection conn = null;
 
 
    public static Connection getConnection() throws Exception {
        if (conn != null) {
            return conn;
        }
         
        Class.forName(DRIVERNAME);
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
 
        return conn;
    }
 
    public static void closeResource(Connection conn, PreparedStatement st) throws SQLException {
        st.close();
        conn.close();
    }
 
    public static void closeResource(Connection conn, ResultSet rs, PreparedStatement st) throws SQLException {
        st.close();
        rs.close();
        conn.close();
    }
	
}
