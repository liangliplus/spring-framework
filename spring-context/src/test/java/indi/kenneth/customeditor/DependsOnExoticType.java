package indi.kenneth.customeditor;

/**
 * @author kenneth
 * @Date: 2023/2/28
 */
public class DependsOnExoticType {

	private ExoticType type;


	public void setType(ExoticType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("DependsOnExoticType{");
		sb.append("type=").append(type);
		sb.append('}');
		return sb.toString();
	}
}
