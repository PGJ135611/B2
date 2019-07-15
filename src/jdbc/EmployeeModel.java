package jdbc;

import java.sql.Timestamp;

public class EmployeeModel {
	
	private Integer    id;
	private String    code;//员工编号
	private String   name;//员工姓名
	private String   gender;//性别
	private String    birthday;//生日
	private Timestamp    entryTime;//入职日期	
	private String    tel;
	private Timestamp EntryTimeBegin;
	private Timestamp   EntryTimeEnd;
	
	
	
	public Timestamp getEntryTimeEnd() {
		return EntryTimeEnd;
	}
	public void setEntryTimeEnd(Timestamp entryTimeEnd) {
		EntryTimeEnd = entryTimeEnd;
	}
	public Timestamp getEntryTimeBegin() {
		return EntryTimeBegin;
	}
	public void setEntryTimeBegin(Timestamp entryTimeBegin) {
		EntryTimeBegin = entryTimeBegin;
	}
	public Integer getId() {
		return id;
	}
	public Integer getId(int i) {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Timestamp getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Timestamp entryTime) {
		this.entryTime = entryTime;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "EmployeeModel [id=" + id + ", code=" + code + ", name=" + name + ", gender=" + gender + ", birthday="
				+ birthday + ", entryTime=" + entryTime + ", tel=" + tel + ", EntryTimeBegin=" + EntryTimeBegin
				+ ", EntryTimeEnd=" + EntryTimeEnd + "]";
	
	

		
		
		  
		
		
	
	}
}
	