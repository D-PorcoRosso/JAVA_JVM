import java.util.*;

public class HashCodeTest {
    static final class PhoneNumber {
        private final short areaCode;
        PhoneNumber(int areaCode) {
            this.areaCode = (short) areaCode;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof PhoneNumber))
                return false;
            PhoneNumber pn = (PhoneNumber)o;
            return pn.areaCode == this.areaCode;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + areaCode;
            
            return result;
        }
    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(new PhoneNumber(111),"Jenny");
        System.out.println("this will get null:" + m.get(new PhoneNumber(111)));
    }
}