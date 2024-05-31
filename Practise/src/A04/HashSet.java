package A04;

import A03.Set;

import java.util.ArrayList;

public class HashSet<T> implements Set<T> {
    static final int INIT_SIZE = 4;
    static final int MAX_LOAD_FACTOR = 2;   //max elements on a list
    ArrayList<ArrayList<T>> buckets = new ArrayList<>(); //every element is stored in a list, every element is a list
    int itemCount = 0;

    public HashSet(){
        for(int i=0;i<INIT_SIZE;i++){
            //at first, we create four list and store them in the bucket
            buckets.add(new ArrayList<>());
        }
    }

    /**
     * firstly we read the hashCode of this object
     * then we use this hash code to create the index of list
     * just use the bucket's size to divide the hash code and get the remainder
     * @param entry
     * @return
     */
    private ArrayList<T> getPossibleBucket(T entry){
        //at which list
        int hashCode = entry.hashCode();
        int listIndex = (int)(Integer.toUnsignedLong(hashCode)%buckets.size());
        return buckets.get(listIndex);
        //then we use the index to get the list
    }


    /**
     * it is the core of hash Set, that if the itemsCount exceeds the capacity
     * we need to resize the capacity, by adding the number of list
     * then redistribute all element
     * the hashcode can be divided by the number of bucket's size, number of the list number
     * then the remainder represents the index of the which list
     */
    private void resizeIfNeeded(){
        // max capacity, every list have MAX_LOAD_FACTOR
        // they are full
        if(itemCount<MAX_LOAD_FACTOR*buckets.size()){
            return;
        }
        //then we need to resize the bucket
        //first store the buckets
        //then new it
        ArrayList<ArrayList<T>> oldBuckets = buckets;
        buckets = new ArrayList<>();

        //old length*(4+1)----bigger for 5 times
        int newSize = oldBuckets.size()*(MAX_LOAD_FACTOR+1);
        //change the size to store more list in the bucket
        for(int i=0;i<newSize;i++){
            //create each list
            buckets.add(new ArrayList<>());
        }
        //add all items from the oldBuckets to the new bucket
        for(ArrayList<T> list: oldBuckets){
            for(T item:list){
                //read all items in the old bucket, and add them to the new
                //redistribute the items
                add(item);
            }
        }
    }

    @Override
    public boolean add(T entry) {
        //if it contains this entry, then we can not add again
        //and just return false
        if(contains(entry)){
            return false;
        }
        //every time we judge whether we should resize the capacity
        //after this function, if the itemNum greater the capacity, it will resize in this function
        resizeIfNeeded();
        //use the entry to get the list of this entry.
        //we use the hash code of this entry, and use the hash code to get the list
        //find what this entry belong to which list
        ArrayList<T> list= getPossibleBucket(entry);
        //finally, we add it to the list
        list.add(entry);
        itemCount++;
        return true;
    }

    @Override
    public boolean contains(T entry) {
        //first get the possible list--this use the hash code of entry
        //then find whether the entry in this list
        return getPossibleBucket(entry).contains(entry);
    }

    @Override
    public int size() {
        return itemCount;
    }

    @Override
    public boolean remove(T entry) {
        ArrayList<T> list = getPossibleBucket(entry);
        if(list.contains(entry)){
            list.remove(entry);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuffer builder = new StringBuffer();
        int i = 0;
        for(ArrayList<T> list:buckets){
            builder.append(i+": [");
            for(T item: list){
                builder.append(item+ ", ");
            }
            builder.append("]\n");
            i++;
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        System.out.println(set);

        set.add("apple");
        set.add("orange");
        set.add("banana");
        set.add("pear");
        System.out.println(set);
        set.add("apricot");
        set.add("peach");
        set.add("mango");
        set.add("plum");
        set.add("apple");
        System.out.println(
                "We have 8 items and 4 buckets so far. The next added item will trigger\n" +
                        "a resize because we will exceed the loading factor of 2, that is, we would\n" +
                        "have more than twice as many items as buckets for INIT_SIZE = 4 and \n" +
                        "MAX_LOAD_FACTOR = 2\n");

        set.add("grape");
        System.out.println(set);
        set.add("cherry");
        System.out.println(set);

    }
}
