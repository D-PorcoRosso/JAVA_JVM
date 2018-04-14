import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class UnnecessaryObjects {
    private final Date birthDate;

    private static final Date DOTHISBOOM_START;
    private static final Date DOTHISBOOM_END;

    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY , 1, 0, 0, 0);
        DOTHISBOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY , 1, 0, 0, 0);
        DOTHISBOOM_END = gmtCal.getTime();
    }

    public UnnecessaryObjects(Date date) {
        birthDate = date;
    }

    public boolean isBabyBoomerDONTDOIT() {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY , 1, 0, 0, 0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY , 1, 0, 0, 0);
        Date boomEnd = gmtCal.getTime();
        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
    }

    public boolean isBabyBoomerDOTHIS() {
        return birthDate.compareTo(DOTHISBOOM_START) >= 0 && birthDate.compareTo(DOTHISBOOM_END) < 0;
    }

    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();
        UnnecessaryObjects o = new UnnecessaryObjects(new Date());
        for ( int i = 0 ; i < 10000000 ; i++ )
            o.isBabyBoomerDONTDOIT();
        long diffTime = System.currentTimeMillis() - currentTime;
        System.out.println("Don't do this:"+diffTime);

        currentTime = System.currentTimeMillis();
        for ( int i = 0 ; i < 10000000 ; i++ )
            o.isBabyBoomerDOTHIS();
        diffTime = System.currentTimeMillis() - currentTime;
        System.out.println("Don this:"+diffTime);
    }
}