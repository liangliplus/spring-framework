package indi.kenneth.mvc.controller;

import indi.kenneth.entity.Result;
import indi.kenneth.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author liangll
 * @Date 2023/3/8
 */
@Controller
public class HelloController {

	@RequestMapping("/hello/method-1")
	@ResponseBody
	public String method() {
		System.out.println("执行handle method...");
		return "hello,world";
	}



	@RequestMapping("/hello/json")
	@ResponseBody
	public Result<User> helloJson() {
		System.out.println("执行handle helloJson method...");
		User user = new User();
		user.setId(1);
		user.setName("zhangsan");
		return Result.success(user);
	}


	/**
	 * 在spring中有一组实现 HandlerMethodReturnValueHandler 接口的集合类。
	 * 当我们返回是string 情况下，会使用 ViewNameMethodReturnValueHandler
	 * 当我们返回是ModelAndView ， 会使用 ViewAndViewReturnValueHandler
	 * 当我们在类上或者方法上 标记ResponseBody 会使用 RequestResponseBodyMethodProcessor
	 *
	 * 重点关注它们的 handleReturnValue 方法如何实现
	 * @return
	 */
	@RequestMapping("/hello/view")
	public String methodView() {
		System.out.println("执行handle methodView...");
		return "index";
	}




}
