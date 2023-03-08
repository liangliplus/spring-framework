package indi.kenneth.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author liangll
 * @Date 2023/3/8
 */
@Controller
public class HelloController {

	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {

		return "hello,world";
	}
}
