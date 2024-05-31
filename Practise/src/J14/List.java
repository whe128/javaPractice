package J14;

import java.util.Collection;
import java.util.Iterator;

//this interface extends the collection
public interface List<T> extends Collection<T> {
    boolean add(T o);
    T get(int index);
    int size();

    T remove(int index);
    void reverse();

    //get a iterator
    Iterator<T> iterator();
}
