package indi.kenneth.entity;

import java.beans.PropertyEditorSupport;

/**
 * @Author liangll
 * @Date 2023/2/28
 */
public class StringToIntegerPropertyEditor  extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(Integer.parseInt(text));
	}
}
