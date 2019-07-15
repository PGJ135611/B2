package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class AchievementsDao {

	private Connection                con;
	private PreparedStatement  ps;
	
	public static void main(String[] args) {
		AchievementsModel model = new AchievementsModel() ;
		model.setEmployee_code(" 2");
		model.setProject_code("6");
//		model.setId(3);
		model.setAchievements_mark("666");
//		new AchievementsDao().insert(model);
		model.setId(5);
		new AchievementsDao().delete(model);
//		model.setId(5);
//		new AchievementsDao().update(model);
}
	public String insert(AchievementsModel model) {
		String sql = "insert into achievements(employee_code,project_code,achievements_mark)values(?,?,?) ";
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, model.getEmployee_code());
			ps.setString(2, model.getProject_code());
			ps.setString(3, model.getAchievements_mark());
			return ps.executeLargeUpdate() + "";
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			
			JDBCUtil.close(con,ps, null);
			
		}
		return null;
	}
	
public String delete(AchievementsModel model) {
	String sql = "delete from achievements where id = ?";
	try {
		con = JDBCUtil.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, model.getId());
		return ps.executeLargeUpdate() + "";
	}catch (SQLException e) {
		e.printStackTrace();
		
	}finally {
		JDBCUtil.close(con,ps);
	}
	return null;
	}


	public String update (AchievementsModel model) {
		   String sql = "update achievements set employee_code=?,project_code=?,achievements_mark=?  where id=?";
		      try {
		    	  con = JDBCUtil.getConnection();
		    	  ps  = con.prepareStatement(sql);
		    	  ps.setString(1, model.getEmployee_code());
		    	  ps.setString(2, model.getProject_code());
		    	  ps.setString(3, model.getAchievements_mark());
		    	  ps.setInt(4, model.getId());
		    	  return ps.executeLargeUpdate() + "";
		    	  
		    	  
		      }catch (SQLException e) {
		    	  e.printStackTrace();
		    	  
		      }finally {
		    	  JDBCUtil.close(con, ps);
		      }
		      return null;
	}
}

