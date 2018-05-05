/**
 * DefaultMethodExample
 */
public interface DefaultMethodInterface {
    public void oldInterface();
    //this will build error, because we do not implement newInterface
    //public void newInterface();

    default public void newInterfaceUsingDefault() {
        System.out.println("newInterfaceUsingDefault");
    }

    default public void newInterfaceUsingDefaultOverride() {
        System.out.println("newInterfaceUsingDefaultOverride");
    }
}

