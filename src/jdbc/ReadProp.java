package jdbc;

import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

public class ReadProp {

	public static void main(String[] args)  throws  UnsupportedEncodingException{
      //实现读取文件内容
      ResourceBundle rb = ResourceBundle.getBundle("jdbc.aaa");
      String val = rb.getString("tt");
      System.out.println(val);
      val = new String(val.getBytes("ISO-8859-1"),"UTF-8");
      System.out.println(val);
		 //proper配置文件不需要编译
      
	}

}
