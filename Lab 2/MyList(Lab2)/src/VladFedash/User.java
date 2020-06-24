package VladFedash;

public class User {
	private String surname;
	private String name;
	private String secondName;
	private int age;
	private double height;

	public User(String surname, String name, String secondName, int age, double height) {
			
		this.surname = surname;
		this.name = name;
		this.secondName = secondName;
		this.age = age;
		this.height = height;
	}

	String getSurname() {
		return surname;
	}

	String getName() {
		return name;
	}

	String getSecondName() {
		return secondName;
	}

	int getAge() {
		return age;
	}

	double getHeight() {
		return height;
	}
	@Override
    public String toString() {
        return String.format("Student{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", secondName=" + secondName +
                ", age=" + age +
                ", height=" + height +
                '}');
    }

	
}
