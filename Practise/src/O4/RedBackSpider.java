package O4;

import O3.Toxic;

public class RedBackSpider extends Insect implements Toxic{

    public RedBackSpider(String name, int age) {
        super(name, age);
    }

    @Override
    public boolean isDangerous() {
        return false;
    }
}
