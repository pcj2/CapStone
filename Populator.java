package mysql.test.app;

import java.sql.*;
import java.util.ArrayList;

public class Populator extends Thread {

    public ArrayList<Entry> arrayList = new <Entry>ArrayList();

    //SQL COMMANDS
    private static final String fullDataBaseCMD = "SELECT * FROM soap";
    //private static final String  = new String("SELECT * FROM soap WHERE stepName = 'unit test'");
    //private static final String  = new String("SELECT * FROM soap WHERE stepName = 'unit test'");
    //private static final String  = new String("SELECT * FROM soap WHERE stepName = 'unit test'");

    private static final int MINUTE = 1000;

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://54.187.108.96:3306/capstone";

    //  Database credentials
    static final String USER = "datamaster";
    static final String PASS = "capstone#4";

    Connection conn = null;
    Statement stmt = null;

    public Populator(){}

    public void run(){
        while(true){ //why is this here?
            try{
                Class.forName("com.mysql.jdbc.Driver"); //specific driver needed
                stmt = conn.createStatement();
                conn = DriverManager.getConnection(DB_URL,USER,PASS); //actual db connection

                ResultSet rs = stmt.executeQuery(fullDataBaseCMD); //request to sql db

                while(rs.next()){
                    //Place received results into Entry
                    Entry tempEntry = new Entry();
                    tempEntry.setVersionName(rs.getString(2));
                    tempEntry.setComponentName(rs.getString(1));
                    tempEntry.setStepName(rs.getString(3));
                    tempEntry.setStepResult(rs.getString(4));

                    if(!arrayList.contains(tempEntry))
                        arrayList.add(tempEntry);
                }
                //Close down database connection
                rs.close();
                stmt.close();
                conn.close();


                Thread.sleep(1*MINUTE);
        }catch (SQLException se){
                se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
                try{
                    if(stmt!=null)
                        stmt.close();
                }catch(SQLException se2){
                }// nothing we can do
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }
        }
    }
}
    
    public class Entry {
        private String versionName;
        private String componentName;
        private String stepName;
        private String stepResult;

        public Entry(){}
        public Entry(String versionName, String componentName, String stepName, String stepResult){
            this.versionName = versionName;
            this.componentName = componentName;
            this.stepName = stepName;
            this.stepResult = stepResult;
        }

        public String getVersionName(){return versionName;}
        public String getComponentName(){return componentName;}
        public String getStepname(){return stepName;}
        public String getStepResult(){return stepResult;}
        public void setVersionName(String versionName){this.versionName = versionName;}
        public void setComponentName(String componentName){this.componentName = componentName;}
        public void setStepName(String stepName){this.stepName = stepName;}
        public void setStepResult(String stepResult){this.stepResult = stepResult;}

    }
}
