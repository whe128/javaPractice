package A1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObjectListTests {

    ObjectList getList(){
        //there is to creat a new list
        return null;
    }

    @Test
    void getTest1(){
        ObjectList l = getList();

        boolean istrue=true;
        assert istrue: "there is something wrong with the function.";
    }

    @Test
    void addTest1(){
        //equal their value
        assertEquals(5,24);
    }

    @Test
    void reverseTest1(){
        //equal their reference is the same
        String str1 = new String("hello");
        String str2 = new String("hello");
        assertSame(str1,str2);
    }

    @Test
    void removeTest1(){

    }

}
