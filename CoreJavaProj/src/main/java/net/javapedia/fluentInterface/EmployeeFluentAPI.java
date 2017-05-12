package net.javapedia.fluentInterface;

public class EmployeeFluentAPI {
	
	public String name;
	
	public int age;
	
	public boolean isActive;

	public EmployeeFluentAPI setName(String name) {
		this.name = name;
		return this;
	}

	public EmployeeFluentAPI setAge(int age) {
		this.age = age;
		return this;
	}

	public EmployeeFluentAPI setActive(boolean isActive) {
		this.isActive = isActive;
		return this;
	}
	
	@Override
	public String toString() {
		return new StringBuffer().append("Employee name: ").append(this.name)
								 .append(" and his age: ").append(this.age).toString();
	}
	
	
	

}
