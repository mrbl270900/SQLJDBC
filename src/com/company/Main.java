package com.company;
import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:C:/Users/madsr/IdeaProjects/TrandbOpgaver//TrainDb.sqlite";
        Trainmodel tbd = new Trainmodel(url);
        ArrayList<String> data = new ArrayList<>();
        try {
            tbd.connectToTrainData();
            tbd.CreateStatment();
            data = tbd.SQLQueryStations();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
                try{
                    tbd.closeTrainDataCon();
                }catch (SQLException e2){
                    System.out.println(e2.getMessage());
                }
        }
    }
}
