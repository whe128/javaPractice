package J12;


public class ArrayList<T> implements List<T> {
    public static final int GROW_FACTOR = 2;
    T[] elements=(T[])new Object[1];
    int size;

    @Override
    public void add(T o) {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }


    public boolean contains(Object o) {
        return false;
    }


    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public void reverse() {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
