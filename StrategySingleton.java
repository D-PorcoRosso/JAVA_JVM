public class StrategySingleton {
    private StrategySingleton() {}
    public static final StrategySingleton INSTANCE = new StrategySingleton();

    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}