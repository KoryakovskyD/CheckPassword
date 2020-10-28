package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Дмитрий on 28.10.2020.
 */
public class UserView extends JFrame{
    private JTextArea text;
    private JButton sendButton;
    private JLabel info;
    private Controller controller;

    public UserView(Controller controller){
        this.controller = controller;
    }

    public void init(){
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        text = new JTextArea();
        sendButton = new JButton("Send");
        info = new JLabel("Info");

        add(text, BorderLayout.CENTER);
        add(sendButton, BorderLayout.SOUTH);
        add(info, BorderLayout.NORTH);

        sendButton.addActionListener(e -> {
            int pin;
            String textPin = text.getText();
            text.setText("");
            try {
                pin = Integer.parseInt(textPin);
                info.setText("Got it: " + pin + " Waiting...");
                Thread thread = new Thread(() -> {
                sendButton.setEnabled(false);
                boolean result;
                result = controller.checkPin(pin);
                String resultMassage;
                if (result)
                    resultMassage = "Right";
                else
                    resultMassage = "Wrong, try again...";
                info.setText(resultMassage);
                sendButton.setEnabled(true);
            });
            thread.start();
        } catch (NumberFormatException c) {
            info.setText("Only numbers allowed!");
        }
    });
            setVisible(true);
    }
}
