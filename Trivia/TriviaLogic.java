package Trivia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TriviaLogic {



    // attributes
    private Scanner _file;

    // constructor
    public TriviaLogic(){ // construct model & open file for reading

        try {
            Scanner file = new Scanner( new File("exam.txt") ); // open txt file for reading
            this.setFile( file );

            // get number of questions in file
            int numOfQuestions = numberOfQuestionsInFile();

            //setting array of TriviaQuestions class
            TriviaQuestion[] array = new TriviaQuestion[numOfQuestions];
            for(int i=0; i < numOfQuestions; i++ ){

                array[i] = new TriviaQuestion();
                array[i].setQuestion( getFile().nextLine() );
                array[i].setRightAnswer( getFile().nextLine() );
                array[i].setAnswer1( getFile().nextLine() );
                array[i].setAnswer2( getFile().nextLine() );
                array[i].setAnswer3( getFile().nextLine() );

            }

            file.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


    //get & set
    public Scanner getFile(){return _file;}
    public void setFile(Scanner file){_file = file;}

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
    public TriviaQuestion readNextQuestion(Scanner file) { //creating new exam from txt file

        int i=0;

        TriviaQuestion p = new TriviaQuestion();

        p.setQuestion( file.nextLine() );
        p.setRightAnswer( file.nextLine() );
        p.setAnswer1( file.nextLine() );
        p.setAnswer2( file.nextLine() );
        p.setAnswer3( file.nextLine() );

        return p;
    }
    public boolean hasNextQuestion(Scanner file){ //check if file contain more questions

        int rowCounter=0;
        int ROWS_IN_QUESTION = 5;

        while( file.hasNextLine() && rowCounter < ROWS_IN_QUESTION ){
            rowCounter++;
            file.nextLine();
        }
        if( rowCounter == ROWS_IN_QUESTION )
            return true;
        else return false;
    }
}
