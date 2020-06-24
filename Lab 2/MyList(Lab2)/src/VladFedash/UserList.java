package VladFedash;

import java.util.ArrayList;
import java.util.List;

public class UserList {
	
	private List<User> students = new ArrayList<>();
	
	public void init() {
		students.add(new User("Fedash", "Vladislav", "Aleksandrovich", 19, 185));
		students.add(new User("Fedash1", "Vladislav", "Aleksandrovich", 19, 185));
		students.add(new User("Fedash2", "Vladislav", "Aleksandrovich", 19, 185));
		students.add(new User("Fedash3", "Vladislav", "Aleksandrovich", 19, 185));
		students.add(new User("Fedash4", "Vladislav", "Aleksandrovich", 19, 185));
		students.add(new User("Fedash5", "Vladislav", "Aleksandrovich", 19, 185));
		students.add(new User("Fedash6", "Vladislav", "Aleksandrovich", 19, 185));
		students.add(new User("Fedash7", "Vladislav", "Aleksandrovich", 19, 185));
		students.add(new User("Fedash8", "Vladislav", "Aleksandrovich", 19, 185));
		students.add(new User("Fedash9", "Vladislav", "Aleksandrovich", 19, 185));
		students.add(new User("Fedash10", "Vladislav", "Aleksandrovich", 19, 185));
		students.add(new User("Fedash11", "Vladislav", "Aleksandrovich", 19, 185));
		students.add(new User("Fedash12", "Vladislav", "Aleksandrovich", 19, 185));
	}
	
	public List<User> getStudents() {
		return students;
	}	
	
}
