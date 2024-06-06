package A06;

/**
 * the interface with finite domain that maps the keys and values
 * @param <K> type for keys (can be null)
 * @param <V>  type for values (can be null)
 */
public interface Map<K,V> {

    /**
     * adds a key to value mapping
     * if key already used in map, its value is updated to the new one
     * @param key for mapping (can be null)
     * @param value for mapping (can be null)
     * @return old value (can be null) for key, if it is already in map, otherwise return null
     */
    V put(K key, V value);

    /**
     * get value associated with key
     * @param key to get the value
     * @return value associated with key (can be null) or null if key is not in mep
     */
    V get(K key);

    /**
     * Remove key and associated value from map
     * @param key need to be removed
     * @return the value associated with key (can be null) or null if key is not the the map
     */
    V remove(K key);

    /**
     * the number of mappings(associations) in the map
     * @return the number of mapping
     */
    int size();
}
