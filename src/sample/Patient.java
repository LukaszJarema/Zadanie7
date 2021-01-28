package sample;

public class Patient implements Comparable <Patient> {
    private String name;
    private String lastName;
    private int age;

    public Patient(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Patient p) {
        return p.age-this.age;
    }
}
