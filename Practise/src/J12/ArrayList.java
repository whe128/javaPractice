package J12;


public class ArrayList<T> implements List<T> {
    public static final int GROW_FACTOR = 2;
    T[] elements=(T[])new Object[1];
    int size;

    @Override
    public void add(T o) {
        if(elements.length<=size){
            T[] oldElements = elements;
            elements = (T[])new Object[elements.length*GROW_FACTOR];
            for (int i = 0; i < size; i++) {
                elements[i] = oldElements[i];
            }
        }
        elements[size] = o;
        size++;
    }

    @Override
    public T get(int index) {
        if(index>=size || index<0){
            return null;
        }
        return elements[index];
    }

    @Override
    public int size() {
        return size;
    }


    public boolean contains(T o) {
        for(T element:elements){
            if(elements.equals(o)){
                return true;
            }
        }
        return false;
    }


    @Override
    public T remove(int index) {
        if(index>=size || index<0){
            return null;
        }
        T ret = elements[index];
        for (int i = index; i < size-1; i++) {
            elements[i] = elements[i+1];
        }
        elements[size-1]=null;
        size--;
        return ret;
    }

    @Override
    public void reverse() {
        T temp;
        for (int i = 0; i < size/2; i++) {
            temp = elements[i];
            elements[i] = elements[size-1-i];
            elements[size-1-i]=temp;
        }
    }

    @Override
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
