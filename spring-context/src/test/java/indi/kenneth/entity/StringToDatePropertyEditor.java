package indi.kenneth.entity;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author liangll
 * @Date 2023/2/28
 */
public class StringToDatePropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Date value = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

			value = simpleDateFormat.parse(text);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		setValue(value);
	}
}
