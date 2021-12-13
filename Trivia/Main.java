package Trivia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("TriviaView.fxml"));
        primaryStage.setTitle("My Trivia Exam");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }


    public static void main(String[] args) throws FileNotFoundException{

        Scanner file = new Scanner( new File("exam.txt") ); // open txt file for reading

        launch(args);

        file.close(); // closing txt file

    }
}
