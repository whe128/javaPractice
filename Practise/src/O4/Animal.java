package O4;

import O3.Toxic;

public class Animal {
    String name;
    int age;
    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" "+name+", aged "+age+(this instanceof Toxic ?(((Toxic) this).isDangerous()?" - it's dangerous!":" - it's inconvenient!"):"");
    }
}
