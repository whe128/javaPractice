package J12;

public class LinkedList<T> implements List<T> {
    ListNode start;
    ListNode end;
    int size = 0;

    private class ListNode{
        T value;
        ListNode next;
        public ListNode(T value, ListNode next){
            this.value = value;
            this.next = next;
        }
    }
    @Override
    public void add(T o) {
        ListNode node = new ListNode(o,null);
        if(start == null){
            start = node;
            end = start;
        }
        else {
            end.next = node;
            end=node;
        }
        size++;
    }

    @Override
    public T get(int index) {
        if(index<0 || index>=size){
            return null;
        }
        ListNode currentNode = start;
        while(index!=0){
            currentNode = currentNode.next;
            index--;
        }
        return currentNode.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T remove(int index) {
        if(index<0 || index>=size){
            return null;
        }

        ListNode currentNode = start;
        ListNode previousNode = null;
        while(index!=0){
            previousNode = currentNode;
            currentNode = currentNode.next;
            index--;
        }
        T ret = currentNode.value;
        if(previousNode!=null){
            previousNode.next = currentNode.next;
        }
        else {
            start = currentNode.next;
        }
        if(currentNode.next == null){
            end = previousNode;
        }
        size--;
        return ret;
    }

    ListNode reverseUseRecursion(ListNode node){
        if(node.next == null){
            return node;
        }
        else {
            //first reverse the subList
            ListNode newHeadNode =  reverseUseRecursion(node.next);

            //sub list, the start becomes the end. and the end should go to the start
            node.next.next = node;
            //node at the first before, then it at the end, so it's next should be null
            node.next = null;
            return newHeadNode;
        }
    }
    @Override
    public void reverse() {
        boolean useRecursionFlag = true;
        if(!useRecursionFlag){
            if(size<1){
                return;
            }
            if(size == 2){
                end=start;
                start=start.next;

                end.next=null;
                start.next=end;
                return;
            }
            ListNode node1 = start;
            ListNode node2 = node1.next;
            ListNode node3 = node2.next;
            node1.next = null;
            node2.next = node1;
            end = start;

            //we have already removed at first, wo we need to remove then reverse
            //when occur node1 node2 node3(null)--we have reversed, then next loop, we will stop
            //the judgement is whether the node3 is null
            while(node3!=null){
                node1 = node2;
                node2 = node3;
                node3 = node3.next;
                node2.next = node1;
            }
            start = node2;

        }
        else {
            end = start;
            start = reverseUseRecursion(start);
        }

    }
    public String toString() {
        if(start==null) {
            return "";
        }
        String ret="";
        ListNode current=start;
        while(current!=null) {
            if(ret.length()>0) {
                ret+=" ";
            }
            ret+=current.value.toString();
            current=current.next;
        }
        return ret;
    }
}
