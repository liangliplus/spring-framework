package indi.kenneth.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author liangll
 * @Date 2023/3/2
 */
public class CustomBeforeAdvice implements MethodBeforeAdvice {
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("before 通知"+target.getClass().getSimpleName());

	}
}
