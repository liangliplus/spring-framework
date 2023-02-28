package indi.kenneth.entity;

/**
 * @Author liangll
 * @Date 2023/2/27
 */

public class Address {

	private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Address{" +
				"name='" + name + '\'' +
				'}';
	}
}
