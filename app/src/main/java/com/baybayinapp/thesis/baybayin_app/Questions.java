package com.baybayinapp.thesis.baybayin_app;

public class Questions {

    public String mQuestions[] = {
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
            {"LA", "YA", "A"},
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
    }
}
