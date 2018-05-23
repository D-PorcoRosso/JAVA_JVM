public enum EnumExample {
    A,
    B,
    C,
    D;
    // Do the arithmetic op represented by this constant
    double apply(double x, double y) {
        switch(this) {
            case A:   return x + y;
            case B:  return x - y;
            case C:  return x * y;
            case D: return x / y;
        }
        throw new AssertionError("Unknown op: " + this);
    }
}