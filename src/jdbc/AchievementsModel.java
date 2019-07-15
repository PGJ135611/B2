package jdbc;

public class AchievementsModel {

	private Integer    id;
	private String   employee_code;
	private String  project_code ;
	private String  achievements_mark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmployee_code() {
		return employee_code;
	}
	public void setEmployee_code(String employee_code) {
		this.employee_code = employee_code;
	}
	public String getProject_code() {
		return project_code;
	}
	public void setProject_code(String project_code) {
		this.project_code = project_code;
	}
	public String getAchievements_mark() {
		return achievements_mark;
	}
	public void setAchievements_mark(String achievements_mark) {
		this.achievements_mark = achievements_mark;
	}
	

}
