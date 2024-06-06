package J14;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Collections {
    public static void main(String[] args) {
        Student fred = new Student("Fred", 21, "u1234567", "BCOMP");
        Student zixian = new Student("Zixian", 19, "u1234568", "ACOMP");
        Student sue = new Student("Sue", 23, "u1234569", "MCOMP");
        Student mary = new Student("Mary", 20, "u1234570", "AENGI");

        //use interface for variable type
        List<Student> students = new ArrayList<>();
        students.add(fred);
        students.add(zixian);
        students.add(sue);
        students.add(mary);

        fred.marks.put("COMP1110-2023-s1", 86.0);
        zixian.marks.put("COMP1110-2024-s1", 78.0);
        sue.marks.put("COMP1110-2023-s2", 95.0);
        zixian.marks.put("COMP1100-2024-s1", 90.0);
        fred.marks.put("COMP1110-2023-s2", 75.0);

        for(Student s : students) {
            System.out.println(s);
        }

        Map<String, Student> studentDirectory = new HashMap<>();
        Iterator<Student> iterator = students.iterator();

        //iterator
        while (iterator.hasNext()){
            Student student = iterator.next();
            studentDirectory.put(student.uid,student);
        }

        Iterator<String> stringIterator = studentDirectory.keySet().iterator();
        while(stringIterator.hasNext()){
            String uid = stringIterator.next();
            System.out.println(uid+ " " + studentDirectory.get(uid));
        }

        //foreach
        studentDirectory.keySet().forEach(key-> System.out.println("foreach "+ key + " " + studentDirectory.get(key) ));
        System.out.println(studentDirectory.containsKey("u123"));
    }
}
