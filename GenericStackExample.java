import java.util.EmptyStackException;
import java.util.*;

public class GenericStackExample {

    static class myStack1 {
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_SIZE = 16;
      
        myStack1() {
            elements = new Object[DEFAULT_SIZE];
        }

        public void push( Object e ) {
            ensureCapacity();
            elements[size++] = e;
        }

        public Object pop() {
            if ( size == 0 ) 
                throw new EmptyStackException();
            Object result = elements[--size];
            elements[size] = null;
            return result;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void ensureCapacity() {
            if (elements.length == size)
                elements = Arrays.copyOf(elements, 2 * size +1);
        }
    }

    static class myStack2<E> {
        private E[] elements;
        private int size = 0;
        private static final int DEFAULT_SIZE = 16;

        @SuppressWarnings("unchecked")
        myStack2() {
            //can not create non-reifiable object
            //elements = new E[DEFAULT_SIZE];
            elements = (E[])new Object[DEFAULT_SIZE];
        }

        public void push( E e ) {
            ensureCapacity();
            elements[size++] = e;
        }

        public E pop() {
            if ( size == 0 ) 
                throw new EmptyStackException();
            E result = elements[--size];
            elements[size] = null;
            return result;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void ensureCapacity() {
            if (elements.length == size)
                elements = Arrays.copyOf(elements, 2 * size +1);
        }
    }

    static class myStack3<E> {
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_SIZE = 16;
      
        myStack3() {
            elements = new Object[DEFAULT_SIZE];
        }

        public void push( E e ) {
            ensureCapacity();
            elements[size++] = e;
        }

        public void pushAll(Iterable<E> src) {
            for (E e : src ) {
                push(e);
            }
        }

        public Object pop() {
            if ( size == 0 ) 
                throw new EmptyStackException();
            @SuppressWarnings("unchecked")
            E result = (E)elements[--size];
            elements[size] = null;
            return result;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void ensureCapacity() {
            if (elements.length == size)
                elements = Arrays.copyOf(elements, 2 * size +1);
        }
    }

    static class myStack4<E> {
        private E[] elements;
        private int size = 0;
        private static final int DEFAULT_SIZE = 16;

        @SuppressWarnings("unchecked")
        myStack4() {
            //can not create non-reifiable object
            //elements = new E[DEFAULT_SIZE];
            elements = (E[])new Object[DEFAULT_SIZE];
        }

        public void push( E e ) {
            ensureCapacity();
            elements[size++] = e;
        }

        public void pushAll(Iterable<? extends E> src) {
            for (E e : src ) {
                push(e);
            }
        }

        public E pop() {
            if ( size == 0 ) 
                throw new EmptyStackException();
            E result = elements[--size];
            elements[size] = null;
            return result;
        }

        public void popAll(Collection<? super E> dst) {
            while(!isEmpty())
                dst.add(pop());
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void ensureCapacity() {
            if (elements.length == size)
                elements = Arrays.copyOf(elements, 2 * size +1);
        }
    }

    public static void main(String[] args) {
        //compile error GenericStackExample.java:116: error: incompatible types: Iterable<Integer> cannot be converted to Iterable<Number>
        //numberStack.pushAll(integers);
        /*myStack3<Number> numberStack = new myStack3<>();
        Iterable<Integer> integers = {1,3,4};
        numberStack.pushAll(integers);*/
        myStack4<Number> numberStack = new myStack4<>();
        Integer[] temp = {1,2,3,4,5};
        Iterable<Integer> integers =  Arrays.asList(temp);
        numberStack.pushAll(integers);

        Collection<Object> collection = new ArrayList<>();
        numberStack.popAll(collection);
        for ( Object o : collection ) {
            System.out.println(o);
        }
    }

}