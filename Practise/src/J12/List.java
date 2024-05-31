package J12;

//just a inteface
public interface List<T> {
    void add(T o);
    T get(int index);
    int size();

    T remove(int index);
    void reverse();
}
