package model.dao;

//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class ConnectionFactory {
//	   
//       public static Connection getConnection(){
//    	   Connection conn=null;
//    	   try {
//    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//   			conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=MyDB","sa","***");
//		} catch (Exception e) {
//			System.out.println("连接失败");
//		}
//    	   return conn;
//       }
//}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
     public static Connection getConnection() throws SQLException{
    	 Connection conn=null;
    	 
    	 try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=MyDB","sa","***");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库没有成功连接");
		}
    	 return conn;
	     
     }
}