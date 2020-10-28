package model;

import java.util.concurrent.TimeUnit;

/**
 * Created by Дмитрий on 28.10.2020.
 */
public class Model {
    private int pin = 1234;

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return pin;
    }
}
