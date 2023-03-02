package indi.kenneth.conversionservice;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;

import java.util.ArrayList;
import java.util.List;

/**
 * spring 中默认的ProperEditor 都定义在org.springframework.beans.propertyeditors包下
 * 在spring 中，还提供一个ConverterService 也可以实现类型转换，将外部化的 bean 属性值字符串转换为所需的属性类型
 * 在core.convert.support 包下有一些默认实现
 * @author kenneth
 * @Date: 2023/2/28
 */
public class ConversionServiceTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/conversionService-demo.xml");
		ConversionService cs = ctx.getBean(ConversionService.class);
		List<Integer> list = new ArrayList<>();
		list.add(1);list.add(2);

		List<String> output = (List<String>)cs.convert(list, TypeDescriptor.forObject(list), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(String.class)));
		for (String s : output) {
			System.out.println(s);
		}


	}

}
