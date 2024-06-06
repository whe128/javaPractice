package J1;

import java.util.Scanner;

public class BasicIO {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println("Hello "+s);
        System.out.println("Please write a number");
        int x = scanner.nextInt();
        System.out.println(x +" * " +x +" = " +(x*x));
    }
}
