package Trivia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Controller{

    @FXML
    public Label Title;
    public Label qText;
    public RadioButton b1;
    public RadioButton b2;
    public RadioButton b3;
    public RadioButton b4;

    // construct game logic/model
    TriviaLogic model = new TriviaLogic();
    private int _qCount = 0; //number of question index (=question in test)

    public void radioAction(ActionEvent event) {

        //String b = ((RadioButton)event.getSource()).getText(); // get current operation

        // set all rb as 1 group
        ToggleGroup rbGroup = new ToggleGroup();
        b1.setToggleGroup(rbGroup);
        b2.setToggleGroup(rbGroup);
        b3.setToggleGroup(rbGroup);
        b4.setToggleGroup(rbGroup);

        boolean correctFlag = isCorrect( model.getQuestionPage(_qCount-1).getRightAnswer(), rbGroup);
        String correctString = "Wrong";
        if( correctFlag ){correctString = "correct";}
        Title.setText( correctString + " Answer" );
        System.out.println( correctString + " Answer");

    }
    public void NextAction(ActionEvent event)  {

        if(_qCount < model.getCount()) {
            qText.setText( model.getQuestionPage(_qCount).getQuestion() );
            b1.setText( model.getQuestionPage(_qCount).getRightAnswer() );
            b2.setText( model.getQuestionPage(_qCount).get_answer1() );
            b3.setText( model.getQuestionPage(_qCount).get_answer2() );
            b4.setText( model.getQuestionPage(_qCount).get_answer3() );
            _qCount++;
        }
        else{
            qText.setText("Trivia game is Over...see you next time");
            return;}

    }
    public void correctAnswer(ActionEvent event) {

        String chosenAnswer = ((RadioButton)event.getSource()).getText();
        System.out.println("correct");
    }
    public boolean isCorrect(String currectAnswer, ToggleGroup rbGroup){

        String chosenAnswer = ((RadioButton)rbGroup.getSelectedToggle()).getText();
        return ( chosenAnswer == currectAnswer );

    }

}
