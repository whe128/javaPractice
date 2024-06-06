package A2;

import A1.ObjectList;

public class LinkedObjectList implements ObjectList {
    ListNode start;
    ListNode end;
    int size = 0;

    private class ListNode {
        Object value;
        ListNode next;
        public ListNode(Object value, ListNode next){
            this.value = value;
            this.next = next;
        }
    }
    @Override
    public void add(Object o) {
        ListNode newNode = new ListNode(o,null);
        if(start==null){
            start = newNode;
            end = start;
        }
        else {
            end.next = newNode;
            end = newNode;
        }
        size++;
    }

    @Override
    public Object get(int index) {
        if(index<0 || index>=size){
            return null;
        }
        ListNode node=start;
        while(index>0){
            node=node.next;
            index--;
        }
        return node.value;
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
        ListNode node=start;
        ListNode previousNode = null;
        //find the node that needs to be removed
        while (index>0){
            previousNode = node;
            node = node.next;
            index--;
        }
        if(previousNode==null){
            start = node.next;
        }
        else {
            previousNode.next=node.next;
        }
        //node comes to the end, end should be the previous
        if(node == end){
            end = previousNode;
        }
        size--;
        return node.value;

    }

    private ListNode reverseRecursion(ListNode node){
        if(node.next!=null){
            ListNode newHeadNode = reverseRecursion(node.next);
            //node.next go to the end of the linkedList, its next need to be node
            node.next.next = node;
            node.next = null;
            end = node;
            return newHeadNode;
        }
        else {
            start = node;
            return node;
        }

    }

    @Override
    public void reverse() {
        boolean useRecursion = false;
        if(useRecursion){
            if(start!=null){
                reverseRecursion(start);
            }
        }
        else {
            //0
            if(start==null){
                return;
            }
            //1
            if(start.next==null){
                return;
            }
            //2
            if(start.next.next==null){
                ListNode temp = end;
                end=start;
                start = temp;
                start.next = end;
                end.next = null;
                return;
            }

            end = start;
            ListNode node1 = start;
            ListNode node2 = node1.next;
            ListNode node3 = node2.next;

            //first reverse
            node1.next = null;
            node2.next = node1;

            while (node3!= null) {
                node1 = node2;
                node2 = node3;
                node3 = node3.next;
                node2.next = node1;
            }

            start = node2;
        }
    }

    @Override
    public String toString() {
        if(start == null){
            return "";
        }

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(start.value.toString());
        ListNode node = start.next;
        while (node != null) {
            stringBuffer.append(" " + node.value.toString());
            node = node.next;
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        LinkedObjectList l = new LinkedObjectList();
        l.add("hi");
        l.add("world");
        l.add("aaa");
        l.add("bbb");
        l.add("ccc");
        l.add("fff");
        l.add("ddd");
        l.add("sss");
        //l.reverse();
        System.out.println(l);
        l.reverse();
        System.out.println(l);
    }
}
