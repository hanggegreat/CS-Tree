package cn.lollipop.mode.composite;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TextFile implements AbstractFile {

    private String name;

    @Override
    public void killVirus() {
        System.out.println("---- 文本文件：" + name + "，进行查杀！");
    }
}
