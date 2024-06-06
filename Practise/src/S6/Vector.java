package S6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vector {
    public static class Point2D{
        int x;
        int y;
        public Point2D(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    // Review:
    // - shallow module, should not make in the function
    //   - If used a lot in by single method then consider a local lambda expression
    // - Comments are repeating the code
    // - Bad variable names and method name please make more descriptive
    // - Perhaps add a check for y != 0
    public static int operate(int x, int y, int z){
        return (x-z)/y;
    }

    /**
     * multiply each corresponding element, and add all to sum
     * @param xs
     * @param ys
     * @return
     */
    public static int dotProduct(int[] xs, int[] ys){
        if(xs==null || ys ==null){
            throw new NullPointerException("the array is null");
        }
        if(xs.length!= ys.length){
            throw new IllegalArgumentException("the length of two vector are not same");
        }
        int sum = 0;
        for(int i=0;i<xs.length;i++){
            sum+=xs[i]*ys[i];
        }
        return sum;
    }

    /**
     * get the median of the array, the middle num, the length must be greater than 2
     * Side effect of sorting array is not documented. Or make a copy and sort the copy
     * @param array
     * @return
     */
    public static double median(double[] array){
        if(array.length <2){
            throw new IllegalArgumentException("Array must have the length of at least 2");
        }
        Arrays.sort(array);
        int middleIndex = array.length/2;
        if (array.length % 2 == 0) {
            return (array[middleIndex-1]+array[middleIndex])/2.0;
        }
        else {
            return array[middleIndex];
        }
    }

    //use the recursion to complete the rollingtally
    public static List<Integer> rollingTally(List<Integer> list){
        if(list.size()<=1){
            return list;
        }
        else {
            List<Integer> accumList = rollingTally(list.subList(0, list.size()-1));
            accumList.add(accumList.get(accumList.size()-1)+list.get(list.size()-1));
            return accumList;
        }
    }

    public static void main(String[] args) {
        int[] a={1,2,8};
        int[] b={4,5,8};
        System.out.println(dotProduct(a,b));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(rollingTally(list));
    }
}
