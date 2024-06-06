package O3;

public class Interfaces {
    public static void main(String[] args) {
        Spider spider = new Spider();
        PoisonFrog poisonFrog = new PoisonFrog();
        Dog dog = new Dog();

        Object[] objects = new Object[3];
        objects[0] = spider;
        objects[1] = poisonFrog;
        objects[2] = dog;

        //use the interface to create the object
        Toxic[] toxics = new Toxic[2];
        toxics[0] = new Spider();
        toxics[1] = new PoisonFrog();
        for (Toxic t:toxics){
            System.out.println(t+(t.isDangerous()?" is dangerous!":" is toxic but ok!"));
        }

        for(Object o:objects){
            if(o instanceof Toxic){
                Toxic toxic = (Toxic) o;
                System.out.println(toxic+(toxic.isDangerous()?" is dangerous!":" is toxic but ok!"));
            }
            else {
                System.out.println(o+" "+"is nice!");
            }
        }

    }
}
