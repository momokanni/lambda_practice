package init.parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 变量引用
 *
 * @author Administrator
 * @create 2018-08-21 18:19
 * JDK1.8之前，内部类引用外部变量时，则该变量必须为final
 * JDK1.8 默认可以不加关键字，但变量无法更改
 * 值传递 / 引用传递
 */
public class ParamInFrence {

    public static void main(String[] args){
        String str = "变量引用";
        // error: str += "test";
        Consumer<String> consumer = s -> System.out.println(s + str);
        consumer.accept("str");

        List<String> list = new ArrayList<>();
        // error: str += "test";
        Consumer<String> consumer1 = s -> System.out.println(s + list);
        consumer1.accept("str");

    }
}
