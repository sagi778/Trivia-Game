package Trivia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Controller{

    @FXML
    public Label qText;
    public RadioButton b1;
    public RadioButton b2;
    public RadioButton b3;
    public RadioButton b4;

    // construct game logic/model
    TriviaLogic model = new TriviaLogic();
    private int _qCount = 0;

    public void radioAction(ActionEvent event) {

        String b = ((RadioButton)event.getSource()).getText(); // get current operation

        System.out.println("Answer "+ b + " Picked");


    }
    public void NextAction(ActionEvent event)  {

        //model.newPage( model.getFile() ); // show new question/trivia page
        qText.setText( model.getQuestionPage(_qCount).getQuestion() );
        _qCount++;
        //b1.setText( );
        System.out.println("Next");

    }
    public void correctAnswer(ActionEvent event) {
        System.out.println("correct");
    }

    private void setPage(TriviaQuestion p){ // setting new question to present in GUI

        qText.setText( p.getQuestion() );
        b1.setText( p.getRightAnswer() );
        b2.setText( p.get_answer1() );
        b3.setText( p.get_answer2() );
        b4.setText( p.get_answer3() );
    }

}
