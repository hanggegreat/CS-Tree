package cn.lollipop.mode.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class Client {

    public static void main(String[] args) throws Exception {
        Singleton6 s1 = Singleton6.getInstance();
        Singleton6 s2 = Singleton6.getInstance();
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        // 通过反射的方式直接调用私有构造器
        Class<Singleton6> clazz = Singleton6.class;
        Constructor<Singleton6> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton6 s3 = constructor.newInstance();
        System.out.println("s3 = " + s3);

        // 通过反序列化的方式
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("G:/test/Singleton.txt"));
        oos.writeObject(s1);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("G:/test/Singleton.txt"));
        Singleton6 s4 = (Singleton6) ois.readObject();
        System.out.println("s4 = " + s4);
    }
}
