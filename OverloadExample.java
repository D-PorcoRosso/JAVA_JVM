import java.util.*;

public class OverloadExample {

    public static String Classify( Set<?> s ) {
        return "Set";
    }

    public static String Classify( List<?> list ) {
        return "List";
    }

    public static String Classify( Collection<?> c ) {
        return "Unknown Collection";
    }

    public static String ClassifyEnhance ( Collection<?> c ) {
        return c instanceof Set ? "Set" : c instanceof List ? "List" : "Unknown Collection";
    }

    public static void main( String[] args ) {
        Collection<?>[] collection = {
            new HashSet<String>(),
            new ArrayList<String>(),
            new HashMap<String, String>().values()
        };
        for ( Collection<?> c : collection ) {
            System.out.println(Classify(c));
        }
        for ( Collection<?> c : collection ) {
            System.out.println(ClassifyEnhance(c));
        }
        setTest();
    }

    public static void setTest() {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        for ( int i = -3 ; i < 3 ; i++ ) {
            set.add(i);
            list.add(i);
        }
        for ( int i = 0 ; i < 3 ; i++ ) {
            set.remove(i);
            list.remove(i);
            /*
            list有remove(int index)
            remove(Object o) */
        }
        System.out.println(set+ " "+ list);
    }
}