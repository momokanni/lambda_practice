# lambda_practice

##### 知识点(JDK1.8)：
>1、函数接口调用： `{<1>.@FunctionalInterface,<2>.default method,<3>.函数接口多继承下的方法引用,<4>.链式操作}`<br/>
>2、方法引用：`{静态，非静态（2种方式：<1>.[对象实例::方法名],<2>.[类名::方法名]），构造函数(有参，无参)}`<br/>
>3、类型推断：`强转、通过返回类型判断 【形参列表的数据类型会自动推断，只需要参数名称】`<br/>
>4、变量引用 `JDK1.8当内部类引用外部变量时，会默认添加final关键字，不需要指明`<br/>
>5、其他函数接口： `lambda提供预设好的对应基本类型的各种函数 【优先使用】`<br/>
>6、级联及柯里化：`柯里化：把多个参数的函数转换为只有一个参数的函数，【目的】函数标准化`<br/>
>7、Java只有值引用传递，没有对象引用传递<br/>
>8、lambda表达式并不会生成额外的.class文件，而匿名内部类会生成XXXX$1.class
######[仔细看看这篇文章，语法总结的还不错](https://blog.csdn.net/zymx14/article/details/70175746)