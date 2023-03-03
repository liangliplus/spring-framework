package indi.kenneth.aspect;

import indi.kenneth.aspect.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author liangll
 * @Date 2023/3/2
 */
public class AnnotationAspectTest {

	@Test
	void aspect() {
		//注意被aop拦截的类没有实现接口，就需要指定下@EnableAspectJAutoProxy(proxyTargetClass = true)
		//强制指定使用cglib拦截
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserAspect bean1 = context.getBean(UserAspect.class);
		System.out.println(bean1);

		UserService bean = context.getBean(UserService.class);
		bean.addUser("zhangsan");



	}
}
