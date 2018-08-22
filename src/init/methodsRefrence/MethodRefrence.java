package init.methodsRefrence;

import java.util.function.*;

/**
 * 方法引用
 * {
 *      静态，非静态（2种方式：1、[对象实例::方法名],2、[类名::方法名]），构造函数(有参，无参)
 * }
 *
 * 知识点：在处理无参构造函数时，编译器会自动将当前对象实例作为参数传入进去，
 *        需明确Java只有【值传递】，并没有【引用传递】
 * @author Administrator
 * @create 2018-08-21 10:10
 */
public class MethodRefrence {

    public static void main(String[] args){
        //方法引用: 当执行体只有一个函数调用时，且参数和箭头(->)右边相同的话，就可以简化采用【方法调用】的写法
        Consumer<String> consumer = System.out::println;
        consumer.accept("methods_refrence");

        //【方法引用】引用形式

        //1、【方法引用】静态方法
        Consumer<Cat> catConsumer = Cat::talk; // {类名::方法名}

        Cat cat = new Cat();
        catConsumer.accept(cat);

        //2、【方法引用】非静态方法，使用对象实例引用
        Function<Integer,Integer> function = cat::eat; // {对象实例::方法名}
        System.out.println("ClassName = MethodRefrence ,FUNCTION_NAME = Function , 还剩"+ function.apply(3) +"斤");

        /**
         * 优化：因为eat方法参数及返回值都为Integer，所以可以采用一元函数
         *  |
         *  ▽
         */
        UnaryOperator<Integer> unaryOperator = cat::eat;
        System.out.println("ClassName = MethodRefrence ,FUNCTION_NAME = UnaryOperator , 还剩"+ unaryOperator.apply(3) +"斤");

        /**
         * 继续优化
         */
        IntUnaryOperator intUnaryOperator = cat::eat;
        System.out.println("ClassName = MethodRefrence ,FUNCTION_NAME = IntUnaryOperator , 还剩"+ intUnaryOperator.applyAsInt(3) +"斤");

        //2.1 【方法引用】非静态方法 使用类名引用
        BiFunction<Cat,Integer,Integer> biFunction = Cat::eat; // {类名::方法名}
        System.out.println("ClassName = MethodRefrence ,FUNCTION_NAME = BiFunction , 还剩"+ biFunction.apply(cat,3) +"斤");


        //3、【方法引用】 构造函数方法引用
        /**
         * 无参
         * 提供者：提供cat对象的实例
         */
        Supplier<Cat> supplier = Cat::new;
        System.out.println("ClassName = MethodRefrence ,FUNCTION_NAME = Supplier , 无参Constructor Object:"+ supplier.get());

        /**
         * 有参
         */
        Function<String,Cat> constructor = Cat::new;
        System.out.println("ClassName = MethodRefrence ,FUNCTION_NAME = Supplier , 有参Constructor Object:"+ constructor.apply("Alice"));
    }
}

/**
 * Tom猫
 */
class Cat{

    public Cat() {

    }

    public Cat(String name) {

        this.name = name;
    }

    private String name = "Tom";
    /**
     * 喵粮/斤
     */
    private int food = 10;

    /**
     * Tom猫演讲
     * @param cat
     */
    public static void talk(Cat cat){
        System.out.println("ClassName = Cat ,METHOD_NAME = talk , 猫崽子: "+ cat +" 学舌");
    }
    
    /***
     * @param: [num]
     * describe: 吃饭
     * creat_user: sl
     * creat_date: 2018/8/21
     * creat_time: 11:30
     * 【注：】JDK默认会把当前实例传入到非静态方法，参数名为this，位置为第一个， eat(Cat this,Integer num)
     *        所以该方法会有两个入参和一个返回值
     **/
    public int eat(Integer num){
        System.out.println("ClassName = Cat ,METHOD_NAME = eat , 消化了："+ num + " 斤猫粮");
        this.food -= num;
        return this.food;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
