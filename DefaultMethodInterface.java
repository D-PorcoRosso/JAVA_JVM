/**
 * DefaultMethodExample
 */
public interface DefaultMethodInterface {
    public void oldInterface();
    //this will build error, because we do not implement newInterface
    //public void newInterface();

    default public void newInterface() {
        System.out.println("newInterface");
    }
}

