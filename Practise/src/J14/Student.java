package J14;


import O1.Person;

import java.util.HashMap;
import java.util.Map;

public class Student extends Person {
    String uid;
    String major;
    Map<String, Double> marks;

    public Student(String name, int age, String uid, String major) {
        super(name, age);
        this.uid=uid;
        this.major=major;
        marks=new HashMap<>();
    }

    public double average() {
        if(marks.size()==0) {
            return 0;
        }
        double sum=0.0;
        for(Double mark : marks.values()) {
            sum+=mark;
        }
        return sum/marks.size();
    }

    @Override
    public String toString() {
        return super.toString()+", UID "+uid+", majoring in "+major+", average marks: "+average();
    }
}
