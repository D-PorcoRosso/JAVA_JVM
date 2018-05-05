public class DefaultMethodExample implements DefaultMethodInterface {

    @Override
    public void oldInterface() {
        System.out.println("oldInterface");
    }

    @Override
    public void newInterface() {
        System.out.println("override newInterface");
    }

    public static void main(String[] args) {
        DefaultMethodExample example = new DefaultMethodExample();
        example.oldInterface();
        example.newInterface();
    }
}