package net.javapedia.fluentInterface;

public class EmpMain {
	
	public static void main(String[] args) {
		
		EmployeeFluentAPI emp = new EmployeeFluentAPI().setName("Jacob")
													 .setAge(23)
													 .setActive(true);
		
		System.out.println(emp);
	}

}
