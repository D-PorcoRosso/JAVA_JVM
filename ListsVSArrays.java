import java.util.*;

public class ListsVSArrays {

    public void example() {
        Object[] objects = new Long[1];
        // runtime exception Exception in thread "main" java.lang.ArrayStoreException: java.lang.String
        objects[0] = "build pass";

        //compile error incompatible types: ArrayList<Long> cannot be converted to List<Object>
        //List<Object> objectList = new ArrayList<Long>();
    }

    public void createError() {
        // compile error generic array creation
        //List<String>[] list = new List<String>[3];
        //E[] e = new List<String>[3];

    }

    public <E> void notice(List<E> list) {
        // compile error ListsVSArrays.java:22: error: incompatible types: Object[] cannot be converted to E[]
        //E[] snapshot = list.toArray();
        // warning ListsVSArrays.java:25: warning: [unchecked] unchecked cast
        //E[] snapshot = (E[])list.toArray();
        // collect way
        List<E> snapshot = new ArrayList<E>(list);
    }

    public static void main(String[] args) {
        ListsVSArrays example = new ListsVSArrays();
        List<String> temp = new ArrayList<>();
        example.notice(temp);
    }
}