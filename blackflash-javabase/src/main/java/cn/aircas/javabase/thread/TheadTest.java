package cn.aircas.javabase.thread;

public class TheadTest {
    public static void runAThread() {
        new Thread(() -> {
            for (int i=0;i<100;i++) {
                System.out.println(i);
            }
        }).start();
    }
}
