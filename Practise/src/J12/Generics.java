package J12;

public class Generics {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("abc");
        strings.add("def");
        strings.add("ghi");
        strings.add("jkl");

        //must the subClass of Object, we can use Object class to
        //because we don't know the specif type of the class, so we cannot store the value into the list
        //we can just read, and use the method in Object
        List<? extends Object> subObjects = strings;
        for (int i = 0; i < subObjects.size(); i++) {
            System.out.println(subObjects.get(i));
        }


        List<Object> objects = new ArrayList<>();

        //must be the super Class of String,
        //system just look them as the object, then
        //we can only add element into the list
        List<? super String> upperString = objects;
        objects.add("Hello");
        objects.add("abc");
        objects.add("def");
        objects.add("ghi");
        objects.add("jkl");

    }
}
