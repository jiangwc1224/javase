package java.com.jwc.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBean {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("NewBean");
		
	}
}
