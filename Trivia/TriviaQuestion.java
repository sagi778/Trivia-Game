package Trivia;

//class for specific trivia question(question page)

public class TriviaQuestion {

    //attributes
    private String _question;
    private String _rightAnswer;
    private String _answer1;
    private String _answer2;
    private String _answer3;

    //get & set
    public String getQuestion(){return _question;}
    public String getRightAnswer(){return _rightAnswer;}
    public String get_answer1(){return _answer1;}
    public String get_answer2(){return _answer2;}
    public String get_answer3(){return _answer3;}
    public void setQuestion(String question){_question = question;}
    public void setRightAnswer(String answer){_rightAnswer = answer;}
    public void setAnswer1(String answer){_answer1 = answer;}
    public void setAnswer2(String answer){_answer2 = answer;}
    public void setAnswer3(String answer){_answer3 = answer;}

}
