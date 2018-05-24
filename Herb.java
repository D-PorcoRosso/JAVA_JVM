import java.util.*;

public class Herb {
    public enum Type { ANNUAL, PERENNIAL, BIENNIAL }
 
    private final String name;
    private final Type type;
 
    Herb(String name, Type type) {
       this.name = name;
       this.type = type;
    }
 
    @Override public String toString() {
       return name;
    }

    public static void main(String[] args) {
        // Using ordinal() to index an array - DON'T DO THIS!
        Herb[] garden = new Herb[2] ;
        Herb a = new Herb("test1", Herb.Type.ANNUAL);
        Herb b = new Herb("test2", Herb.Type.PERENNIAL);
        garden[0] = a;
        garden[1] = b;

        // Indexed by Herb.Type.ordinal()
        Set<Herb>[] herbsByType = (Set<Herb>[]) new Set[Herb.Type.values().length];

        for (int i = 0; i < herbsByType.length; i++)
            herbsByType[i] = new HashSet<Herb>();

        for (Herb h : garden)
            herbsByType[h.type.ordinal()].add(h);

        // Print the results
        for (int i = 0; i < herbsByType.length; i++) {
            System.out.printf("%s: %s%n", Herb.Type.values()[i], herbsByType[i]);
        }

        // Using an EnumMap to associate data with an enum
        Map<Herb.Type, Set<Herb>> herbsByTypeMap = new EnumMap<Herb.Type, Set<Herb>>(Herb.Type.class);

        for (Herb.Type t : Herb.Type.values())
            herbsByTypeMap.put(t, new HashSet<Herb>());

        for (Herb h : garden)
            herbsByTypeMap.get(h.type).add(h);

        System.out.println(herbsByTypeMap);
    }
 }