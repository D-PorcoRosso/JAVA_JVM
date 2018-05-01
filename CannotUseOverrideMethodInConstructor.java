import java.util.Date;

public class CannotUseOverrideMethodInConstructor {

    public class Super {
        public Super() {
            overrideMe();
        }
        public void overrideMe() {

        }
    }

    public final class sub extends Super {
        private final Date date;
        sub() {
            date = new Date();
        }

        @Override
        public void overrideMe() {
            System.out.println(date);
        }
    }

    public static void main(String[] args) {
        CannotUseOverrideMethodInConstructor.sub sub = (new CannotUseOverrideMethodInConstructor()).new sub();
        sub.overrideMe();
    }

}