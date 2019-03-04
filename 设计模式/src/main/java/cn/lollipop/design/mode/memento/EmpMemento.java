package cn.lollipop.design.mode.memento;

import lombok.Data;

/**
 * 备忘录类
 */
@Data
public class EmpMemento {

    private String ename;
    private int age;
    private double salary;

    public EmpMemento(Emp emp) {
        ename = emp.getEname();
        age = emp.getAge();
        salary = emp.getSalary();
    }


}
