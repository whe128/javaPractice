package R1;

public class HashFunction {

    private static class Foo{

    }

    public String firstName;
    public String lastName;
    public int age;
    public Foo foo;

    public int hashCode(){
        int hash = 0;
        //for every addition, we first multiply the previous hash with 31
        //why 31, it is prime
        //we calculate the every member's hash and first multiply 31,then add them
        for(char ch:firstName.toCharArray()){
            hash = 31*hash + ch;
        }
        for(char ch:lastName.toCharArray()){
            hash = 31*hash +ch;
        }
        hash = 31*hash + age;
        hash = 31*hash + foo.hashCode();
        return hash;
    }
}
