package cn.lollipop.design.mode.composite;

/**
 * 组合模式
 */
public class Client {

    public static void main(String[] args) {
        Folder f1 = new Folder("我的收藏");
        AbstractFile f2 = new ImageFile("cjk.jpg");
        AbstractFile f3 = new TextFile("4399.txt");
        Folder f4 = new Folder("视频");
        AbstractFile f5 = new VideoFile("新闻联播.avi");
        AbstractFile f6 = new VideoFile("天气预报.avi");

        f1.add(f2);
        f1.add(f3);
        f1.add(f4);
        f4.add(f5);
        f4.add(f6);

        f1.killVirus();
    }
}
