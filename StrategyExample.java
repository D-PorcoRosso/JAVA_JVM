public class StrategyExample {

    private static final StrategyInterface<Integer> EXAMPLE = new IntComparator();

    public interface StrategyInterface<T> {
        public int compare(T t1, T t2);
    }

    static class IntComparator implements StrategyInterface<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i1 - i2;
        }
    }

    public static void main(String[] args) {
        //normal
        IntComparator intComparator = new IntComparator();
        System.out.println(intComparator.compare(1,3));
        //inner class
        System.out.println(new IntComparator().compare(1,2));
        //private static final
        System.out.println(EXAMPLE.compare(1,2));
    }
}
