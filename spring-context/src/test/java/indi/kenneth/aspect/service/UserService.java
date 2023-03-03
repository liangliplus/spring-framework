package indi.kenneth.aspect.service;

import org.springframework.stereotype.Service;

/**
 * @author kenneth
 * @Date: 2023/3/1
 */
@Service
public class UserService {

	public void addUser(String userName) {
		System.out.println("UserService 保存用户" + userName);
	}


	public String queryUserName(Integer id) {
		System.out.println("查询用户");
		return "zhangsan";
	}

}
