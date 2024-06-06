package J5;

import java.util.Scanner;

public class controlFlowSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input a number, 0~4");
        int i = scanner.nextInt();

        switch (i) {
            case 0:
                System.out.println("it is 0");
                break;
            case 1:
                System.out.println("it is 1");
                break;
            case 2:
                System.out.println("it is 2");
                break;
            case 3:
                System.out.println("it is 3");
                break;
            case 4:
                System.out.println("it is 4");
                break;
            default:
                System.out.println("input error");
        }
    }
}
