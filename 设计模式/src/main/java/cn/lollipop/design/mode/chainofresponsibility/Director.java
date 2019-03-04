package cn.lollipop.design.mode.chainofresponsibility;

/**
 * 主任，处理三天以下的请假
 */
public class Director extends Leader {

    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() < 3) {
            System.out.println("员工" + request.getEmpName() + "请假，天数" + request.getLeaveDays() + "，理由：" + request.getReason());
            System.out.println("主任" + name + "审批通过");
        } else if (nextLeader != null) {
            nextLeader.handleRequest(request);
        }
    }
}
