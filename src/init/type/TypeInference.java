package init.type;

/**
 * 类型推断
 *
 * @author Administrator
 * @create 2018-08-21 17:48
 */
public class TypeInference {

    public static void main(String[] args){
        //
        OPeration oPeration = (x,y) -> x + y;

        //数组类型
        OPeration[] oPerations = {(x,y) -> x + y};

        //强转
        Object obj = (OPeration)(x,y) -> x + y;

        //通过返回类型
        OPeration oPeration1 = createLambda();

        /**
         * 当调用的方法参数接口 有二义性时，一定要明确接口类型
         */
        TypeInference typeInference = new TypeInference();
        typeInference.test((OPeration) (x,y) -> x + y  );

    }


    public void test(OPeration oPeration){

    }

    public void test(OPeration2 oPeration2 ){

    }

    public static OPeration createLambda(){
        return (x,y) -> x + y;
    }
}

@FunctionalInterface
interface OPeration{
    int add(int x,int y);
}

@FunctionalInterface
interface OPeration2{
    int add(int x,int y);
}
