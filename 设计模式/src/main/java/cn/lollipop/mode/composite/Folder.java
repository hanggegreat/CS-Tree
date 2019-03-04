package cn.lollipop.mode.composite;


import java.util.ArrayList;
import java.util.List;

public class Folder implements AbstractFile {
    private String name;

    // 定义容器，用来存放本容器构建下的叶子结点
    private List<AbstractFile> list = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public boolean add(AbstractFile file) {
        return list.add(file);
    }

    public boolean remove(AbstractFile file) {
        return list.remove(file);
    }

    public AbstractFile get(int index) {
        return list.get(index);
    }

    @Override
    public void killVirus() {
        System.out.println("--- 文件夹：" + name + "，进行查杀！");
        for (AbstractFile file : list) {
            file.killVirus();
        }
    }
}
