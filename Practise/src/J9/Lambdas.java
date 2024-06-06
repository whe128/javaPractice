package J9;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Lambdas {
    public static void checkLarge(int i,Predicate<Integer> predicate){
        if(predicate.test(i)){
            System.out.println("i is bigger");
        }
        else {
            System.out.println("i is smaller");
        }
    }

    public static void main(String[] args) {
        checkLarge(10,x-> x > 6);
        checkLarge(10,x-> x > 6);
        //int predicate
        IntPredicate intPredicate = i->(i>100);
        System.out.println(intPredicate.test(50)?"IntPredicate: large":"IntPredicate: small");
        Predicate<Integer> evenPredicate = e->(e%2==0);
        System.out.println((evenPredicate.test(51))?"eventPredicate: even":"evenPredicate: odd");
        //string predicate
        Predicate<String> stringPredicate = s->{
            for(char ch:s.toCharArray()){
                if(Character.isUpperCase(ch)){
                    return true;
                }
            }
            return false;
        };
        System.out.println((stringPredicate.test("hello world")?"stringPredicate: contain uppercase letter":"string Predicate: not contain uppercase letter"));
    }
}
