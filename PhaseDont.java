// Using ordinal() to index array of arrays - DON'T DO THIS!
public enum PhaseDont { SOLID, LIQUID, GAS;
    public enum Transition {
       MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;
 
       // Rows indexed by src-ordinal, cols by dst-ordinal
       private static final Transition[][] TRANSITIONS = {
          { null,    MELT,     SUBLIME },
          { FREEZE,  null,     BOIL    },
          { DEPOSIT, CONDENSE, null    }
       };
 
       // Returns the phase transition from one phase to another
       public static Transition from(PhaseDont src, PhaseDont dst) {
          return TRANSITIONS[src.ordinal()][dst.ordinal()];
       }
    }

    public static void main(String[] args) {
        System.out.println(PhaseDont.Transition.from(SOLID,GAS));
    }
 }