package A06;

import A04.HashSet;

public class HashMap<K, V> implements Map<K, V> {
    //the element in the set is Entry
    private HashSet<Entry<K, V>> hashSet = new HashSet<>();
    @Override
    public V put(K key, V value) {
        //use key to search
        Entry<K, V> entry = hashSet.get(new Entry<K, V>(key));
        //if no this entry, add directly
        if(entry == null){
            hashSet.add(new Entry<K, V>(key,value));
            return null;
        }
        //already have the entry, then update the value
        V oldValue = entry.value;
        entry.value = value;
        return oldValue;
    }

    @Override
    public V get(K key) {
        //use key to search
        Entry<K,V> entry = hashSet.get(new Entry<K,V>(key));
        if(entry == null){
            return null;
        }
        else {
            return entry.value;
        }
    }

    @Override
    public V remove(K key) {
        Entry<K,V> entry = hashSet.removeAndReturn(new Entry<K,V>(key));
        return (entry==null)?null: entry.value;
    }

    @Override
    public int size() {
        return hashSet.size();
    }

    @Override
    public String toString() {
        return hashSet.toString();
    }

    public static void main(String[] args) {
        String s = "my string";
        String t = "my strin";
        t += "g";
        System.out.println(s == s);
        // false because s and t point to different part of the memory
        System.out.println(s == t);
        // true because the content of the strings s and t are the same
        System.out.println(s.equals(t));

        HashMap<String, Integer> map = new HashMap<>();
        map.put("orange", 40);
        map.put("nectarine", 30);
        map.put("banana", 20);
        map.put("apple", 30);
        map.put("mandarin", 20);
        map.put("feijoa", 10);
        map.put("raspberry", 400);
        System.out.println(map);
        map.put("orange", 41);
        map.put("nectarine", 31);
        System.out.println(map);
        map.put("apricot", 22);
        map.put("fig", 12);
        System.out.println(map);

    }
}
