package cn.lollipop.mode.composite;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VideoFile implements AbstractFile {

    private String name;

    @Override
    public void killVirus() {
        System.out.println("---- 视频文件：" + name + "，进行查杀！");
    }
}
