package indi.kenneth.propetysource;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author liangll
 * @Date 2023/4/14
 */
public class PropertySourcesPlaceholderConfigurerTest {



	@Test
	public void testPropertySource() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.scan("indi.kenneth.propetysource");

		context.refresh();

		PropertiesDemo bean = context.getBean(PropertiesDemo.class);
		System.out.println(bean.username);
	}

}
