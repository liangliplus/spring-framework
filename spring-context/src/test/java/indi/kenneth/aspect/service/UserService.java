package indi.kenneth.aspect.service;

import org.springframework.stereotype.Service;

/**
 * @author kenneth
 * @Date: 2023/3/1
 */
@Service
public class UserService {

	public void addUser(String userName) {
		System.out.println("UserService 保存用户");
	}

}
