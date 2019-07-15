package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	
	private Connection                con;
	private PreparedStatement  ps;
	
	public static void main(String[] args) {
		EmployeeModel model = new EmployeeModel() ;
		//插入的model
		model.setCode("A124 ");
		model.setName("素数");
		model.setGender("女");
		model.setBirthday("1999-2-1");
		model.setTel("136376321");
		Timestamp entryTime = new Timestamp(System.currentTimeMillis());
		model.setEntryTime(entryTime);
		 new EmployeeDao().insert(model);
// new EmployeeDao().appendWhere(null, model);
// new EmployeeDao().insertList(null);
// new EmployeeDao().select(model);
		
	//删除的model
		model.setId(6);
		new EmployeeDao().delete(model);	
	//修改的model
		model.setCode("A111 ");
		model.setName("盛世");
		model.setGender("女");
		model.setBirthday("1999-3-1");
		model.setTel("136376321");
//		new EmployeeDao().update(model);
//		new EmployeeDao().testSel();

		}

	//插入
	public String insert(EmployeeModel model) {
		String sql = "insert into employee(code,name,gender,birthday,enterTime,tel)values(?,?,?,?,?,?)";
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, model.getCode());
			ps.setString(2, model.getName());
			ps.setString(3, model.getGender());
			ps.setString(4, model.getBirthday());
			ps.setTimestamp(5, model.getEntryTime());
			ps.setString(6, model.getTel());
			return ps.executeLargeUpdate() + "";
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			
			JDBCUtil.close(con,ps, null);
			
		}
		return null;
	}
	
//删除
	public String delete(EmployeeModel model)  {
		String sql = "delete from employee where ID=?";
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
	

//修改
public String update(EmployeeModel model) {
	String sql = "update employee set code =?, name =?,gender=?,birthday=? where id=3";
	try {
         con = JDBCUtil.getConnection();
         ps  =  con.prepareStatement(sql);
         ps.setString(1, model.getCode());;
         ps.setString(2, model.getName());
         ps.setString(3, model.getGender());
         ps.setString(4, model.getBirthday());
         return ps.executeLargeUpdate() + "";
        
	}catch (SQLException e) {
		e.printStackTrace();
	} finally {
		JDBCUtil.close(con,ps, null);
	}
	return null;
}


//查询


public List<EmployeeModel> selectList(EmployeeModel model) {
	StringBuffer sql = new StringBuffer("select ");
	sql.append(" id,code,name,gender,birthday,enterTime,tel ");
	sql.append(" from employee where 1=1");
	List<Object> list = appendWhere(sql, model);
	List<EmployeeModel> result = new ArrayList<>();
	ResultSet rs = null;
	try {
		con = JDBCUtil.getConnection();
		ps = con.prepareStatement(sql.toString());

		for (int i = 0; i < list.size(); i++) {
			ps.setObject(i + 1, list.get(i));
		}
		rs = ps.executeQuery();
		while (rs.next()) {
			EmployeeModel m = new EmployeeModel();
			m.setId(rs.getInt("id"));
			m.setCode(rs.getString("code"));
			m.setName(rs.getString("name"));
			m.setGender(rs.getString("gender"));
			m.setBirthday(rs.getString("birthday"));
			m.setEntryTime(rs.getTimestamp("enterTime"));
			m.setTel(rs.getString("tel"));
			result.add(m);

		}
	} catch (SQLException e) {
		e.printStackTrace();
		try {
			con.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	return result;

}

private List<Object> appendWhere(StringBuffer sql, EmployeeModel model) {
	List<Object> list = new ArrayList<>();
	Integer id = model.getId();
	if (id != null) {
		sql.append("  and id=?");
		list.add(id);
	}
	String code = model.getCode();
	if (code != null && !code.trim().isEmpty()) {
		sql.append("  and code like ?");
		list.add(code);
	}
	String name = model.getName();
	if (name != null && !name.trim().isEmpty()) {
		sql.append("  and name like ?");
		list.add(name);
	}
	String gender = model.getGender();
	if (gender != null && !gender.trim().isEmpty()) {
		sql.append("  and gender like ?");
		list.add(gender);
	}
	String birthday = model.getBirthday();
	if (birthday != null && !birthday.trim().isEmpty()) {
		sql.append(" and birthday = ?");
		list.add(birthday);
	}
//	Timestamp enterTime = model.getEntryTime();

	// Timestamp begin=model.getEntryTimeBegin();
	// Timestamp end=model.getEntryTimeEnd();
	// if(begin==null){
	//// begin
	// }
	// if(end==null){
	//// end
	// }
	// if(){
	//
	// }
	Timestamp begin = model.getEntryTimeBegin();
	Timestamp end = model.getEntryTimeEnd();
	if (begin != null&& end !=null) {
		   sql.append(" and enterTime between ? and ? ");
		   list.add(begin);
		   list.add(end); 
	}
	String tel = model.getTel();
//	if (enterTime != null) {
//		sql.append("  and enterTime=?");
//		list.add(enterTime);
//	}
	if (tel != null && !tel.trim().isEmpty()) {
		sql.append("  and tel=?");
		list.add(tel);
	}

	return list;

}

public String insertList(List<EmployeeModel> list) {
	String sql = "insert into employee(code,name,gender,birthday,enterTime,tel )";
	try {
		con = JDBCUtil.getConnection();
		ps = con.prepareStatement(sql);
		for(int i= 0; i< list.size(); i++) {
			EmployeeModel model = list.get(i);
			ps.setString(1, model.getCode());
			ps.setString(2, model.getName());
			ps.setString(3, model.getGender());
			ps.setString(4,model.getBirthday());
			ps.setTimestamp(5, model.getEntryTime());
			ps.setString(6, model.getTel());
			ps.addBatch();
		}
		int[] i = ps.executeBatch();
		ps.clearBatch();
		con.commit();
		return i + "";
		
	}catch (SQLException e) {
		e.printStackTrace();
		} finally {
			JDBCUtil.close(con,ps);
		}
		return null;
	}
		
	
	
	
	

public void testSel() {
	EmployeeDao ed = new EmployeeDao();
	EmployeeModel model = new EmployeeModel();
	model.setGender("女");
//	List<EmployeeModel> list = new ArrayList<>();
//	list = ed.select(model);
//	for (EmployeeModel m : list) {
//		System.out.println(m);
//	}
//
//}
	List<EmployeeModel> list = ed.selectList(model);
	System.out.println(list);
	
}


}



	
	
	
	
	
	
	
	
