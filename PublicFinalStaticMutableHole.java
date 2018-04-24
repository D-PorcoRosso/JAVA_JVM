import java.math.BigDecimal;
import java.util.*;

public class PublicFinalStaticMutableHole {

    public static final String[] wrongWay = {"a","b"};
    
    private static final String[] correctWay = {"a", "b"};
    public static final List<String> CORRECT_WAY_1 
        = Collections.unmodifiableList(Arrays.asList(correctWay));
    public static final String[] CORRECT_WAY_2() {
        return correctWay.clone();
    }

    private void testEquals() {
        for ( String v : wrongWay )
            System.out.println(v);  
    }

    public static void main(String[] args) {
        PublicFinalStaticMutableHole w = new PublicFinalStaticMutableHole();
        w.testEquals();
        PublicFinalStaticMutableHole.wrongWay[0] = "c";
        PublicFinalStaticMutableHole.wrongWay[1] = "d";
        w.testEquals();
    }
}