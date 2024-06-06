package J10;

public class Boxing {
    public static void main(String[] args) {
        Integer i = new Integer(6); //create a new object of Integer
        Integer j = 6; //automatically boxing. equivalent to Integer.valueOf(6)
        Integer h = 6; //automatically boxing. equivalent to Integer.valueOf(6)
        int k = 6;

        //i and j are different instance
        if (i == j) {
            System.out.println("i == j");
        } else {
            System.out.println("i <> j");
        }

        //i and j are different instance
        if (i.equals(j)) {
            System.out.println("i equals j");
        } else {
            System.out.println("i <>not equals j");
        }

        //when comparing, they are unboxed
        if (j == h) {
            System.out.println("j == h");
        } else {
            System.out.println("j <> h");
        }

        //this works because we automatically unbox the boxed value when comparing it to a primitive
        if (j == k) {
            System.out.println("j == k");
        } else {
            System.out.println("j <> k");
        }

        //
        j = 128;    //one integer with the value 128
        h = 128;    //another integer with the value 128
        //boxing and unboxing, the range of value is -128 to 127, they are all the same object
        //the value is stored in the buffer
        //when the value exceeds the range, they will become the different object
        if (j == h) {
            System.out.println("j == h");
        } else {
            System.out.println("j <> h");
        }

        if (j.equals(h)) {
            System.out.println("j equals h");
        } else {
            System.out.println("j <>not equals h");
        }
    }

}
