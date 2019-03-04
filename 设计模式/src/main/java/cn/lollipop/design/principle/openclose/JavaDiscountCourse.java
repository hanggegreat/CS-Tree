package cn.lollipop.design.principle.openclose;

public class JavaDiscountCourse extends JavaCourse {
    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    @Override
    public Double getPrice() {
        return 0.8 * super.getPrice();
    }

    public Double getOriginPrice() {
        return super.getPrice();
    }
}
