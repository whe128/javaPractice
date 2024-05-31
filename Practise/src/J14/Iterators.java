package J14;

public class Iterators {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("world");

        for (String str: strings){
            System.out.println(str);
        }

    }
}
