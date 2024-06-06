package O2;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        System.out.println("please guess the num, input and enter");
        Random random = new Random();
        int guessNum = random.nextInt(100);
        Scanner scanner = new Scanner(System.in);
        int inputNum = scanner.nextInt();
        while(guessNum!=inputNum){
            if(guessNum>inputNum){
                System.out.println("small, input again");
            }
            else {
                System.out.println("big, input again");
            }
            inputNum = scanner.nextInt();
        }
        System.out.println("you guess is correct!");
    }
}
