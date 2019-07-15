package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Text01 {
	
	private static final String driver = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) throws Exception {
		new Text01().test();
		
	}
	String url= "jdbc:mysql://127.0.0.1:3306/new_schema?useSSL= false&useUnicode=true&characterEncoding=UTF8&serverTimezone=Hongkong";
    String user = "root";
    String pwd = "135611";
	private void test() throws Exception {
		//加载驱动：Class.forName("com.mysql.jdbc.Driver");
		Class.forName(driver);
		//获取链接对象Connection
		Connection conn = DriverManager.getConnection(url, user,pwd);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select id ,name,age from person ");
		while(rs.next()) {
			//int id = rs.getInt("id");
			//String id = rs.getString("id");
			//String name = rs.getString("name");
			//Object name = rs.getObject("name");
			//int age = rs.getInt("age");
			int id = rs.getInt(1);//从1开始
			String name  =  rs.getString(2);
			//rs.getObject("name");
			int age = rs.getInt(3);
			System.out.println(id);
			System.out.println(name);
			System.out.println(age);
			
		}
		rs.close();
		st.close();
		conn.close();
	}
	

	
	
	
//private void p0() throws Exception {
//	//加载驱动：Class.forName("com.mysql.jdbc.Driver");
//			Class.forName(driver);
//			//获取链接对象Connection
//			Connection conn = DriverManager.getConnection(url, user,pwd);
//			// sql
//			int id = 2;
//			String name = "zhaoliu";
//			String sql = "select id ,name,age from new_schema.person where id=? and name=?";
//			// Statement
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			ps.setString(2, name);
//			//select id,name,age from person where id = 10 and name = "aaa"
//			
//			//ResultSet结果集
//			ResultSet rs = ps.executeQuery();
//			//结果集遍历
//			while (rs.next()) {
//				int id = rs.getInt("id");// rs.get.Int(1);
//				String name = rs.getString("n");//rs.getString(2);
//				int age = rs.getInt("age");
//				System.out.println(id + "  " +name + "  "+ age);
//				//list.add(new Person(id,name,age));
//
//				
//				
//			}
//			
//	}
//
//private void t1() throws Exception {
//	//加载驱动：Class.forName("com.mysql.jdbc.Driver");
//	Class.forName(driver);
//	//获取链接对象Connection
//	Connection conn = DriverManager.getConnection(url, user,pwd);
//	Statement st = conn.createStatement();
//	ResultSet rs = st.executeQuery("select id ,name,age from person ");
//while (rs.next()) {
//	int id= rs.getInt("id");
//	String name = rs.getString("name");
//	int age = rs.getInt("age");
//	//int id = rs.getInt(1);//从1开始
//	//String name = rs.getString(2);
//	//int age = rs.getInt(3);
//	System.out.println(id + "\t" + name + "\t" + age);
//	PersonBean p = new PersonBean();
//	list.add(p);
//	
//}
//rs.close();
//st.close();
//conn.close();
//
//}
//
//private void t2() throws Exception {
//	Class.forName(driver);
//	Connection conn = DriverManager.getConnection(url, user,pwd);
//	Statement st = conn.createStatement();
//	String sql  = "insert into person(name,age)values('aa',22)";
//	//String sql = "update person set name = 'yy' where id=2;
//	//String sql = "delete from person where id = 2";
//	int i =st.executeUpdate(sql);
//	System.out.println(i);
//	st.close();
//	conn.close();
//}
//
//
//private void p1() throws Exception {
//	//加载驱动：Class.forName("com.mysql.jdbc.Driver");
//	Class.forName(driver);
//	//获取链接对象Connection
//	Connection conn = DriverManager.getConnection(url, user,pwd);
//int id1 = 10;
//String name1= "aaa";
//String sql1 = "select id,name,age from person where new_schema.person ";
////Statement
//PreparedStatement ps = conn.prepareStatement(sql);
//ps.setInt(1, id1);
//ps.setString(2, name1);
////select id,name,age from person where id =10;
//
//ResultSet rs = ps.executeQuery();
////结果集遍历
//while (rs.next()) {
//	int id =rs.getInt("id");
//	String name = rs.getString("name");
//	int age = rs.getInt("age");
//	System.out.println(id + "   " + name +"     " +age);
//	//list.add(new Person(id,name,age));
//	
//	
//}
//
//	
//	
//}
//private void p2() throws Exception {
//	//加载驱动：Class.forName("com.mysql.jdbc.Driver");
//	Class.forName(driver);
//	//获取链接对象Connection
//	Connection conn = DriverManager.getConnection(url, user,pwd);
//	// int id = 9;
//	//String name = "wangwu";
//	//String sql1 = "insert into table(id,name)values(?,' " +name + " ')";
//	//String sql2 = "delect from tables where id = ? and name =?";
//	String sql3 = "update person set gender=?,age=? where id>? and name like? ";
//	PreparedStatement ps = conn.prepareStatement(sql3);
//	ps.setString(1, "男");
//	ps.setInt(2, 100);
//	ps.setInt(3, 100);
//	ps.setString(4, "zhang%");
//	int i = ps.executeUpdate();
//	ps.close();
//	conn.close();
//	
//	
//}
////PreparedStatement vs Statement
////1) 语法不同：PreparedStatement可以使用预编译的sql,
////只需要发送一次sql语句，后面只要使用参数即可
////公用一个sql语句，而Statement只能使用静态的sql
////2)效率不同：PreparedStatement可以使用sql缓冲区
////效率比Statement高
//// 3)安全性不同：PreparedStatement可以有效防止sql注入，
////而Statement不能防止sql注入。
//
//
//  
//private void p0(String id) {
//	String sql = "select * from table where id=" + id;
//}
//
}