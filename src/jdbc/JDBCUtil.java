package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtil {

	private static ResourceBundle rb = ResourceBundle.getBundle("jdbc.jdbc");

	private static String className = rb.getString("driver");
	private static String url = rb.getString("url");
	private static String user = rb.getString("user");
	private static String password = rb.getString("password");

	// 加载驱动
	static {
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 得到连接的url
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,user,password);
	}

	/**
	 * 关闭连接
	 * 
	 * @param connection
	 * @param statement
	 */
	public static void close(Connection connection, Statement statement, ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
				resultSet = null;
			}
			if (statement != null) {
				statement.close();
				statement = null;
			}
			if (connection != null) {
				connection.close();
				connection = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection connection, Statement statement) {
		close(connection, statement, null);
	}

	public static void main(String[] args) throws SQLException {
		Connection con = JDBCUtil.getConnection();
		System.out.println(con);
		JDBCUtil.close(con, null);
	}

	private JDBCUtil() {

	}

}




//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ResourceBundle;
//
//public class JDBCUtil {
//	private static ResourceBundle rb = ResourceBundle.getBundle("jdbc.jdbc") ;
//	
//	private static String className = rb.getString ("driver");
//	private static String  url              = rb.getString ("url");
//	private static String  user            = rb.getString ("user");
//	private static String password    = rb.getString ("password");
//	
//	static {
//		try  {
//			//加载驱动：Class.forName("");
//			Class.forName(className);
//		}catch (ClassNotFoundException e)  {
//			e.printStackTrace();
//			
//		}
//	}
//		
//		public static Connection getconnection() throws SQLException {
//			//2.获得连接对象Connection
//			return DriverManager.getConnection(url,user,password);
//		}
//		public static void close(Connection connection, Statement statement,ResultSet resultSet) {
//			
//			close(connection,statement,resultSet);
////	}catch (SQLException e) {
////		
////		e.printStackTrace();
////	}
////	return null;
////}
//		//6.关闭链接
//try {
//	  if (resultSet != null) {
//		  resultSet.close();
//		  resultSet = null;
//	  }
//	  if (statement != null) {
//		  statement.close();
//		  statement = null;
//		  
//	  }
//	  if(connection != null) {
//		  connection.close();
//		  connection = null;
//		  
//		  
//	  }
//	  
//}  catch  (SQLException e) {
//	e.printStackTrace();
//    }
//}
//
//
//public static void main(String[] args) throws SQLException {
//	
//	Connection con = JDBCUtil.getconnection();
//	System.out.println(con);
//	JDBCUtil.close(con,null, null);
//	
//}
//
//	
//	private JDBCUtil() {
//		
//	}
//	
//	}