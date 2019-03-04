package cn.lollipop.mode.prototype;

import java.util.Date;

/**
 * 原型模式
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date(12312321331L);
        Sheep s1 = new Sheep();
        s1.setDate(date);
        s1.setName("多莉");
        System.out.println("s1 = " + s1);
        Sheep s2 = (Sheep) s1.clone();
        date.setTime(new Date().getTime());
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }
}
