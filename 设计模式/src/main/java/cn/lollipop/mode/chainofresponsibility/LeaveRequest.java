package cn.lollipop.mode.chainofresponsibility;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 封装请假的信息
 */
@AllArgsConstructor
@Data
public class LeaveRequest {

    private String empName;
    private int leaveDays;
    private String reason;
}
