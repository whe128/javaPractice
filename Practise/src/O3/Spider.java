package O3;

public class Spider implements Toxic{
    @Override
    public boolean isDangerous() {
        return false;
    }

    @Override
    public String toString() {
        return "spider: ";
    }
}
