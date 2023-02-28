package indi.kenneth.introspector;

import indi.kenneth.entity.*;

import java.beans.*;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author liangll
 * @Date 2023/2/28
 */
public class MyBeanInfo extends SimpleBeanInfo {
	private BeanInfo beanInfo;
	private Object target;

	public MyBeanInfo(Object target) {
		try {
			this.beanInfo = Introspector.getBeanInfo(target.getClass());
			this.target = target;
		} catch (IntrospectionException e) {
			throw new RuntimeException("获取bean信息失败");
		}
	}

	@Override
	public PropertyDescriptor[] getPropertyDescriptors() {
		//设置转换属性的信息
		for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
			Class<?> returnType = propertyDescriptor.getReadMethod().getReturnType();
			if (returnType == int.class) {
				propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
			} else if (returnType == Date.class) {
				propertyDescriptor.setPropertyEditorClass(StringToDatePropertyEditor.class);
			} else {
				propertyDescriptor.setPropertyEditorClass(StringToStringPropertyEditor.class);
			}
		}
		return beanInfo.getPropertyDescriptors();
	}


	public Object getTarget() {
		return target;
	}

	public static void main(String[] args) throws Exception {
		//考虑一种情况，我们是接受从前端/GUI程序传入过来的数据,我们如果把传入的字符串转换为我们对象目标类型
		// 这就和我们在getPropertyDescriptors 中设置PropertyEditorClass有关勒
		/**
		 * <bean class="indi.kenneth.entity.User">
		 *     <property name="age" value="18"/>
		 *     <property name="birthday" value="2022-12-12"/>
		 * <bean/>
		 *
		 *  * <bean class="indi.kenneth.entity.Address">
 		 *     <property name="name" value="shanghai"/>
 		 *
 		 * <bean/>
		 *
 		 */
		User user = new User();
		MyBeanInfo beanInfo = new MyBeanInfo(user);
		//例如这里要转换age
		convertForProperty("age", "18", beanInfo);
		convertForProperty("birthday", "2022-12-12", beanInfo);

		System.out.println(beanInfo.getTarget());

		beanInfo = new MyBeanInfo(new Address());
		convertForProperty("name","shanghai",beanInfo);

		System.out.println(beanInfo.getTarget());

	}

	private static Object convertForProperty(String fieldName, String fieldTextValue, MyBeanInfo beanInfo) throws Exception {
		PropertyDescriptor pd = choosePropertyDescriptor(fieldName, beanInfo);
		if (pd == null) {
			throw new RuntimeException("fieldName propertyEditor is null");
		}
		PropertyEditor propertyEditor = (PropertyEditor) pd.getPropertyEditorClass().newInstance();
		//转换的过程
		propertyEditor.setAsText(fieldTextValue);
		Object value = propertyEditor.getValue();
		Object target = beanInfo.getTarget();
		Method writeMethod = pd.getWriteMethod();
		writeMethod.invoke(target,value);
		return value;

	}


	private static PropertyDescriptor choosePropertyDescriptor(String fieldName, MyBeanInfo beanInfo) throws IllegalAccessException, InstantiationException {
		for (PropertyDescriptor pd : beanInfo.getPropertyDescriptors()) {
			if (pd.getName().equals(fieldName)) {
				return pd;
			}
		}
		return null;


	}
}
