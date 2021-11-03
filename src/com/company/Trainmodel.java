package com.company;

import java.sql.*;
import java.util.ArrayList;

public class Trainmodel {

    Connection conn = null;
    String url = null;
    Statement stmt = null;
    String sql = null;
    ResultSet rs=null;

   Trainmodel(String url){
       this.url=url;
   }

   public void connectToTrainData() throws SQLException{
       conn = DriverManager.getConnection(url);
   }

   public void closeTrainDataCon() throws SQLException{
       conn.close();
   }

   public void CreateStatment() throws SQLException{
       this.stmt = conn.createStatement();
   }

   public ArrayList<String> SQLQueryStations() throws SQLException{
       String sql = "SELECT name FROM Station;";
       ArrayList<String> stations = new ArrayList<>();
       rs = stmt.executeQuery(sql);
       while (rs!=null && rs.next()){
           String name = rs.getString( "name");
           stations.add(name);
           System.out.println(name);
       }
       return stations;
   }
}
