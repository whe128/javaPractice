package A0Myself;

import java.util.*;

public class testSetContain  {
    /**
     * first create the location class
     */
    static class Location  {
        int row;
        int col;

        public Location(int row, int col){
            this.row = row;
            this.col = col;
        }

        Location[] getAdjacentLocation(){
            Location[] adjacentLocation  = new Location[4];
            adjacentLocation[0] = new Location(row-1,col);
            adjacentLocation[1] = new Location(row,col-1);
            adjacentLocation[2] = new Location(row+1,col);
            adjacentLocation[3] = new Location(row,col+1);
            return adjacentLocation;
        }

        boolean isOnboard(int sizeRow, int sizeCol){
            return row >= 0 && row < sizeRow && col >= 0 && col < sizeCol;
        }

        @Override
        public String toString() {
            return "["+ row+", "+ col + "]";
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof  Location){
                Location location = (Location) obj;

                return row==location.row && col==location.col;
            }
            return false;
        }

//        @Override
//        public int compareTo(Location o) {
//            if(row<o.row){
//                return -1;
//            }
//            else if(row==o.row){
//                if(col<o.col){
//                    return -1;
//                }
//                else if(col==o.col){
//                    return 0;
//                }
//                else {
//                    return 1;
//                }
//            }
//            else {
//                return 1;
//            }
//        }

        //if we want to judge the different instance but with the same priority,
        //whether the set contains this instance, we should let them with the same hashCode and override the equals function

        @Override
        public int hashCode() {
            return row*31+col;
        }
    }
    static class Node{
        char value;
        Location location;
        public Node(char value,Location location){
            this.value = value;
            this.location = location;
        }

        @Override
        public String toString() {
            return "node "+ location.toString() ;
        }
    }

    public static void main(String[] args) {
        //TreeSet<Location> visitTreeSet = new TreeSet<>();
        HashSet<Location> visitHashSet = new HashSet<>();
        ArrayList<Location> visitList = new ArrayList<>();
        String[] strings = {"XTLM","EROE","HTAI","NPTT"};
        Node[][] nodes = new Node[4][4];
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                nodes[row][col] = new Node(strings[row].charAt(col), new Location(row,col));
                //visitTreeSet.add(nodes[row][col].location);
                visitHashSet.add(nodes[row][col].location);
                visitList.add(nodes[row][col].location);
            }
        }




        //visitList.sort(null);
        System.out.println("visited: " + visitList);

        //in the set, they judge the hashcode and priority(equal function) of twe object
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                Node node = nodes[row][col];
                Location[] adjacentLocation = node.location.getAdjacentLocation();
                System.out.print(node+"\nHashSet Contains:");
                for(Location l:adjacentLocation){
                    if(l.isOnboard(4,4)){
                        //use the set, different reference with the same priority does also not contain
                        System.out.print("  "+l+":"+((visitHashSet.contains(l))?"true ":"false"));
                    }
                }
                System.out.print("\nTreeSet Contains:");
                for(Location l:adjacentLocation){
                    if(l.isOnboard(4,4)){
                        //use the set, different reference with the same priority does also not contain
                        //System.out.print("  "+l+":"+((visitTreeSet.contains(l))?"true ":"false"));
                    }
                }
                System.out.print("\nList    Contains:");
                for(Location l:adjacentLocation){
                    if(l.isOnboard(4,4)){
                        //use the set, different reference with the same priority does also not contain
                        System.out.print("  "+l+":"+((visitList.contains(l))?"true ":"false"));
                    }
                }

                System.out.println();
            }
        }



        for(Location l:nodes[1][1].location.getAdjacentLocation()){
            System.out.println(l);
        }
    }
}
