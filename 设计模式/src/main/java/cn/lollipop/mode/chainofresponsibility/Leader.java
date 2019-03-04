package cn.lollipop.mode.chainofresponsibility;

import lombok.Setter;

/**
 * 领导抽象类
 */
public abstract class Leader {

    protected String name;

    @Setter
    protected Leader nextLeader; // 责任链上的后继对象

    public Leader(String name) {
        this.name = name;
    }

    public abstract void handleRequest(LeaveRequest request);
}
