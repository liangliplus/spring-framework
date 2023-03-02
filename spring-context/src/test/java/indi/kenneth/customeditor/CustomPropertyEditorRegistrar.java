package indi.kenneth.customeditor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * @author kenneth
 * @Date: 2023/2/28
 */
public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(ExoticType.class,new ExoticTypeEditor());

		//还可以注入其他自定义编辑器
		//registry.registerCustomEditor ....
	}
}
