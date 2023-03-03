package indi.kenneth.aop;

import indi.kenneth.aspect.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * advisor 就是把advice 和 pointCut 整合起来。
 * @Author liangll
 * @Date 2023/3/2
 */
public class AopTest {


	/**
	 * 这种方案 我们如果需要为多个目标类应用拦截， 我们就需要配置多次
	 */
	@Test
	public void proxyFactoryBean() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/ProxyFactoryBeanDemo.xml");
		UserService bean = ctx.getBean("customProxy",UserService.class);
		bean.addUser("hello");
		String s = bean.queryUserName(1);


		UserService customProxy2 = ctx.getBean("customProxy2", UserService.class);
		customProxy2.addUser("hello2");

	}


	/**
	 * 可以看到我们调用addUser 方法也被拦截勒
	 *DefaultAdvisorAutoProxyCreator  将容器的advisor 织入到目标类。
	 * 运行addUser 方法，发现增强被织入到匹配的连接点
	 */
	@Test
	public void defaultAdvisorAutoProxyCreator() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/DefaultAdvisorAutoProxyCreatorDemo.xml");
		UserService userService = ctx.getBean("userService", UserService.class);
		UserService userService2 = ctx.getBean("userService2", UserService.class);

		userService.addUser("zhangsan");


		userService2.addUser("lishi");

		//打印发现我们的类变为代理对象勒 indi.kenneth.aspect.service.UserService$$EnhancerBySpringCGLIB$$aeb431be
		System.out.println(userService.getClass());

	}

	@Test
	public void testXmlAspect() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/xmlAspectDemo.xml");
		UserService bean = ctx.getBean(UserService.class);
		bean.addUser("zhangsan");

	}


}
