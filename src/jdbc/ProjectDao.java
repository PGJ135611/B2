package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ProjectDao {


		private Connection                con;
		private PreparedStatement  ps;
		
		public static void main(String[] args) {
			ProjectModel model = new ProjectModel() ;
			model.setCode(" 3");
			model.setPj_name("李海洋");
			model.setPj_describe("gay");
			Timestamp pj_Time = new Timestamp(System.currentTimeMillis());
			model.setPj_Time(pj_Time);
//			new ProjectDao().delete(model);
//			new ProjectDao().update(model);
			new ProjectDao().insert(model);
		}
//			new ProjectDao().insert(model);

		public String insert(ProjectModel model) {
			String sql = "insert into project(code,pj_name,pj_Time,pj_describe)values(?,?,?,?) ";
			try {
				con = JDBCUtil.getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(1, model.getCode());
				ps.setString(2, model.getPj_name());
				ps.setTimestamp(3, model.getPj_Time());
				ps.setString(4, model.getPj_describe());
				return ps.executeLargeUpdate() + " ";
			} catch (SQLException e) {
				e.printStackTrace();
			}  finally {
				
				JDBCUtil.close(con,ps);
				
			}
			return null;
		}

			

		public String delete(ProjectModel model)  {
		String sql = "delete from project where code=?";
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, model.getPj_name());
			return ps.executeLargeUpdate() + "";
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con,ps, null);
		}
		return null;
		}


		public String update(ProjectModel model) {
			String sql = "update project set pj_name =?,pj_Time=?,pj_describe=?  where id = 2";
			try {
		         con = JDBCUtil.getConnection();
		         ps  =  con.prepareStatement(sql);
		         ps.setString(1, model.getPj_name());
		         ps.setTimestamp(2, model.getPj_Time());
		         ps.setString(3, model.getPj_describe());
		         return ps.executeLargeUpdate() + "";
		        
			}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(con,ps, null);
			}
			return null;

	}

}



