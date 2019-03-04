package cn.lollipop.design.mode.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler {

    private Star target;

    public StarHandler(Star target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;

        System.out.println("代理方法执行前");
        System.out.println("面谈，签合同，预付款，订机票");
        if ("sing".equals(method.getName())) {
            obj = method.invoke(target, args);
        }
        System.out.println("代理方法执行后");
        System.out.println("收尾款");
        return obj;
    }
}
