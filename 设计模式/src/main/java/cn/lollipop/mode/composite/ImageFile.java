package cn.lollipop.mode.composite;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ImageFile implements AbstractFile {

    private String name;

    @Override
    public void killVirus() {
        System.out.println("---- 图像文件：" + name + "，进行查杀！");
    }
}
