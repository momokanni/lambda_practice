package init.thread;

/**
 * lambda线程写法进阶
 *
 * @author Administrator
 * @create 2018-08-20 10:50
 *
 * lambda: 返回了指定接口的对象实例
 */
public class ThreadAdvanced {

    public static void main(String[] args){

        Object target = new Runnable() {

            @Override
            public void run() {
                System.out.println("~~~~~~~~~~~~~~~~~~ClassName = ThreadAdvanced ,METHOD_NAME = run , thread advanced");
            }
        };
        new Thread((Runnable) target).start();

        Object target2 = (Runnable)() -> System.out.println("target2");
        Runnable target3 = () -> System.out.println("target3");

        System.out.println("是否同为一个线程实例："+ (target2 == target3)); // false
    }

}
