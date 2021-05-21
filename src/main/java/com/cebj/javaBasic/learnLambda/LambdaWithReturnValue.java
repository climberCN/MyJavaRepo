package com.cebj.javaBasic.learnLambda;

import java.util.function.Function;

public class LambdaWithReturnValue {
    public static void main(String[] args) throws Exception {
        String ret = randomData(String::valueOf);
        System.out.println(ret);

//        String retException = randomDataWithExceptionHandling(String::valueOf);
        String retException = randomDataWithExceptionHandling((s -> (String)s));
        System.out.println(retException);
    }

    // 我有数据，你有代码吗
    public static String randomData(Function<Object, String> converter) {
        return converter.apply(Math.random());
    }

    // lambda如果有 checked exception 异常，那么接口必须允许。在调用的地方，只要正常处理异常就可以了。
    public static String randomDataWithExceptionHandling(ExceptionLambda<Object, String> converter)
            throws Exception {
        // 就是正常的异常处理
        return converter.hasException(new Object());
    }
}

interface ExceptionLambda<P, R> {
    R hasException(P p) throws Exception;
}
