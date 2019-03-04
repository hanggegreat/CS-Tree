package cn.lollipop.mode.birdge;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Computer {

    protected Brand brand;

    public void sale() {
        brand.sale();
    }
}
