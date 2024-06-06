package O3;

public class PoisonFrog implements Toxic{
    @Override
    public boolean isDangerous() {
        return true;
    }

    @Override
    public String toString() {
        return "poisonFrog: ";
    }
}
