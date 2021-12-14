package Trivia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TriviaLogic {

    //attributes
    private TriviaQuestion [] _exam; // contain full exam = array of questions

    public TriviaLogic(){}

    public void initilizeExam(Scanner file) throws FileNotFoundException { //creating new exam from txt file

        String row = file.next();
        String txt = getText(file);
        String q = getQuestion(txt);


    }
    public String getText(Scanner file){

        String str = "*";

        while( file.hasNext() ){
            str += file.next()+ " ";
        }
        return str;
    }
    public String getQuestion(String txt){ //return question string

        int strt = getNewQuestionStart(txt);
        int end = getNewQuestionEnd(txt);

        return txt.substring( strt, end )+"?";
    }
    public int getNewQuestionStart(String txt){ //get new question beginning index

        int i=0;
        while( i < txt.length() && !Character.toString(txt.charAt(i)).equals("*") ){
            i++;
        }
        if( i== txt.length() ){return -1;}
        else return i;
    }
    public int getNewQuestionEnd(String txt){ //get new question end index

        int i=0;
        while( i < txt.length() && !Character.toString(txt.charAt(i)).equals("?") ){
            i++;
        }
        if( i== txt.length() ){return -1;}
        else return i;
    }
}
