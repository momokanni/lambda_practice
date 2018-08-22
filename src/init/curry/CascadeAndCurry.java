package init.curry;

import java.util.function.Function;

/**
 * 级联及柯里化
 * 柯里化：把多个参数的函数转换为只有一个参数的函数
 * 目的：函数标准化
 * 高阶函数：返回函数的函数
 * @author Administrator
 * @create 2018-08-21 19:56
 *
 */
public class CascadeAndCurry {

    public static void main(String[] args){
        // x -> y -> x + y
        Function<Integer,Function<Integer,Integer>> functionFunction = x -> y -> x + y; //级联
        System.out.println("ClassName = CascadeAndCurry ,级联 "+ functionFunction.apply(2).apply(3));

        // x -> y -> z -> x + y + z
        Function<Integer,Function<Integer,Function<Integer,Integer>>> curryFun = x -> y -> z -> x + y + z;
        System.out.println("ClassName = CascadeAndCurry ,柯里化 "+ curryFun.apply(2).apply(3).apply(5));

        /**
         * 柯里化的好处
         */
        int[] nums = {2,3,5};
        Function f = curryFun;
        for (int i=0; i<nums.length;i++){
            if (f instanceof Function){
                Object obj = f.apply(nums[i]);
                if (obj instanceof Function){
                    f = (Function) obj;
                } else {
                    System.out.println("ClassName = CascadeAndCurry ,循环遍历加减 "+obj);
                }
            }
        }
    }
}
