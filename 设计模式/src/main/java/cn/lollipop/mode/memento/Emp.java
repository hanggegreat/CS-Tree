package cn.lollipop.mode.memento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 雇员
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {

    private String ename;
    private int age;
    private double salary;

    public EmpMemento memento() {
        return new EmpMemento(this);
    }

    public void recovery(EmpMemento empMemento) {
        ename = empMemento.getEname();
        age = empMemento.getAge();
        salary = empMemento.getSalary();
    }
}
