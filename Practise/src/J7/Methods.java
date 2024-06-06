package J7;

public class Methods {
    public static int myGlobal = 5;
    private static void boo(){
        System.out.println("Boo!");
    }

    private static int add(int a, int b){
        int x = 10;
        return a+b;
    }

    public static void main(String[] args) {
        System.out.println(myGlobal);
        System.out.println("main method");
        boo();

        System.out.println("back to main");

        int x = 12;
        int c = add(x,6);
        System.out.println();
        System.out.println("c: "+c);
        System.out.println("x: "+x);
    }
}
