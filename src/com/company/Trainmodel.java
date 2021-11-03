package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

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

   public ArrayList<String> SQLDeparturesFromStations() throws SQLException{
       ArrayList<String> departures = new ArrayList<>();
       System.out.println("Which station do you wish to find departures for?");
       Scanner scanner = new Scanner(System.in);
       String departureStation = scanner.nextLine();
       String SQL = "SELECT stationname, time FROM Departure WHERE stationname='"+ departureStation + "';";
       rs = stmt.executeQuery(SQL);
       while (rs!=null && rs.next()){
           System.out.println(rs.getString(1) + " time:" + rs.getFloat(2));
       }
       return departures;
   }

    public void pmstmtSQLDeparturesFromStations() throws SQLException{
        System.out.println("Which station do you wish to find departures for?");
        Scanner scanner = new Scanner(System.in);
        String departureStation = scanner.nextLine();
        String SQL = "SELECT stationname, time FROM Departure WHERE stationname='"+ departureStation + "';";
        rs = stmt.executeQuery(SQL);
        while (rs!=null && rs.next()){
            System.out.println(rs.getString(1) + " time:" + rs.getFloat(2));
        }
    }

}
