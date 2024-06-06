package J15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exceptions {
    public static void throwException1(){
        try{
            int errorArithmetic = 1/0;
            String str = null;
            str.length();
        }
        catch (NullPointerException e){
            System.out.println("null point detected");
            e.printStackTrace();
        }
        catch (ArithmeticException e){
            System.out.println("divided by zero" + e.toString());
            e.printStackTrace();
        }
        finally {
            System.out.println("always run");
        }
    }

    /**
     * no try catch
     */
    public static void throwException2() {

        String str = null;
        str.length();
        int errorArithmetic = 1 / 0;
    }

    /**
     * load file
     */
    public static void loadFile() throws FileNotFoundException {
        File file = new File("this is a error path");
        Scanner scanner = new Scanner(file);
        int errorArithmetic = 1/0;
    }

    /**
     * in the e, there has the error information, we can sout(e) or e.printStackTrace
     * @param args
     */
    public static void main(String[] args) {
        try{
            throwException2();
        }
        catch (NullPointerException e){
            System.out.println("main-null point detected");
            e.printStackTrace();
        }
        catch (ArithmeticException e){
            System.out.println("main-divided by zero"+ e.toString());
            e.printStackTrace();
        }
        finally {
            System.out.println("main-always run");
        }

        //load file
        try{
            loadFile();
        }
        catch (FileNotFoundException e){
            System.out.println("main-File not found " + e.toString());
            e.printStackTrace();
        }
    }
}
