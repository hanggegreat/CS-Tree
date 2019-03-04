package cn.lollipop.mode.chainofresponsibility;

/**
 * 经理，处理3-10天的请假
 */
public class Manager extends Leader {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() < 10) {
            System.out.println("员工" + request.getEmpName() + "请假，天数" + request.getLeaveDays() + "，理由：" + request.getReason());
            System.out.println("经理" + name + "审批通过");
        } else if (nextLeader != null) {
            nextLeader.handleRequest(request);
        }
    }
}
