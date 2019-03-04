package cn.lollipop.design.principle.singleresponsipility.methodlevel;

public class Method {
    private void updateUserInfo(String userName, String address) {
        //todo something
    }

    // 应拆分为如下两个方法

    private void updateUserName(String userName) {
        //todo something
    }

    private void updateAddress(String address) {
        //todo something
    }
}
