package cn.lollipop.design.mode.chainofresponsibility;

/**
 * 责任链模式
 */
public class Client {

    public static void main(String[] args) {
        Leader director = new Director("张三");
        Leader manager = new Manager("李四");
        Leader generalManager = new GeneralManager("王五");

        // 组织责任链对象的关系
        director.setNextLeader(manager);
        manager.setNextLeader(generalManager);

        director.handleRequest(new LeaveRequest("TOM", 2, "回英国老家探亲1"));
        director.handleRequest(new LeaveRequest("TOM", 8, "回英国老家探亲2"));
        director.handleRequest(new LeaveRequest("TOM", 12, "回英国老家探亲3"));
    }
}
