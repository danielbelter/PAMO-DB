package com.example.exercise_2;

public class Questions {
    public String mQuestions[] = {
            "Ile wynosi prawidłowy poziom cholesterolu ?",
            "Jakie jest prawidłowe tętno ?",
            "Jaki jest prawidłowy poziom cukru we krwi ?",
            "Wątrobie najbardziej szkodzi ?",
            "Sercu pomaga ?",
            "Jaka jest prawidłowa temperatura ciała ?"



    };

    private String mChoices[][] = {
            {"300 ml/dl", "100 mg/dl", "500 mg/dl", "Do 200 mg/dl"},
            {"80-100 uderzeń na minute", "60-80 uderzeń na minute", "Powyżej 100 uderzen na minute", "Poniżej 40 uderzeń na minute"},
            {"Powyżej 150 mg/dl", "Poniżej 60mg/dl", "60-100 mg/dl", "0-50 mg/dl"},
            {"Słodkie jedzenie", "Tłuste jedzenie", "Kwaśne jedzenie", "Jedzenie białka zwierzęcego"},
            {"Sport wyczynowy", "Ograniczenie białka zwierzęcego", "Wysiłek fizyczny i niepalenie papierosów", "Jedzenie słodkich pokarmów"},
            {"34.0", "36.6", "Powyżej 40.0", "Każda temperatura jest prawidłowa."}



    };

    private String mCorrectAnswer[] = {"Do 200 mg/dl", "60-80 uderzeń na minute", "60-100 mg/dl", "Tłuste jedzenie", "Wysiłek fizyczny i niepalenie papierosów", "36.6"};

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a) {
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a) {
        String choice = mChoices[a][2];
        return choice;
    }

    public String getChoice4(int a) {
        String choice = mChoices[a][3];
        return choice;
    }

    public String getCorrectAnwer(int a) {
        String answer = mCorrectAnswer[a];
        return answer;
    }
}
