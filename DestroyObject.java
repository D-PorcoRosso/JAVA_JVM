public class DestroyObject {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("start gc");
        int a = 1;
        System.out.print(a/0);
    }

    public static void main(String[] args) {
        DestroyObject o = new DestroyObject();
        o = null;
        System.gc();
    }
}