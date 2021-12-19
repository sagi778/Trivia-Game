package Trivia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;

public class TriviaLogic {

    // attributes
    private int _count = numberOfQuestionsInFile(); //number of questions in exam.txt file
    private TriviaQuestion[] _array = new TriviaQuestion[_count];

    // constructor
    public  TriviaLogic(){ // construct model & open file for reading

        try {
            Scanner file = new Scanner( new File("exam.txt") ); // open txt file for reading

            for(int i=0; i < getCount(); i++ ){
                this.setQuestionPage(file, i);
            }
            file.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //get & set
    public int getCount(){return _count;}
    public TriviaQuestion getQuestionPage(int i){return _array[i];}
    public void setQuestionPage(Scanner file, int index){

        TriviaQuestion temp = new TriviaQuestion();

        temp.setQuestion( file.nextLine() );
        temp.setRightAnswer( file.nextLine() );
        temp.setAnswer1( file.nextLine() );
        temp.setAnswer2( file.nextLine() );
        temp.setAnswer3( file.nextLine() );

        _array[index] = temp;
    }

    // methods
    private int numberOfQuestionsInFile(){

        int count=0;

        try (Scanner file = new Scanner(new File("exam.txt"))) {

            while( file.hasNextLine()){
                count++;
                file.nextLine();
            }
            file.close();
            return (int)((count/5) -1); //number of questions
        }
        catch (FileNotFoundException e){e.printStackTrace();}
        return -1; //empty file
    }

}
