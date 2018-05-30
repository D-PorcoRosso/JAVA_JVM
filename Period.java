import java.util.*;

public final class Period {
    //就算Date的field是final了，還是可以修改到Date裡面值造成破壞
    private final Date start;
    private final Date end;
    /**
    * @param start the beginning of the period
    * @param end the end of the period; must not precede start
    * @throws IllegalArgumentException if start is after end
    * @throws NullPointerException if start or end is null
    */
    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException(start + " after " + end);
        this.start = start;
        this.end = end;
    }

    public Period(Date start, Date end, boolean isSafe) {
        /*要注意到defensive的動作是在檢查之前，檢查也是針對copy後的對象，而不是原始物件，
        這也可以避免別的Thread在constructor建構開始到檢查前去對要被檢查的物件作修改
        (Time-Of-Check/Time-Of-Use/TOCTOU攻擊)。
        另外，我們也沒有使用Date的clone來進行複製，因為Date不是final，所以如果用clone去複製
        可能不一定是同一個該java.util.Date的class，有可能是有惡意的subclass。所以如果是defensive copy
        的情況下，不能使用clone來進行複製，constructor有支援用constructor，如果沒有可能需要考慮自己手動作copy。
        */
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0)
            throw new IllegalArgumentException(this.start + " after " + this.end);
    }

    /*
    這兩個也可能會被攻擊，請見attackTwo()
     */
    public Date start() {
        return start;
    }
    public Date end() {
        return end;
    }

    /*
    最好在這種會return內部物件的也是採用defensive copy的object出去。
    這邊也可以使用Date的clone，因為在這個class裡是可以確定這個return Date是java.util.Date的instance
    有關clone注意事項，可以參考item 11
     */
    public Date startSafe() {
        return new Date(start.getTime());
    }
    public Date endSafe() {
        return new Date(end.getTime());
    }
    
    public boolean isValidate() {
        System.out.println(start.getTime()+":"+end.getTime());
        if ( end.getTime() - start.getTime() > 1000 ) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        attackOne();
        attackTwo();
    }

    public static void attackOne() {
        Date start = new Date(System.currentTimeMillis());
        Date end = new Date(System.currentTimeMillis());
        Period period_notsafe = new Period(start, end);
        System.out.println(period_notsafe.isValidate());
        long currentTime = System.currentTimeMillis();
        end.setTime(currentTime+2000);
        System.out.println(period_notsafe.isValidate());

        Date start2 = new Date(System.currentTimeMillis());
        Date end2 = new Date(System.currentTimeMillis());
        Period period_safe = new Period(start2, end2, true);
        System.out.println(period_safe.isValidate());
        currentTime = System.currentTimeMillis();
        end2.setTime(currentTime+2000);
        System.out.println(period_safe.isValidate());
    }

    public static void attackTwo() {
        Date start2 = new Date(System.currentTimeMillis());
        Date end2 = new Date(System.currentTimeMillis());
        Period period_safe = new Period(start2, end2, true);
        System.out.println(period_safe.isValidate());
        long currentTime = System.currentTimeMillis();
        end2.setTime(currentTime+2000);
        System.out.println(period_safe.isValidate());

        // safe mode
        period_safe.endSafe().setTime(currentTime+10000);
        System.out.println(period_safe.isValidate());

        period_safe.end().setTime(currentTime+10000);
        System.out.println(period_safe.isValidate());
    }
}