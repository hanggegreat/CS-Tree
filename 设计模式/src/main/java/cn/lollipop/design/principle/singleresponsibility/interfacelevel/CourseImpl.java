package cn.lollipop.design.principle.singleresponsibility.interfacelevel;

public class CourseImpl implements ICourseManager, ICourseContent {
    public String getCourseName() {
        return null;
    }

    public byte[] getCourseVideo() {
        return new byte[0];
    }

    public void studyCourse() {

    }

    public void refundCourse() {

    }
}
