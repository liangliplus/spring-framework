package indi.kenneth.introspector;

import indi.kenneth.entity.User;
import org.junit.jupiter.api.Test;

import java.beans.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author liangll
 * @Date 2023/2/28
 */
public class IntrospectorDemo {

	@Test
	public void introspectorOverview() {
		try {
			BeanInfo beanInfo  = Introspector.getBeanInfo(User.class);

			BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();

			for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
				System.out.printf("propertyDescriptor name:%s readMethod:%s writeMethod:%s %n",propertyDescriptor.getName()
						,propertyDescriptor.getReadMethod().getName(),propertyDescriptor.getWriteMethod().getName());
			}


			for (MethodDescriptor methodDescriptor : methodDescriptors) {
				System.out.println("methodDescriptor name:"+methodDescriptor.getMethod().getName());
			}

			//手动创建一个属性描述符
			PropertyDescriptor pd = new PropertyDescriptor("name",User.class);
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void propertyEditor() {
		try {



			User user = new User();
			PropertyDescriptor pd = new PropertyDescriptor("age",User.class);
			//设置转换该属性的属性转换器
			pd.setPropertyEditorClass(IntPropertyEditor.class);


			PropertyEditor propertyEditor = pd.createPropertyEditor(user);

			propertyEditor.setAsText("18");


			Method writeMethod = pd.getWriteMethod();

			writeMethod.invoke(user,propertyEditor.getValue());

			System.out.println(user);
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}


	}




	public static class IntPropertyEditor extends  PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			setValue(Integer.valueOf(text));
		}
	}
}
