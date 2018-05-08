import java.util.*;

public class GenericExample {


    public void doNotDoThis() {
        //don't do this, we hope compiler can find code error as soon as possible. this situation won't
        //be detect error on compile time, but will crash on run time
        Collection temp = new ArrayList<String>();
        temp.add(123);

        for ( Iterator i = temp.iterator(); i.hasNext(); ) {
            String s = (String)i.next();
            System.out.println(s);
        }
    }

    public void thisWillCauseRuntimeError() {
        Collection<String> temp = new ArrayList<String>();
        //temp.add(123);

        for ( Iterator i = temp.iterator(); i.hasNext(); ) {
            String s = (String)i.next();
            System.out.println(s);
        }
    }

    public void objectDifferenceWithRawtype() {
        class temp {
            final private int i;
            temp(int input) {
                i = input;
            }
        }

        class tempToString {
            final private int i;
            tempToString(int input) {
                i = input;
            }
            @Override
            public String toString() {
                return "tempToString{" +
                        "i=" + i +
                        '}';
            }
        }

        List<Object> a = new ArrayList<>();
        List<String> s = new ArrayList<>();
        //a = s; // compile error
        a.add("String");
        a.add(11);
        a.add(new temp(5));
        a.add(new tempToString(5));
        for ( Object o : a ) {
            System.out.println(o);
        }
    }

    public void testWildCard() {
        List<String> strings = new ArrayList<>();
        unsafeAddWildCard(strings, new Integer(4));
        String s = strings.get(0);
        System.out.println(s);
    }
    private void unsafeAdd(List list, Object o) {
        list.add("o");
    } 

    private void unsafeAddWildCard(List<?> list, Object o) {
        //compile error,argument mismatch; Object cannot be converted to CAP#1
        //list.add(o);
        //only can put null
        list.add(null);
    } 

    public void classLiteral() {
        Class c = List.class;
        c = String[].class;
        //compile error
        //c = List<String>.class;
        //c = List<?>.class;
    }

    public void instanceifOnGenericTypes() {
        List<String> s = new ArrayList<>();

        //compile error
        //if ( s instanceof ArrayList<String> ) {
        if ( s instanceof ArrayList<?> ) {
            System.out.println("s is instanceof ArrayList<?>");
        }
        if ( s instanceof ArrayList ) {
            System.out.println("s is instanceof ArrayList");
        }
    }

    public static void main(String[] args) {
        GenericExample example = new GenericExample();
        example.testWildCard();
    }
}