import java.util.*;
// Using a nested EnumMap to associate data with enum pairs
public enum PhaseDo {
    SOLID, LIQUID, GAS;
 
    public enum Transition {
       MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
       BOIL(LIQUID, GAS),   CONDENSE(GAS, LIQUID),
       SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);
 
       final PhaseDo src;
       final PhaseDo dst;
 
       Transition(PhaseDo src, PhaseDo dst) {
          this.src = src;
          this.dst = dst;
       }
 
       // Initialize the phase transition map
       private static final Map<PhaseDo, Map<PhaseDo,Transition>> m = new EnumMap<PhaseDo, Map<PhaseDo,Transition>>(PhaseDo.class);
 
       static {
          for (PhaseDo p : PhaseDo.values())
             m.put(p,new EnumMap<PhaseDo,Transition>(PhaseDo.class));
 
          for (Transition trans : Transition.values())
             m.get(trans.src).put(trans.dst, trans);
       }
 
       public static Transition from(PhaseDo src, PhaseDo dst) {
          return m.get(src).get(dst);
       }
    }

    public static void main(String[] args) {
        System.out.println(PhaseDo.Transition.from(SOLID,GAS));
    }
 }