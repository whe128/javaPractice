package A03;

/**
 * A set that stores values check equality using equals
 */
public interface Set<T> {
    /**
     * add a new value to the set
     * stored value can be null
     * return false if the value already in the set
     */
    boolean add(T value);

    /**
     * check if value contained in the set
     * @param value
     * @return true if value is in set
     */
    boolean contains(T value);

    /**
     * number of values stored in the set
     * @return
     */
    int size();

    /**
     * remove value from the set if it is present
     * @param value
     * @return true if removed, false if value was not in the set
     */
    boolean remove(T value);
}
