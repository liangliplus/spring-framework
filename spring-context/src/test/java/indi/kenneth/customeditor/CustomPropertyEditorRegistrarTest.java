package indi.kenneth.customeditor;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring 中默认的ProperEditor 都定义在org.springframework.beans.propertyeditors包下
 * 在spring 中，还提供一个ConverterService 也可以实现类型转换，将外部化的 bean 属性值字符串转换为所需的属性类型
 * 在core.convert.support 包下有一些默认实现
 * @author kenneth
 * @Date: 2023/2/28
 */
public class CustomPropertyEditorRegistrarTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/customEditorConfigurer-demo.xml");
		DependsOnExoticType bean = ctx.getBean(DependsOnExoticType.class);
		System.out.println(bean);
	}

}
