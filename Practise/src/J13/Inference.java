package J13;

import J12.ArrayList;
import J12.LinkedList;
import J12.List;

import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Inference {
    public static <T> T id(T t){
        return t;
    }
    public static <T> List<T> singleton(T t){
        List<T> r = new LinkedList<>();
        r.add(t);
        return r;
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        String a = "Hello";
        String b = id(a);           //generic is String
        int c = id(16);         //generic is  Integer
        double d = id(15.6);    //generic is double

        //a function I->D from integer to double
        //like the lambada expression use { }
        //like the lambada statement use just one line
        Function<Integer, Double> function = x-> x/(0.5);
        System.out.println("after being divided by 0.5, get :"+ function.apply(5));


        //string to integer function, calculate how manu uppercase letter in the string
        Function<String, Integer> stringFunction = s-> {
            int uppercaseNum = 0;
            for (int i = 0; i < s.length(); i++) {
                if(Character.isUpperCase(s.charAt(i))){
                    uppercaseNum++;
                }
            }
            return uppercaseNum;
        };
        System.out.println("uppercase letter num has: "+stringFunction.apply("heLLO woRld"));


        //predicate is the special case of function. A->Boolean, we can only return true or false
        Function<Integer,Boolean> predicateFunction = x->(x>0);
        System.out.println("function int to bool: "+ predicateFunction.apply(10));

        //the predicate, we should use test
        Predicate<Integer> predicate = x->(x>0);
        System.out.println("normal predicate(Integer): "+ predicate.test(10));

        //the IntPredicate, we can only return true or false in the predicate
        IntPredicate intPredicate = x->{
            return x>0;
        };
        System.out.println("IntPredicate: "+ predicate.test(10));
    }
}
