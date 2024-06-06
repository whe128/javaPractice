package J12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ListTests {
    // Pick the version you want to test
    //ObjectList getList() {
    //    return new comp1110.lectures.A2.LinkedObjectList();
    //}
    <T> List<T> getList() {
        return new LinkedList<>();
    }

    @Test
    void getTest1() {
        List<Object> l = getList();
        l.add(l);
        assertSame(l, l.get(0));
    }

    @Test
    void addTest1() {
        List<Object> l = getList();
        assertEquals("", l.toString());
        l.add(5);
        assertEquals("5", l.toString());
        l.add("hello");
        assertEquals("5 hello", l.toString());
    }

    @Test
    void reverseTest1() {
        List<String> l = getList();
        l.add("hi");
        l.add("world");
        l.reverse();
        assertEquals("world hi", l.toString());
    }

    @Test
    void removeTest1() {
        List<String> l = getList();
        l.add("hi");
        l.add("world");
        l.remove(1);
        assertEquals("hi", l.toString());
    }
}
