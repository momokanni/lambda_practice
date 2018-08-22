package init.functions;

import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * 函数接口demo
 *
 * @author Administrator
 * @create 2018-08-21 9:53
 */
public class functionDemo1 {

    public static void main(String[] args){
        //写法1：断言函数接口
        Predicate<Integer> predicate = i -> i>0;
        System.out.println("~~~~~~~~~~~~~~~~~~ClassName = functionDemo1 ,METHOD_NAME = main , predicate = "+predicate.test(-1));

        //写法2：当处理的数据类型为基本类型时，lambda提供预设好的对应类型函数 【优先使用】
        IntPredicate intPredicate = i -> i>0;
        System.out.println("~~~~~~~~~~~~~~~~~~ClassName = functionDemo1 ,METHOD_NAME = main , intPredicate = "+intPredicate.test(1));

        // 消费函数接口【常规写法】 --转-> methodsRefrence查看 【方法引用】
        Consumer<String> consumer = s -> System.out.println("消费函数接口调用："+s);
        consumer.accept("transfer");

        //

    }
}
