import java.math.BigDecimal;
import java.math.BigInteger;

public class CheckBigIntegerAndBigDecimal {

    public static checkBigInteger(BigInteger val) {
        if ( val.getClass() != BigInteger.class ) 
            return new BigInteger(val.toByteArray());
        return val;
    }

    public static checkBigDecimal(BigDecimal val) {
        if ( val.getClass() != BigDecimal.class ) 
            return new BigDecimal(val.toByteArray());
        return val;
    }
}