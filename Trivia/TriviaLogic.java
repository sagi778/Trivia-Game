package Trivia;

import java.io.File;
import java.util.Scanner;

public class TriviaLogic {

    //attributes
    private String _txt = null;
    private String _question = null;
    private String _rightAnswer = null;

    public TriviaLogic(String txt, String question, String rightAnswer){
        _txt = txt;
        _question = question;
        _rightAnswer = rightAnswer;
    }

    //get & set
    public String getText(){return _txt;}
    public String getQuestion(){return _question;}
    public String getRightAnswer(){return _rightAnswer;}
    public void setText(String txt){_txt = txt;}
    public void setQuestion(String txt){_question = txt;}
    public void setRightAnswer(String txt){_rightAnswer = txt;}

    String path = "C:\\Users\\sagic\\IdeaProjects\\mmn13_Trivia\\src\\Trivia\";
    Scanner input = new Scanner(new File("exam.txt"));
}
