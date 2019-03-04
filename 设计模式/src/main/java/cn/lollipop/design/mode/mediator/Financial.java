package cn.lollipop.design.mode.mediator;


public class Financial implements Department {
    private Mediator mediator;

    public Financial(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("financial", this);
    }

    @Override
    public void selfAction() {
        System.out.println("数钱");
    }

    @Override
    public void outAction(String source) {
        System.out.println("汇报工作，钱太多了，怎么花？");
    }
}
