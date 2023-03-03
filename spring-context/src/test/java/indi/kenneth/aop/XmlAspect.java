package indi.kenneth.aop;


import org.aopalliance.intercept.Joinpoint;

/**
 * @Author liangll
 * @Date 2023/3/2
 */
public class XmlAspect {


	public void before() {
		System.out.println("before 通知");
	}


	public void after() {
		System.out.println("after 通知");
	}
}
