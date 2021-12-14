package Trivia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

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
    public void beginAction(ActionEvent event) throws IOException {

        System.out.println("Begin Exam");
        TriviaLogic t = new TriviaLogic();

        Scanner file = new Scanner( new File("exam.txt") ); // open txt file for reading
        t.initilizeExam(file);

    }
    public void NextAction(ActionEvent actionEvent) {
        System.out.println("Next");
    }
}
