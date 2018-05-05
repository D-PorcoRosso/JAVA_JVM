import java.util.AbstractSet;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
        class test {
            public void t() {
                System.out.println("ttt");
            }
        }


        List<String> input = new ArrayList<>();
        input.add("aaa");
        input.add("aaatest");
        input.add("test");
        List<String> out = new ArrayList<>();
        for ( String s : input ) {
            if ( s.equalsIgnoreCase("test")) {
                out.add(s);
                System.out.println("1:"+s);
            }
        }

        Predicate<String> matched = s -> s.equalsIgnoreCase("test");
        List<String> out1 = input.stream().filter(matched).collect(Collectors.toList());
        for ( String s : out1 ) 
            System.out.println(s);

        List<String> out2 = input.stream().filter(s -> s.equalsIgnoreCase("test")).collect(Collectors.toList());
        for ( String s : out2 ) 
            System.out.println(s);
        new test().t();
    }
}
