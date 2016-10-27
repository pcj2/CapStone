
import java.sql.*;

public class Populator Extends Thread{

    public ArrayList<Entry> arrayList = new <Entry>ArrayList();

    //SQL COMMANDS
    private static final String fullDataBaseCMD = new String("SELECT * FROM soap");
    private static final String  = new String("SELECT * FROM soap WHERE stepName = 'unit test'");
    private static final String  = new String("SELECT * FROM soap WHERE stepName = 'unit test'");
    private static final String  = new String("SELECT * FROM soap WHERE stepName = 'unit test'");

    private static final int MINUTE = 1000;

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql:http://54.218.54.94/phpmyadmin/";

    //  Database credentials
    static final String USER = "datamaster";
    static final String PASS = "capstone#4";

    Connection conn = null;
    Statement stmt = null;

    public Populator(){}

    public void run(){
        while(true){
            try{
                Class.forName("com.mysql.jdbc.Driver"); //specific driver needed
                conn = DriverManager.getConnection(DB_URL,USER,PASS); //actual db connection

                ResultSet rs = stmt.executeQuery(/*Insert your sql cmd string here*/); //request to sql db

                while(rs.next()){
                    //Place received results into Entry
                    Entry tempEntry = new Entry();
                    tempEntry.setVersionName = rs.getString("versionName");
                    tempEntry.setComponentName = rs.getString("componentName");
                    tempEntry.setStepName = rs.getString("stepName");
                    tempEntry.setStepResult = rs.getString("stepResult");

                    if(!arrayList.contains(tempEntry))
                        arrayList.add(tempEntry);
                }
                //Close down database connection
                rs.close();
                stmt.close();
                conn.close();


        Thread.sleep(1*MINUTE);
        }
    }

public class Entry{
    private String versionName;
    private String componentName;
    private String stepName;
    private String stepResult;
    
    public Entry(){}
    Public Entry(String versionName, String componentName, String stepName, String stepResult){
        this.versionName = versionName;
        this.componentName = componentName;
        this.stepName = stepName;
        this.stepResult = stepResult;
    }
    
    public getVersionName(){return versionName;}
    public getComponentName(){return componentName;}
    public getStepname(){return stepName;}
    public getStepResult(){return stepResult;}
    public setVersionName(String versionName){this.versionName = versionName;}
    public setComponentName(String componentName){this.componentName = componentName;}
    public setStepName(String stepName){this.stepName = stepName;}
    public setStepResult(String stepResult){this.stepResult = stepResult;}
    
    }

}
