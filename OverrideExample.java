import java.util.*;

public class OverrideExample {

    public static class Wine{
        String name() { return "wine";}
    }

    public static class SparklingWine extends Wine{
        @Override String name() { return "sparkling wine";}
    }

    public static class Champagne extends SparklingWine{
        String name() { return "champagne";}
    }

    public static void main( String[] args ) {
        Wine[] wines = {
            new Wine(),
            new SparklingWine(),
            new Champagne()
        };
        for ( Wine w : wines ) {
            System.out.println(w.name());
        }
    }
}