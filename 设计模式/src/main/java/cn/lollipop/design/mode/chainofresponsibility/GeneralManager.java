package cn.lollipop.design.mode.chainofresponsibility;

/**
 * 总经理，处理10天以上的请假
 */
public class GeneralManager extends Leader {

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() < 30) {
            System.out.println("员工" + request.getEmpName() + "请假，天数" + request.getLeaveDays() + "，理由：" + request.getReason());
            System.out.println("总经理" + name + "审批通过");
        } else {
            System.out.println("总经理" + name + "将员工" + request.getEmpName() + "撤职！");
        }
    }
}
