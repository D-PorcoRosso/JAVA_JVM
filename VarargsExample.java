import java.util.*;

public class VarargsExample {
    private static void StrangeTest() {
        int[] digits = {1,2,3,4,5};
        System.out.println(Arrays.asList(digits));
        System.out.println(Arrays.toString(digits));
    }

    private static int minTooUgly(int... args) {
        if ( args.length == 0 ) 
            throw new IllegalArgumentException();
        int min = args[0];
        for ( int i = 0 ; i < args.length ; i++ ) 
            if ( min > args[i] ) 
                min = args[i];
        return min;
    }

    private static int minBeauty(int firstArg, int... args) {
        int min = firstArg;
        for ( int arg : args ) 
            if ( min > arg ) 
                min = arg;
        return min;
    }

    private static void testVarargsHeapPollution(List<String>... args) {
        Object[] array = args;
        List<Integer> tmp = Arrays.asList(1);
        array[0] = tmp;
        String temp = args[0].get(0);
    }

    public static void main(String[] args) {
        StrangeTest();
        int[] test = {1,2,3,4,5};
        System.out.println(minBeauty(test[0],test));

        List<String> list1 = new ArrayList<>(); 
        list1.add("list1");
        List<String> list2 = new ArrayList<>();
        list2.add("list2");
        testVarargsHeapPollution(list1, list2);
    }
}