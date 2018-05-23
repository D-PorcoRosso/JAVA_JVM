public class EnumExampleMain {
    public static void main(String[] args) {
        for ( EnumExample temp : EnumExample.values() )
            System.out.println(temp);

        double earthWeight = 10.0;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for ( Planet t : Planet.values() ) {
            System.out.println("weight on "+t+" is "+t.surfaceWeight(mass));
        }

        System.out.println(PayrollDay.FRIDAY.pay(8, 1.5));
    }
}