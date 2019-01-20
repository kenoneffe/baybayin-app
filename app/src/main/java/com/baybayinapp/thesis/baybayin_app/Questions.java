package com.baybayinapp.thesis.baybayin_app;

public class Questions {

    private String question;
    private String answer1, answer2, answer3;
    private int answerNr;

    public Questions(){

    }
    public Questions(String question, String answer1, String answer2, String answer3, int answerNr) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answerNr = answerNr;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }

    /*public String mQuestions[] = {
            "A",
            "B",
            "K",
            "D",
            "E",
            "G",
            "H",
            "I",
            "L",
            "M",
            "ᜈ",
            "N",
            "O",
            "P",
            "R",
            "S",
            "T",
            "U",
            "W",
            "Y"
    };

    private String mChoices[][] = {
            //A
            {"A", "BA", "KA"},
            //BA
            {"DA", "BA", "GA"},
            //KA
            {"E", "GA", "KA"},
            //DA
            {"DA", "NA", "BA"},
            //E
            {"BA", "E", "A"},
            //GA
            {"HA", "GA", "PA"},
            //HA
            {"HA", "A", "I"},
            //I
            {"LA", "SA", "I"},
            //LA
            {"E", "LA", "GA"},
            //MA
            {"A", "KA", "MA"},
            //NA
            {"NA", "RA", "WA"},
            //NGA
            {"NA", "LA", "NGA"},
            //O
            {"O", "I", "U"},
            //PA
            {"BA", "PA", "KA"},
            //RA
            {"RA", "WA", "YA"},
            //SA
            {"TA", "SA", "HA"},
            //TA
            {"LA", "YA", "TA"},
            //U
            {"U", "WA", "GA"},
            //WA
            {"YA", "A", "WA"},
            //YA
            {"SA", "HA", "YA"},
    };

    private String mCorrectAnswers[] = {
            "A",
            "BA",
            "KA",
            "DA",
            "E",
            "GA",
            "HA",
            "I",
            "LA",
            "MA",
            "NA",
            "NGA",
            "O",
            "PA",
            "RA",
            "SA",
            "TA",
            "U",
            "WA",
            "YA"
    };

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a){
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a){
        String choice = mChoices[a][2];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }*/
}
