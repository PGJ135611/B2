package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Text02 {

	public static void main(String[] args) throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver);
		new Text02().testBatch();
	}

	public void testBatch() {
		String url = "jdbc:mysql://127.0.0.1:3306/new_schema?useSSL=false&useUnicode=true&characterEncoding=UTF8&allowMultiQueries=true&serverTimezone=Hongkong";
		 String user = "root";
		 String pwd = "135611";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pwd);

			conn.setAutoCommit(false);// 设置自动提交为false
			String sql = "Insert into person(name,roomid)values(?,?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			for (int i = 1; i <= 1000; i++) {
				ps.setString(1, "aa" + i);
				ps.setInt(2, i);
				ps.addBatch();// 批处理
			}
			int[] count = ps.executeBatch();
			for (int i = 0; i < count.length; i++) {    
				System.out.println(count[i]);
			}
			ps.clearBatch();
			conn.commit();
			ps.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("roll back");
			try {
				conn.rollback();// 数据回滚，撤销发生异常之前修改
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

}
