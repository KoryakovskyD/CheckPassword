import controller.Controller;
import model.Model;
import view.UserView;

import javax.swing.*;

/**
 * Created by Дмитрий on 28.10.2020.
 */
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        UserView userView = new UserView(controller);
        SwingUtilities.invokeLater(() -> {
                userView.init();
        });

    }
}
