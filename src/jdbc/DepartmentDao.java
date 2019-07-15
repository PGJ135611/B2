package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepartmentDao {
	private Connection     con;
	private PreparedStatement ps;
	

	public static void main(String[] args) {
		DepartmentModel model = new DepartmentModel ();
		//插入的model
		model.setCode(" ");
		model.setDp_name("开发部门");
		model.setDp_tel("0532-222335");
		model.setDp_number("100");
		new DepartmentDao().insert(model);
//		new DepartmentDao().delete(model);
		
	}
	
	public String insert(DepartmentModel  model) {
		String sql = "insert into department(code,dp_name,dp_tel,dp_number)values(?,?,?,?)";
	   try {
		   con = JDBCUtil.getConnection();
		   ps =  con.prepareStatement(sql);
		   ps.setString(1, model.getCode());
		   ps.setString(2, model.getDp_name());
		   ps.setString(3, model.getDp_tel());
		   ps.setString(4, model.getDp_number());
		   return ps.executeLargeUpdate() + "";
				   
	   } catch(SQLException e) {
		   e.printStackTrace();
		   
	   }finally {
		   
		   JDBCUtil.close(con, ps);
	   }
	   
	   return null;
	}
	
	public String delete(DepartmentModel model)  {
	String sql = "delete from department where code=?";
	try {
		con = JDBCUtil.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, model.getCode());
		return ps.executeLargeUpdate() + "";
	}catch (SQLException e) {
		e.printStackTrace();
	} finally {
		JDBCUtil.close(con,ps, null);
	}
	return null;
	}
	   
	   public String update(DepartmentModel model) {
			String sql = "update department set dp_name =?,dp_tel=?,dp_number=? where id =2";
			try {
		         con = JDBCUtil.getConnection();
		         ps  =  con.prepareStatement(sql);
		         ps.setString(1, model.getDp_name());
		         ps.setString(2, model.getDp_tel());
		         ps.setString(3, model.getDp_number());
		         return ps.executeLargeUpdate() + "";
		        
			}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(con,ps, null);
			}
			return null;

	}

}
