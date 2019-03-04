package cn.lollipop.design.principle.openclose;

public class Test {
    public static void main(String[] args) {
        ICourse course = new JavaDiscountCourse(96, "java设计模式", 99.99);
        JavaDiscountCourse discountCourse = (JavaDiscountCourse) course;
        System.out.println("课程ID：" + discountCourse.getId() + "，课程原价：" + discountCourse.getOriginPrice() + "，折扣价格：" + discountCourse.getPrice());
    }
}
