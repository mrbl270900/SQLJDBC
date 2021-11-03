package com.company;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        String url = "jdbc:sqlite:C:/Users/madsr/IdeaProjects/TrandbOpgaver//TrainDb.sqlite";
        Statement stmt = null;
        String sql = "SELECT name,tracks FROM Station;";
        ResultSet rs=null;
        try {
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs!=null && rs.next()){
                String name = rs.getString("name");
                int tracks = rs.getInt("tracks");
                System.out.println(name);
                System.out.println(tracks);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            if(conn!=null){
                try{
                    conn.close();
                }catch (SQLException e2){
                    System.out.println(e2.getMessage());
                }
            }
        }
    }
}
