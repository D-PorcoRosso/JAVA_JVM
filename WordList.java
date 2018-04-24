import java.math.BigDecimal;
import java.util.*;

public class WordList {

    private void testEquals() {
        BigDecimal x = new BigDecimal("2.0");
        BigDecimal y = new BigDecimal("2.00");
        BigDecimal z = new BigDecimal(2.0);
        BigDecimal a = new BigDecimal(2.00);
        System.out.println(x.equals(y));  
        System.out.println(x.compareTo(y));
        System.out.println(z.equals(a));  
        System.out.println(z.compareTo(a));
        System.out.println(z.equals(x));  
        System.out.println(z.compareTo(x));
    }

    public static void main(String[] args) {
        Set<String> s = new TreeSet<String>();
        Collections.addAll(s, args);
        System.out.println(s);
        WordList w = new WordList();
        w.testEquals();
    }
}