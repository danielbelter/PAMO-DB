package com.example.bmi_kotlin

class Questions {
    var mQuestions = arrayOf(
        "Ile wynosi prawidłowy poziom cholesterolu ?",
        "Jakie jest prawidłowe tętno ?",
        "Jaki jest prawidłowy poziom cukru we krwi ?",
        "Wątrobie najbardziej szkodzi ?",
        "Sercu pomaga ?",
        "Jaka jest prawidłowa temperatura ciała ?"
    )
    private val mChoices =
        arrayOf(
            arrayOf(
                "300 ml/dl",
                "100 mg/dl",
                "500 mg/dl",
                "Do 200 mg/dl"
            ),
            arrayOf(
                "80-100 uderzeń na minute",
                "60-80 uderzeń na minute",
                "Powyżej 100 uderzen na minute",
                "Poniżej 40 uderzeń na minute"
            ),
            arrayOf(
                "Powyżej 150 mg/dl",
                "Poniżej 60mg/dl",
                "60-100 mg/dl",
                "0-50 mg/dl"
            ),
            arrayOf(
                "Słodkie jedzenie",
                "Tłuste jedzenie",
                "Kwaśne jedzenie",
                "Jedzenie białka zwierzęcego"
            ),
            arrayOf(
                "Sport wyczynowy",
                "Ograniczenie białka zwierzęcego",
                "Wysiłek fizyczny i niepalenie papierosów",
                "Jedzenie słodkich pokarmów"
            ),
            arrayOf(
                "34.0",
                "36.6",
                "Powyżej 40.0",
                "Każda temperatura jest prawidłowa."
            )
        )
    private val mCorrectAnswer = arrayOf(
        "Do 200 mg/dl",
        "60-80 uderzeń na minute",
        "60-100 mg/dl",
        "Tłuste jedzenie",
        "Wysiłek fizyczny i niepalenie papierosów",
        "36.6"
    )
    fun getQuestion(a: Int): String? {
        return mQuestions[a]
    }
    fun getChoice1(a: Int): String? {
        return mChoices[a][0]
    }

    fun getChoice2(a: Int): String? {
        return mChoices[a][1]
    }

    fun getChoice3(a: Int): String? {
        return mChoices[a][2]
    }

    fun getChoice4(a: Int): String? {
        return mChoices[a][3]
    }

    fun getCorrectAnwer(a: Int): String? {
        return mCorrectAnswer[a]
    }
}