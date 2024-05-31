package A03;

public class ArrayListSetTests extends SetTests{
    @Override
    public <T extends Comparable<T>> Set<T> createEmptySet() {
        return new ArrayListSet<>();
    }
}
