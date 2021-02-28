package study.cli.AOp;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

public class Main {
    //AOP proxy 연습
    public static void main(String[] args) {
//        Pojo pojo = new SimplePojo();
//        pojo.foo();

        ProxyFactory factory = new ProxyFactory(new SimplePojo());
        factory.addInterface(Pojo.class);
        factory.addAdvice(new ReyryAdvice());

        Pojo pojo = (Pojo) factory.getProxy();

        System.out.println(">>>");
        pojo.foo();
        System.out.println("<<");
    }
}

class ReyryAdvice implements MethodInterceptor{


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("before");
        Object proceed = methodInvocation.proceed();
        System.out.println("after");
        return proceed;
    }
}

interface Pojo{
    void foo();
}

class SimplePojo implements Pojo{

    public void foo(){

        System.out.println("run foo");
    }
}
