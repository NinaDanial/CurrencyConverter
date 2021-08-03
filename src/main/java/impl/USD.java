package impl;

import java.io.Serializable;

public class USD extends Coin implements Serializable {

    @Override
    public double getValue() {
        return 3.52;
    }
}
