package A05;

import A03.Set;
import A03.SetTests;

public class BSTreeSetTests extends SetTests {
    @Override
    public <T extends Comparable<T>> Set<T> createEmptySet() {
        return new BSTreeSet<>();
    }
}
