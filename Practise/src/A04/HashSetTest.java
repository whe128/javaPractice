package A04;

import A03.ArrayListSet;
import A03.Set;
import A03.SetTests;

public class HashSetTest extends SetTests {
    @Override
    public <T extends Comparable<T>> Set<T> createEmptySet() {
        return new ArrayListSet<>();
    }
}
