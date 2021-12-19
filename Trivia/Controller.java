package Trivia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

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
    ToggleGroup rbGroup = new ToggleGroup();
    private int _qCount = 0; //number of question index (=question in test)

    public void radioAction(ActionEvent event) {

        // set all rb as 1 group
        b1.setToggleGroup(rbGroup);
        b2.setToggleGroup(rbGroup);
        b3.setToggleGroup(rbGroup);
        b4.setToggleGroup(rbGroup);
    }
    public void NextAction(ActionEvent event)  {

        RadioButton bFirst = getRandomRadioButton();
        RadioButton bSecond = getRandomRadioButton(bFirst);
        RadioButton bThird = getRandomRadioButton(bSecond,bFirst);
        RadioButton bFourth = getRandomRadioButton(bThird,bSecond,bFirst);

        if(_qCount < model.getCount()) {
            Title.setText("Question "+ (_qCount+1));
            qText.setText( model.getQuestionPage(_qCount).getQuestion() );
            bFirst.setText( model.getQuestionPage(_qCount).getRightAnswer() );
            bSecond.setText( model.getQuestionPage(_qCount).get_answer1() );
            bThird.setText( model.getQuestionPage(_qCount).get_answer2() );
            bFourth.setText( model.getQuestionPage(_qCount).get_answer3() );
            _qCount++;

            //set default answer
            b1.setSelected(true);
        }
        else{
            qText.setText("Trivia game is Over...see you next time");
            return;}

    }
    public void correctAnswer(ActionEvent event) {

        boolean correctFlag = isCorrect( model.getQuestionPage(_qCount-1).getRightAnswer(), rbGroup);

        if(correctFlag){
            Title.setText("Correct!");
        }
        else{
            Title.setText("Wrong!");
        }
    }
    public boolean isCorrect(String currectAnswer, ToggleGroup rbGroup){

        String chosenAnswer = ((RadioButton)rbGroup.getSelectedToggle()).getText();
        return ( chosenAnswer == currectAnswer );

    }

    // randomization related methods
    private RadioButton getRandomRadioButton(){

        int MIN = 1, MAX = 4, RANGE = MAX-MIN+1;
        int rand = (int)(Math.random()*RANGE) + MIN;

        return convertNumToRb(rand);

    } // get random 1-4 radio button to set answer
    private RadioButton getRandomRadioButton(RadioButton b){// get random 1-4 radio button to set answer that is not set already

        int MIN = 1, MAX = 4, RANGE = MAX-MIN+1;
        int rand = (int)(Math.random()*RANGE) + MIN;
        RadioButton rb = convertNumToRb(rand);

        while( rb == b ){
            rb = getRandomRadioButton();
        }
        return rb;
    }
    private RadioButton getRandomRadioButton(RadioButton b,RadioButton c){// get random 1-4 radio button to set answer that is not set already

        int MIN = 1, MAX = 4, RANGE = MAX-MIN+1;
        int rand = (int)(Math.random()*RANGE) + MIN;
        RadioButton rb = convertNumToRb(rand);

        while( rb==b || rb==c){
            rb = getRandomRadioButton();
        }
        return rb;
    }
    private RadioButton getRandomRadioButton(RadioButton b,RadioButton c,RadioButton d){// get random 1-4 radio button to set answer that is not set already

        int MIN = 1, MAX = 4, RANGE = MAX-MIN+1;
        int rand = (int)(Math.random()*RANGE) + MIN;
        RadioButton rb = convertNumToRb(rand);

        while( rb==b || rb==c || rb==d ){
            rb = getRandomRadioButton();
        }
        return rb;
    }
    private RadioButton convertNumToRb(int num){

        if( num == 1){return b1;}
        else if( num == 2){return b2;}
        else if( num == 3){return b3;}
        else{return b4;}
    }
    private int convertRbToNum(RadioButton rb){

        if( rb == b1){return 1;}
        else if( rb == b2 ){return 2;}
        else if( rb == b3 ){return 3;}
        else{return 4;}
    }
}
