package jdbc;

import java.sql.Timestamp;

public class DepartmentModel {

		private Integer    id;
		private String    code;
		private String   dp_name;
		private String  dp_tel;
		private String    dp_number;
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
		public String getDp_name() {
			return dp_name;
		}
		public void setDp_name(String dp_name) {
			this.dp_name = dp_name;
		}
		public String getDp_tel() {
			return dp_tel;
		}
		public void setDp_tel(String dp_tel) {
			this.dp_tel = dp_tel;
		}
		public String getDp_number() {
			return dp_number;
		}
		public void setDp_number(String dp_number) {
			this.dp_number = dp_number;
		}
	}

