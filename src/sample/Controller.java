package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Label lable;
    private long number1=0;
    private long number2=0;
    private String operator="";
    Model model = new Model();

    @FXML
    void processNumbers(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        lable.setText(lable.getText()+value);
    }

    @FXML
    void processOperators(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        if(!value.equals("=")) {
            if (!operator.isEmpty())
                return;
            operator = value;
            number1 = Integer.parseInt(lable.getText());
            lable.setText("");
        } else {
            if(operator.isEmpty())
                return;
            number2 = Integer.parseInt(lable.getText());
            float result = model.calculate(number1,number2,operator);
            lable.setText(String.valueOf(result));
        }
    }
    @FXML
    void clear(){
        lable.setText("");
        this.number1=0;
        this.number2=0;
        this.operator="";
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
