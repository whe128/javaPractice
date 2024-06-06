package C1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Matrilineal {
    String matrilineal(int distance){
        if(distance == 0){
            return "you";
        }
        else if(distance==1){
            return "your mother";
        }
        else {
            return  "your " + greats(distance-2) +"mother";
        }
    }

    String greats(int distance){
        if(distance==0){
            return "grand";
        }
        else {
            return "great "+greats(distance-1);
        }
    }

    @Test
    void mat0() {
        assertEquals("you",matrilineal(0));
    }

    @Test
    void mat1() {
        assertEquals("your mother", matrilineal(1));
    }

    @Test
    void mat2() {
        assertEquals("your grandmother", matrilineal(2));
    }

    @Test
    void mat3() {
        assertEquals("your great grandmother", matrilineal(3));
    }

    @Test
    void mat4() {
        assertEquals("your great great grandmother", matrilineal(4));
    }
}

