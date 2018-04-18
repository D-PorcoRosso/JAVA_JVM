public class parameterCheck {

    static class test {
        int temp = 0;
    }

    void modifyTest(test t) {
        t.temp = 10;
        System.out.println("in func modify test t.temp:"+t.temp);
    }

    void modifyPrimitive(int i) {
        i = 10;
        System.out.println("in func modify primitive:"+i);
    }

    public static void main(String[] args) {
        test t = new test();
        parameterCheck p = new parameterCheck();
        p.modifyTest(t);
        System.out.println("after func modify test:"+t.temp);
        int v = 0;
        p.modifyPrimitive(v);
        System.out.println("in func modify primitive:"+v);
    }
}