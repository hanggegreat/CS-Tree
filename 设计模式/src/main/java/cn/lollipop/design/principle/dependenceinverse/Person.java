package cn.lollipop.design.principle.dependenceinverse;

public class Person {
    private ICourse course;

    public void studyCourse() {
        course.study();
    }

    public void setCourse(ICourse course) {
        this.course = course;
    }
}
