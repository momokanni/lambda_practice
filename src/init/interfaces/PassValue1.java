package init.interfaces;

/**
 * 调用接口传值
 *
 * @author Administrator
 * @create 2018-08-20 15:54
 */
public class PassValue1 {

    public static void main(String[] args){
        //写法1  【返回了指定接口的对象实例】
        Interface1 write1 = (i) -> i * 2;
        //写法2 推荐使用
        Interface1 write2 = i -> i * 2;
        //写法3
        Interface1 write3 = (int i) -> i * 2;
        //写法4
        Interface1 write4 = (i) ->{
            System.out.println("~~~~~~~~~~~~~~~~~~ClassName = PassValue1 ,METHOD_NAME = main , i = " + i);
            return i * 2;
        };

        System.out.println("~~~~~~~~~~~~~~~~~~ClassName = PassValue1 ,METHOD_NAME = main , add method = "+ write1.add(3,7));

        System.out.println("~~~~~~~~~~~~~~~~~~ClassName = PassValue1 ,METHOD_NAME = main , operation = "+write1.operation(2));
    }
}

/**
 * 函数接口，【要实现的接口】只能保留一个（单一责任制）
 */
@FunctionalInterface
interface Interface1{
    int operation(int i);

    /**
     * JDK1.8新特性 默认实现的方法
     * @param a
     * @param b
     * @return
     */
    default int add(int a,int b){
        return a + b;
    }
}

@FunctionalInterface
interface Interface2{
    int operation(int i);

    /**
     * JDK1.8 默认实现的方法
     * @param a
     * @param b
     * @return
     */
    default int add(int a,int b){
        return a + b;
    }
}

/**
 * 函数接口多继承
 */
@FunctionalInterface
interface Interface3 extends Interface1,Interface2{

    @Override
    default int add(int a, int b) {
        //【指明引用父接口】
        return Interface1.super.add(a,b);
    }
}
