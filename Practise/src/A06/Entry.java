package A06;

import java.util.Objects;

public class Entry<K,V> {
    K key;
    V value;

    public Entry(K key, V value){
        this.key = key;
        this.value = value;
    }

    public Entry(K key){
        this.key = key;
    }
    //use the key's hashCode for search
    public int hashCode(){
        return (key == null)? 0 : key.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        //input object is null
        if(obj == null){
            return false;
        }
        //input Class type is different from this object
        if(obj.getClass() != this.getClass()){
            return false;
        }
        //the same object
        if(this == obj){
            return true;
        }
        Entry entry = (Entry<K,V>) obj;

        return Objects.equals(key, entry.key);
    }

    @Override
    public String toString() {
        return "(" + key + " " + value + ")";
    }

    public static void main(String[] args) {
        Entry<String, Integer> e1=new Entry<>("apple",30);
        Entry<String, Integer> e2=new Entry<>("apple");
        Entry<String, Integer> e3=new Entry<>(null,0);
        Entry<String, Integer> e4=new Entry<>(null);


        System.out.println(e1==e2);
        System.out.println(e1.equals(e2));

        System.out.println(e3==e4);
        System.out.println(e3.equals(e4));
    }
}
