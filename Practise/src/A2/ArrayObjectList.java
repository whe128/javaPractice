package A2;

import A1.ObjectList;

public class ArrayObjectList implements ObjectList {
    public static final int GROW_FACTOR = 2;
    Object[] elements = new Object[1];
    int size = 0;
    @Override
    public void add(Object o) {
        //update the length of array
        if (elements.length <= size) {
            Object[] oldArray = elements;
            elements = new Object[elements.length * GROW_FACTOR];
            for (int i = 0; i < size; i++) {
                elements[i] = oldArray[i];
            }
        }

        //this must add
        elements[size] = o;
        size++;
    }

    @Override
    public Object get(int index) {
        if(index<0 || index>=size){
            return null;
        }
        return elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object remove(int index) {
        if(index<0 || index>=size){
            return null;
        }
        //remove the obj
        Object removedObj = elements[index];
        //shift
        for (int i = index; i < size-1 ; i++) {
            elements[i]=elements[i+1];
        }
        //last become null
        elements[size-1]=null;
        size--;
        return removedObj;
    }

    @Override
    public void reverse() {
        Object temp;
        /*4
         * 0 3
         * 1 2
         * 5
         * 0 4
         * 1 3
         */
        for(int i=0;i<size/2;i++){
            temp = elements[i];
            elements[i] = elements[size-1-i];
            elements[size-1-i]=temp;
        }

    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            if(i>0){
                stringBuffer.append(" ");
            }
            stringBuffer.append(elements[i].toString());
        }
        return stringBuffer.toString();
    }
}
