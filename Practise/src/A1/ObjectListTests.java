package A1;

import A2.ArrayObjectList;
import A2.LinkedObjectList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class ObjectListTests {

    ObjectList getList(){
        //there is to create a new list
        return new LinkedObjectList();
    }

    @Test
    void getTest1(){
        ObjectList l = getList();
        l.add(l);
        assertSame(l,l.get(0));
    }

    @Test
    void addTest1(){
        ObjectList l = getList();
        assertEquals("",l.toString());
        l.add(5);
        assertEquals("5", l.toString());
        l.add("hello");
        //equal their value
        assertEquals("5 hello",l.toString());
    }

    @Test
    void reverseTest1(){
        ObjectList l = getList();
        l.add("hi");
        l.add("world");
        l.add("aaa");
        l.add("bbb");
        l.add("ccc");
        l.add("fff");
        l.add("ddd");
        l.add("sss");
        l.reverse();
        assertEquals("sss ddd fff ccc bbb aaa world hi",l.toString());
    }

    @Test
    void removeTest1(){
        ObjectList l = getList();
        l.add("hi");
        l.add("world");
        l.remove(1);
        assertEquals("hi",l.toString());
        l.remove(0);
        assertEquals("",l.toString());
    }
}
