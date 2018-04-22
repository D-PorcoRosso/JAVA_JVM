import java.util.EmptyStackException;
import java.util.*;

public class MemLeakSample {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT = 10;

    public MemLeakSample() {
        elements = new Object[DEFAULT];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object popLeak() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }

    public Object popNotLeak() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2*size+1);
    }

    public static void main(String[] args) {
        MemLeakSample memNotLeakSample = new MemLeakSample();
        for ( int i = 0 ; i < 16 ; i++ ) {
            memNotLeakSample.push(new Object());
        }
        for ( int i = 0 ; i < 16 ; i++ ) {
            memNotLeakSample.popNotLeak();
        }

        MemLeakSample memLeakSample = new MemLeakSample();
        for ( int i = 0 ; i < 16 ; i++ ) {
            memLeakSample.push(new Object());
        }
        for ( int i = 0 ; i < 16 ; i++ ) {
            memLeakSample.popLeak();
        }
    }
}