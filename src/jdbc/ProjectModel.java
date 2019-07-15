package jdbc;

import java.sql.Timestamp;

public class ProjectModel {


		private Integer    id;
		private String    code;
		private String   pj_name;
		private  Timestamp pj_Time;
		private String    pj_describe;
		public Integer getId() {
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
		public String getPj_name() {
			return pj_name;
		}
		public void setPj_name(String pj_name) {
			this.pj_name = pj_name;
		}
		public Timestamp getPj_Time() {
			return pj_Time;
		}
		public void setPj_Time(Timestamp pj_Time) {
			this.pj_Time = pj_Time;
		}
		public String getPj_describe() {
			return pj_describe;
		}
		public void setPj_describe(String pj_describe) {
			this.pj_describe = pj_describe;
		}
		
	
	}