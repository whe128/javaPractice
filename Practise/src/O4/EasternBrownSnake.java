package O4;

import O3.Toxic;

public class EasternBrownSnake extends Reptile implements Toxic {
    public EasternBrownSnake(String name, int age) {
        super(name, age);
    }

    @Override
    public boolean isDangerous() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString()+" NO REALLY - BEWARE!";
    }
}
