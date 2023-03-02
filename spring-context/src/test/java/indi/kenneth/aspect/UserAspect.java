package indi.kenneth.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author kenneth
 * @Date: 2023/3/1
 */
@Component
@Aspect
public class UserAspect {


	@Pointcut(value = "execution(* indi.kenneth.aspect.service.*..*(..))")
	public void pointCut() {}


	@Before("pointCut()")
	public void before(JoinPoint joinPoint) {
		System.out.println("before 通知"+joinPoint);
	}
}
