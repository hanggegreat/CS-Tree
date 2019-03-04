package cn.lollipop.mode.prototype;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Sheep implements Cloneable {
    private String name;
    private Date date;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();
        ((Sheep) obj).date = (Date) date.clone();
        return obj;
    }
}
