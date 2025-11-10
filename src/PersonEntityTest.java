import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PersonEntityTest {
	static class Person {
		int id;
		@Override
		public String toString() {
			return "Person [id=" + id + ", name=" + name + ", department=" + department + ", gender=" + gender + "]";
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		String name;
		String department;
		String gender;
		Person(int id, String name, String department, String gender) {
			this.id = id;
			this.name = name;
			this.department = department;
			this.gender = gender;
		}
	}

	public static void main(String args[]) {
		ArrayList<Person> personList = new ArrayList<Person>();
		personList.add(new Person(1, "John", "Development", "M"));
		personList.add(new Person(2, "Alice", "QA", "F"));
		personList.add(new Person(3, "Kartik", "QA", "M"));
		personList.add(new Person(4, "Beth", "Development", "F"));
		personList.add(new Person(5, "Aaron", "Devops", "M"));
		personList.add(new Person(6, "Sandra", "Devops", "F"));
		personList.add(new Person(7, "Priya", "Development", "F"));
		personList.add(new Person(8, "Ravi", "Development", "M"));

		employeeAndGender(personList);
		distinctDepartment(personList);
		numberOfPersonForEachDepartment(personList);

	}

	public static void employeeAndGender(ArrayList<Person> personList) {
		// John (M), Alice (F), Kartik (M), Beth (F), Aaron (M), Sandra (F), Priya (F),
		// Ravi (M)
		// use stream api to solve the problemx`
		System.out.println("Employee and Gender: ");
		Map<String, List<Person>> personGenderList=personList.stream().collect(Collectors.groupingBy(Person::getGender,Collectors.toList()));		
		personGenderList.forEach((gender,PersonGender)->{
			PersonGender.forEach(person->System.out.println(" "+person.name+"("+person.gender+")"));
		});
	}

	public static void distinctDepartment(ArrayList<Person> personList) {
		// Development, QA, Devops
		// use stream api to solve the problem
		System.out.println("Distinct Department: ");
		List<String> distinctDepartment = personList.stream().map(Person::getDepartment).distinct()
				.collect(Collectors.toList());
		System.out.println(distinctDepartment);
	}

	public static void numberOfPersonForEachDepartment(ArrayList<Person> personList) {
		// Development: 4, QA: 2, Devops: 2
		// use stream api to solve the problem		
		System.out.println("number of person for each department:");
		Map<String, Long> numberOfPersonForEachDepartment = personList.stream()
				.collect(Collectors.groupingBy(Person::getDepartment, Collectors.counting()));
		System.out.println(numberOfPersonForEachDepartment);
	}
}
