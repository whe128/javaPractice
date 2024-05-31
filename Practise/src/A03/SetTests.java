package A03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//this is the abstract class
public abstract class SetTests {

    //abstract method, should be realized in the subclass
    //return the Set<T>
    //the type of T extends the Comparable<T>
    //use this method to create a set
    public abstract <T extends Comparable<T>> Set<T> createEmptySet();

    @Test
    public void addAndRemoveAlot(){
        int MAX_ITEMS = 300;
        Set<Integer> set = createEmptySet();
        Assertions.assertEquals(0,set.size());
        for(int i=0;i<MAX_ITEMS;i++){
            Assertions.assertTrue(set.add(i));
            Assertions.assertEquals(i+1,set.size());
            Assertions.assertTrue(set.contains(i));
        }
        for(int i=0;i<MAX_ITEMS;i++){
            Assertions.assertFalse(set.add(i));
            Assertions.assertEquals(MAX_ITEMS,set.size());
        }
        for(int i=0;i<MAX_ITEMS;i++){
            Assertions.assertTrue(set.remove(i));
            Assertions.assertEquals(MAX_ITEMS-i-1,set.size());
            Assertions.assertFalse(set.contains(i));
        }
    }

    @Test
    public void addingStrings(){
        Set<String> set = createEmptySet();
        Assertions.assertEquals(0, set.size());
        Assertions.assertFalse(set.contains("monday"));
        Assertions.assertTrue(set.add("monday"));
        Assertions.assertEquals(1, set.size());
        Assertions.assertTrue(set.contains("monday"));
        Assertions.assertFalse(set.add("monday"));
        Assertions.assertEquals(1, set.size());
        Assertions.assertFalse(set.contains("MONDAY"));
        Assertions.assertTrue(set.add("MONDAY"));
        Assertions.assertEquals(2, set.size());
        Assertions.assertTrue(set.contains("MONDAY"));
        Assertions.assertFalse(set.add("MONDAY"));
        Assertions.assertEquals(2, set.size());
        Assertions.assertTrue(set.remove("MONDAY"));
        Assertions.assertEquals(1, set.size());
        Assertions.assertFalse(set.contains("MONDAY"));
        Assertions.assertFalse(set.remove("MONDAY"));
    }
}
