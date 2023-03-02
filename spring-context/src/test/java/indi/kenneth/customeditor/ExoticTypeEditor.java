package indi.kenneth.customeditor;

import java.beans.PropertyEditorSupport;

/**
 * @author kenneth
 * @Date: 2023/2/28
 */
public class ExoticTypeEditor extends PropertyEditorSupport {

	public void setAsText(String text) {
		setValue(new ExoticType(text.toUpperCase()));
	}
}