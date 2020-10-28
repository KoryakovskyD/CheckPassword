package controller;

import model.Model;

/**
 * Created by Дмитрий on 28.10.2020.
 */
public class Controller {
    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public boolean checkPin(int pin) {
        return model.getPin() == pin;
    }
}
