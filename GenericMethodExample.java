
public class GenericMethodExample {

    private static UnaryFunction<Object> IDENTITY_FUNCTION = new UnaryFunction<Object>() {
        @Override
        public Object apply(Object arg) {return arg;}
    };

    @SuppressWarnings("unchecked")
    public static <T> UnaryFunction<T> identityFunction() {
        return (UnaryFunction<T>) IDENTITY_FUNCTION;
    }

    public static void main(String[] args) {
        String[] strings = {"a","b","c"};
        UnaryFunction<String> temp = identityFunction();
        for ( String s : strings)
            System.out.println(temp.apply(s));
    }

}