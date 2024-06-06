package A06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapTest {
    public <K, V> Map<K, V> createEmptyMap(){
        return new HashMap<>();
    }

    @Test
    void growing(){
        Map<String, Integer> map = createEmptyMap();
        Assertions.assertEquals(0,map.size());
        Assertions.assertNull(map.put("orange",40));
        Assertions.assertEquals(1,map.size());
        Assertions.assertNull(map.put("nectarine",30));
        Assertions.assertEquals(2,map.size());
        Assertions.assertNull(map.put("banana",20));
        Assertions.assertEquals(3,map.size());
        Assertions.assertNull(map.put("apple",30));
        Assertions.assertEquals(4,map.size());
        Assertions.assertNull(map.put("mandarin",20));
        Assertions.assertEquals(5,map.size());
        Assertions.assertNull(map.put("feijoa",10));
        Assertions.assertEquals(6,map.size());
        Assertions.assertNull(map.put("raspberry",400));
        Assertions.assertEquals(7,map.size());
    }

    @Test
    void updating(){
        Map<String, Integer> map = createEmptyMap();
        Assertions.assertEquals(0,map.size());
        Assertions.assertNull(map.put("orange", 40));
        Assertions.assertEquals(1, map.size());
        Assertions.assertNull(map.put("nectarine", 30));
        Assertions.assertEquals(2, map.size());
        Assertions.assertNull(map.put("banana", 20));
        Assertions.assertEquals(3, map.size());
        Assertions.assertNull(map.put("apple", 30));
        Assertions.assertEquals(4, map.size());
        Assertions.assertNull(map.put("mandarin", 20));
        Assertions.assertEquals(5, map.size());
        Assertions.assertNull(map.put("feijoa", 10));
        Assertions.assertEquals(6, map.size());
        Assertions.assertNull(map.put("raspberry", 400));
        Assertions.assertEquals(7, map.size());

        Assertions.assertEquals(30, map.put("apple",15)); //old is 30
        Assertions.assertEquals(7,map.size());
        Assertions.assertEquals(20, map.put("mandarin",20)); //old is 20
        Assertions.assertEquals(7,map.size());
    }

    @Test
    void getting(){
        Map<String, Integer> map = createEmptyMap();
        Assertions.assertNull(map.put("orange", 40));
        Assertions.assertNull(map.put("nectarine", 30));
        Assertions.assertNull(map.put("banana", 20));
        Assertions.assertNull(map.put("apple", 30));
        Assertions.assertNull(map.put("mandarin", 20));
        Assertions.assertNull(map.put("feijoa", 10));
        Assertions.assertNull(map.put("raspberry", 400));

        Assertions.assertEquals(30, map.put("apple", 15));
        Assertions.assertEquals(20, map.put("mandarin", 20));
        Assertions.assertEquals(7, map.size());

        Assertions.assertEquals(40, map.get("orange"));
        Assertions.assertEquals(7,map.size());
        Assertions.assertEquals(30, map.get("nectarine"));
        Assertions.assertEquals(20, map.get("banana"));
        Assertions.assertEquals(15, map.get("apple"));
        Assertions.assertEquals(20, map.get("mandarin"));
        Assertions.assertEquals(10, map.get("feijoa"));
        Assertions.assertEquals(400, map.get("raspberry"));
        Assertions.assertEquals(7, map.size());


    }

    @Test
    void missing(){
        Map<String, Integer> map = createEmptyMap();
        //there is no mapping before, return null
        Assertions.assertNull(map.put("orange", 40));
        Assertions.assertNull(map.put("nectarine", 30));
        Assertions.assertNull(map.put("banana", 20));
        Assertions.assertNull(map.put("apple", 30));
        Assertions.assertNull(map.put("mandarin", 20));
        Assertions.assertNull(map.put("feijoa", 10));
        Assertions.assertNull(map.put("raspberry", 400));

        //now have added banana mapping, so can get the value
        Assertions.assertEquals(20, map.get("banana"));

        //no mapping of coffee, tea and milk
        Assertions.assertNull(map.get("coffee"));
        Assertions.assertNull(map.get("tea"));
        Assertions.assertNull(map.get("milk"));
    }

    @Test
    void removing(){
        //first create
        Map<String, Integer> map = createEmptyMap();
        Assertions.assertNull(map.put("orange", 40));
        Assertions.assertNull(map.put("nectarine", 30));
        Assertions.assertNull(map.put("banana", 20));
        Assertions.assertNull(map.put("apple", 30));
        Assertions.assertNull(map.put("mandarin", 20));
        Assertions.assertNull(map.put("feijoa", 10));
        Assertions.assertNull(map.put("raspberry", 400));
        Assertions.assertEquals(7, map.size());

        //remove the mapping that is not in the map
        Assertions.assertNull(map.remove("coffee"));
        Assertions.assertNull(map.remove("tea"));
        Assertions.assertNull(map.remove("milk"));
        Assertions.assertEquals(7, map.size());

        //get and remove banana
        Assertions.assertEquals(20,map.get("banana"));
        Assertions.assertEquals(7, map.size());
        Assertions.assertEquals(20,map.remove("banana"));
        Assertions.assertEquals(6, map.size());
        Assertions.assertNull(map.get("banana"));

        //get and remove orange
        Assertions.assertEquals(40, map.get("orange"));
        Assertions.assertEquals(6, map.size());
        Assertions.assertEquals(40, map.remove("orange"));
        Assertions.assertEquals(5, map.size());
        Assertions.assertNull(map.get("orange"));

        //get and remove raspberry
        Assertions.assertEquals(400, map.get("raspberry"));
        Assertions.assertEquals(5, map.size());
        Assertions.assertEquals(400, map.remove("raspberry"));
        Assertions.assertEquals(4, map.size());
        Assertions.assertNull(map.get("raspberry"));

        //add orange mapping (before, we have removed the mappping)
        Assertions.assertNull(map.put("orange", -10));
        Assertions.assertEquals(5, map.size());
        Assertions.assertEquals(-10, map.get("orange"));
    }

    @Test
    void nullKey(){
        //initialization
        Map<String, Integer> map = createEmptyMap();
        Assertions.assertNull(map.put("orange", 40));
        Assertions.assertNull(map.put("nectarine", 30));
        Assertions.assertNull(map.put("banana", 20));
        Assertions.assertNull(map.put("apple", 30));
        Assertions.assertNull(map.put("mandarin", 20));
        Assertions.assertNull(map.put("feijoa", 10));
        Assertions.assertNull(map.put("raspberry", 400));
        Assertions.assertEquals(7, map.size());

        //put a null key, value is 0
        Assertions.assertNull(map.put(null, 0));
        Assertions.assertEquals(8, map.size());   //null is also a mapping, and the size become 8
        Assertions.assertEquals(0, map.put(null, 666)); //the value of null key, its old value is 0
        Assertions.assertEquals(8, map.size());
        Assertions.assertEquals(666, map.get(null));
        Assertions.assertEquals(666,map.remove(null));
        Assertions.assertEquals(7,map.size());  //remove the null key mapping
        Assertions.assertNull(map.get(null));   // not mapping with the null key
    }

    @Test
    void nullValue(){
        //initialization
        Map<String, Integer> map = createEmptyMap();
        Assertions.assertNull(map.put("orange", 40));
        Assertions.assertNull(map.put("nectarine", 30));
        Assertions.assertNull(map.put("banana", 20));
        Assertions.assertNull(map.put("apple", 30));
        Assertions.assertNull(map.put("mandarin", 20));
        Assertions.assertNull(map.put("feijoa", 10));
        Assertions.assertNull(map.put("raspberry", 400));
        Assertions.assertEquals(7, map.size());

        //can give the value with null, also create a mapping
        Assertions.assertNull(map.put("pineapple",null)); //no this mapping before
        Assertions.assertEquals(8,map.size());  //add the mapping, with null value
        Assertions.assertNull(map.put("pineapple",1));  //update the value, return the null value
        Assertions.assertEquals(8,map.size());
        Assertions.assertEquals(1,map.put("pineapple",null));   //back to null value
        Assertions.assertEquals(8,map.size());
        Assertions.assertNull(map.remove("pineapple"));
        Assertions.assertEquals(7,map.size());      //remove the mapping of " pineapple
    }
}
