package cn.lollipop.design.mode.memento;

/**
 * 备忘录模式
 */
public class Client {

    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
        Emp emp = new Emp("李醒", 20, 9999.88);
        EmpMemento memento = new EmpMemento(emp);
        careTaker.setMemento(memento);
        System.out.println(emp);
        System.out.println("===================================");

        emp.setAge(18);
        emp.setSalary(8888.99);
        System.out.println(emp);
        System.out.println("===================================");

        emp.recovery(careTaker.getMemento());
        System.out.println(emp);
        System.out.println("===================================");
    }
}
