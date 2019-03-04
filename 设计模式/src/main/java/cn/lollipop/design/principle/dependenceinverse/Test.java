package cn.lollipop.design.principle.dependenceinverse;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.setCourse(new JavaCourse());
        person.studyCourse();
        person.setCourse(new PythonCourse());
        person.studyCourse();
        person.setCourse(new FECourse());
        person.studyCourse();
    }
}
