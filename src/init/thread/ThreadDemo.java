package init.thread;

/**
 * lambda对于线程写法优化
 *
 * @author Administrator
 * @create 2018-08-14 10:46
 */
public class ThreadDemo {

    public static void main(String[] args){

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("~~~~~~~~~~~~~~~~~~ClassName = ThreadDemo ,METHOD_NAME = run , thread");
            }
        }).start();

        //lambda
        new Thread(() -> System.out.println("ok")).start();
    }
}
