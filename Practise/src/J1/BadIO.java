package J1;

import java.util.Scanner;

public class BadIO {
    public static void main(String[] args) {
        //use scanner to input
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(x +" * " +x +" = " +(x*x));
    }
}
