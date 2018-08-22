package init.interfaces;

import java.text.DecimalFormat;
import java.util.function.Function;

/**
 * @author Administrator
 * @create 2018-08-20 16:39
 */
public class ParamFormat {


    public static void main(String[] args){
        MoneyDemo md = new MoneyDemo(278.6920);
        Function<Double,String> moneyFormat = i -> new DecimalFormat("#0.00").format(i);
        //函数接口 链式操作
        md.print(moneyFormat.andThen(s -> "￥ " + s));
    }
}

class MoneyDemo{
    private final double dib;

    public MoneyDemo(double dib) {
        this.dib = dib;
    }

    /**
     * 方法2
     * @param:
     * describe: 当明确：【传入类型】和【返回值类型】，则完全没有创建接口的必要，可直接使用函数式编程
     * creat_user: sl
     * creat_date: 2018/8/20
     * creat_time: 17:11
     **/
    public void print(Function<Double,String> moneyFormat){
        System.out.println("~~~~~~~~~~~~~~~~~~ClassName = MoneyDemo ,METHOD_NAME = print , dib = " + moneyFormat.apply(this.dib));
    }

    // 方法 1
    /*public void print(InMoney inMoney){
        System.out.println("~~~~~~~~~~~~~~~~~~ClassName = MoneyDemo ,METHOD_NAME = print , dib = " + inMoney.format(this.dib));
    }*/


}

//接口
/*@FunctionalInterface
interface InMoney{
    String format(double i);
}*/
