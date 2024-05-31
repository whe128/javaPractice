package J14;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class ArrayList<T> implements List<T> {
    public static final int GROW_FACTOR = 2;
    T[] elements=(T[])new Object[1];
    int size=0;
    private long version=0; // to detect changes in the list while an iterator is working on it; see iterator
    @Override
    public boolean add(T o) {
        if(elements.length>size) {
            elements[size] = o;
        } else {
            T[] newArr=(T[])new Object[elements.length*GROW_FACTOR];
            for(int i=0;i<size; i++) {
                newArr[i] = elements[i];
            }
            newArr[size]=o;
            elements=newArr;
        }
        size++;
        version++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        if(index>=size || index<0) {
            return null;
        }
        return elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public T remove(int index) {
        version++;
        if(index>=size || index<0) {
            return null;
        }
        T ret=elements[index];
        for(int i=index;i<size-1;i++) {
            elements[i]=elements[i+1];
        }
        elements[size-1]=null;
        size--;
        return ret;
    }

    @Override
    public void reverse() {
        version++;
        T[] newArr=(T[])new Object[elements.length];
        for(int i=size-1;i>=0;i--) { // could just as well go from 0 to size
            newArr[i]=elements[size-i-1];
        }
        elements=newArr;
    }

    private class ArrayListIterator implements Iterator<T> {
        private final long baseVersion;
        private int index=0;
        public ArrayListIterator() {
            baseVersion=version;
        }
        @Override
        public boolean hasNext() {
            return baseVersion==version && index<size;
        }

        @Override
        public T next() {
            if(baseVersion!=version) {
                //see https://docs.oracle.com/javase/8/docs/api/java/util/ConcurrentModificationException.html
                // basically, think about what happens to the iterator when someone deletes an element from the list
                throw new ConcurrentModificationException();
            }
            T ret = elements[index]; //this will throw exception if out of bounds
            index++;
            return ret;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public String toString() {
        String ret="";
        for(int i=0;i<size;i++) {
            if(ret.length()>0) {
                ret+=" ";
            }
            ret+=elements[i].toString();
        }
        return ret;
    }
}
