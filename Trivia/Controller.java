package Trivia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;


public class Controller {

    @FXML
    public Label qText;
    public RadioButton b1;
    public RadioButton b2;
    public RadioButton b3;
    public RadioButton b4;



    public void radioAction(ActionEvent event) {

        String b = ((RadioButton)event.getSource()).getText(); // get current operation

        System.out.println("Answer "+ b + " Picked");
    }

    //Scanner input = new Scanner(new File("exam.txt"));

}
