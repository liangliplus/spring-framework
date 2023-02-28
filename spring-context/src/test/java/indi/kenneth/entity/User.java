package indi.kenneth.entity;

import java.util.Date;

/**
 * @Author liangll
 * @Date 2023/2/27
 */
public class User {
	private int age;
	private String desc;
	private Address address;
	private Date birthday;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User{" +
				"age=" + age +
				", desc='" + desc + '\'' +
				", address=" + address +
				", birthday=" + birthday +
				'}';
	}
}
