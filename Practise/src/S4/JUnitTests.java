package S4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class JUnitTests {
    int add(int a, int b){return a+b;}

    @Test
    void test1(){
        assertEquals(8,add(3,5));
    }
    @Test
    void test2(){
        int result;
        result = add(3,5);

        assert (result==8):"not it is";
    }
    @Test
    void test3(){
        Random random = new Random();
        int a = random.nextInt();
        int b = random.nextInt();
        Assertions.assertEquals(a+b,add(a,b));
    }

}
