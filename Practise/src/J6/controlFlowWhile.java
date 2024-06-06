package J6;

public class controlFlowWhile {
    public static void main(String[] args) {
        int i=1;
        while(i<3){
            System.out.println("current i = "+i);
            i++;
        }

        int j=3;
        do{
            System.out.println("current j = "+j);
            j++;
        }while(j<3);

    }
}
