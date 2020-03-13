package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    public TextField input;
    public boolean isFloat = false;
    public double left, right;
    public String o;

    public void operation(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        o = button.getText();
        left = Double.parseDouble(input.getText());
        input.setText("");
    }

    public void digit(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        input.setText(input.getText() + button.getText());
    }

    public void equals(ActionEvent actionEvent) {
        right = Double.parseDouble(input.getText());
        switch (o) {
            case "+":
                if (isFloat) {
                    input.setText(String.valueOf(left + right));
                } else {
                    input.setText(String.valueOf((int)left + (int)right));
                }
                break;
            case "-":
                if (isFloat) {
                    input.setText(String.valueOf(left - right));
                } else {
                    input.setText(String.valueOf((int)left - (int)right));
                }
                break;
            case "*":
                if (isFloat) {
                    input.setText(String.valueOf(left * right));
                } else {
                    input.setText(String.valueOf((int)left * (int)right));
                }
                break;
            case "/":
                double val = left / right;
                System.out.println(val);
                input.setText("" + val);
                break;
            case "%":
                if (isFloat) {
                    input.setText("Error mod for float type");
                } else {
                    input.setText(String.valueOf((int)left % (int)right));
                }
                break;
        }
    }

    public void div(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        input.setText(input.getText() + button.getText());
        isFloat = true;
    }
}
