package A03;

import java.util.ArrayList;

public class ArrayListSet<T> implements Set<T> {
    ArrayList<T> list = new ArrayList<>();

    @Override
    public boolean add(T value) {
        if(list.contains(value)){
            return false;
        }
        list.add(value);
        return true;
    }

    @Override
    public boolean contains(T value) {
        return list.contains(value);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean remove(T value) {
        return list.remove(value);
    }

    @Override
    public String toString() {
        return list.toString();
    }


    public static void main(String[] args) {
        ArrayListSet<String> set= new ArrayListSet<>();
        System.out.println(set);
        set.add("apple");
        set.add("orange");
        set.add("banana");
        set.add("pear");
        set.add("apricot");
        set.add("peach");
        set.add("mango");
        set.add("plum");
        System.out.println(set);
        set.add("grape");
        System.out.println(set);
        set.add("cherry");
    }
}
