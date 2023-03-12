package indi.kenneth.mvc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author liangll
 * @Date 2023/3/8
 */
public class WebMvcTest {


	private Servlet servlet;

	@BeforeEach
	public void setup() throws ServletException {
		//初始化阶段
		// 1.首先我们需要ServletConfig ， 然后添加init-param( spring-web 提供了 MockServletConfig)
		// 2.我们需要对DispatcherServlet 做初始化，调用init（ServletConfig config） 方法
		MockServletConfig servletConfig = new MockServletConfig();
		servletConfig.addInitParameter("contextConfigLocation","META-INF/applicationContext.xml");
		servlet = new DispatcherServlet();
		servlet.init(servletConfig);

	}

	@Test
	public void testRequest() throws ServletException, IOException {
		//调用阶段
		//1. 我们需要request 和 response 请求对象，并且request请求对象需要指定请求路径
		//2. 然后把请求和响应对象传递给DispatcherServlet 的service 方法
		//3. 如何构建request 和 获取response响应结果  (spring-web 提供了 MockHttpServletRequest ，
		// 构造函数可以传递两个参数一个HttpMethod，一个请求路径
		//// 我们如何获取响应结果, 可以通过MockHttpServletResponse 的 getContentAsString 获取)
		MockHttpServletRequest request = new MockHttpServletRequest("GET","/hello/method-1");
		MockHttpServletResponse response = new MockHttpServletResponse();
		servlet.service(request,response);

		assertThat(response.getContentAsString()).isEqualTo("hello,world");

	}

	@Test
	public void testJson() throws ServletException, IOException {
		MockHttpServletRequest request = new MockHttpServletRequest("GET","/hello/json");
		MockHttpServletResponse response = new MockHttpServletResponse();
		servlet.service(request,response);

		System.out.println(response.getContentAsString());
	}


	@Test
	public void testPage() throws ServletException, IOException {
		//调用阶段
		//1. 我们需要request 和 response 请求对象，并且request请求对象需要指定请求路径
		//2. 然后把请求和响应对象传递给DispatcherServlet 的service 方法
		//3. 如何构建request 和 获取response响应结果  (spring-web 提供了 MockHttpServletRequest ，
		// 构造函数可以传递两个参数一个HttpMethod，一个请求路径
		//// 我们如何获取响应结果, 可以通过MockHttpServletResponse 的 getContentAsString 获取)
		MockHttpServletRequest request = new MockHttpServletRequest("GET","/hello/view");
		MockHttpServletResponse response = new MockHttpServletResponse();
		servlet.service(request,response);

		System.out.println(response.getContentAsString());




	}


}
