import java.time.LocalDate;

class Human {
    private int age;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int weight;

    public Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Личность: " +
                "Возраст: " + age +
                ", Имя: " + firstName + '\'' +
                ", Фамилия: " + lastName + '\'' +
                ", Дата рождения: " + birthDate +
                ", Вес: " + weight
                ;
    }
}