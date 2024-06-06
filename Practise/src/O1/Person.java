package O1;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Person(String name){
        this.name=name;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ", aged "+age;
    }
    public static void main(String[] args) {
        Person fred = new Person("Fred", 23);
        System.out.println(fred);
        Person mary = new Person("mary");
        System.out.println(mary);
        mary.setAge(25);
        System.out.println(mary);
    }
}
