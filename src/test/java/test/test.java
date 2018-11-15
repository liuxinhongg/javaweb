package test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bdxh.kmsale.bean.User;
import com.bdxh.kmsale.mapper.UserMapper;

public class test {
	public static void main(String[] args) {
		/*AbstractApplicationContext ac=
				new ClassPathXmlApplicationContext("application-dao.xml");
		UserMapper tm=
				ac.getBean("userMapper",UserMapper.class);
		User user=tm.selectUserById("admin22");
		System.out.println(user);
*/	
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datenow = sdf.format(date);
		System.out.println(datenow);
	}
}
