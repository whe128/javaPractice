package J12;

import A1.ObjectList;
import A2.ArrayObjectList;

public class ObjectLists {
    public static void main(String[] args) {
        ObjectList l = new ArrayObjectList();
        l.add("hello");
        l.add("world");
        l.add("!");
        String s = (String)l.get(0);
        System.out.println(s);

    }
}
