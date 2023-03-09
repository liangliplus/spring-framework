package indi.kenneth.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author liangll
 * @Date 2023/3/8
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping("/method-1")
	@ResponseBody
	public String method() {
		System.out.println("执行handle method...");
		return "hello,world";
	}
}
