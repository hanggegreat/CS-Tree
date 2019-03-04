package cn.lollipop.design.mode.mediator;


public class Development implements Department {
    private Mediator mediator;

    public Development(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("development", this);
    }

    @Override
    public void selfAction() {
        System.out.println("专心科研");
    }

    @Override
    public void outAction(String source) {
        System.out.println("汇报工作，钱不够了怎么办？");
        mediator.command("financial");
    }
}
