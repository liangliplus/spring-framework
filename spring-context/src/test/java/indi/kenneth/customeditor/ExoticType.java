package indi.kenneth.customeditor;

/**
 * @author kenneth
 * @Date: 2023/2/28
 */

public class ExoticType {
	private String name;

	public ExoticType() {
	}

	public ExoticType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ExoticType{");
		sb.append("name='").append(name).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
