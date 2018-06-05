package net.javapedia.pattern;

interface Builder<T> {
	
	T build();
}
public class BuilderPatternEx {

	static class Person {
		private String fName;
		private String lName;
		private short age;
		private String employerName;

		@SuppressWarnings("rawtypes")
		public static class PersonBuilder implements Builder{
			private String fName;
			private String lName;
			private short age;
			private String employerName;

			public PersonBuilder(String fName, String lName) {
				this.fName = fName;
				this.lName = lName;
			}

			public PersonBuilder age(short age) {
				this.age = age;
				return this;
			}

			// The builder’s setter methods return the builder itself so that
			// invocations can be chained.
			public PersonBuilder employerName(String employerName) {
				this.employerName = employerName;
				return this;
			}

			public Person build() {
				return new Person(this);
			}
		}

		Person(PersonBuilder p) {
			this.fName = p.fName;
			this.lName = p.lName;
			this.age = p.age;
			this.employerName = p.employerName;

		}

		@Override
		public String toString() {
			StringBuilder temp = new StringBuilder("Peron details: ");
			temp.append(this.fName).append(" ").append(this.lName).append(" of age ").append(this.age);

			return temp.toString();
		}

	}

	public static void main(String[] args) {

		Person p = new Person.PersonBuilder("John", "Jacob").age((short) 45).employerName("Apple").build();

		System.out.println(p);
	}
}
