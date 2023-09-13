package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
    private String enteredText;
    private String replacementText;
    private int wordLength;
    public Task(String enteredText, String replacementText, int wordLength) {
        this.enteredText = enteredText;
        this.replacementText = replacementText;
        this.wordLength = wordLength;
    }
    public StringBuilder changeSpecialWordsToReplacementString() {
        // solves 1st task
//        String[] words = enteredText.trim().split(" ");

        // solves 3rd task
        String regExp = "[\\W]+";
        String[] words = enteredText.trim().split(regExp);

        StringBuilder finalText = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == wordLength)
                finalText.append(replacementText);
            else
                finalText.append(words[i]);
            finalText.append(" ");
        }
        return finalText;
    }

    public static boolean checkPassword (String password) throws Exception {
        int minLength = 8;
        Pattern upperCase = Pattern.compile("[A-Z]+");
        Pattern lowerCase = Pattern.compile("[a-z]+");
        Pattern digits = Pattern.compile("[\\d]+");
        Pattern specialSymbols = Pattern.compile("[\\W]+");

        Matcher upperCaseMatcher = upperCase.matcher(password);
        Matcher lowerCaseMatcher = lowerCase.matcher(password);
        Matcher digitsMatcher = digits.matcher(password);
        Matcher specialSymbolsMatcher = specialSymbols.matcher(password);

        if (password.length() < minLength)
            throw new Exception("Minimum length is 8 characters");
        if (!upperCaseMatcher.find())
            throw new Exception("Required at least one capital letter");
        if (!lowerCaseMatcher.find())
            throw new Exception("Required at least one small letter");
        if (!digitsMatcher.find())
            throw new Exception("Required at least one number");
        if (!specialSymbolsMatcher.find())
            throw new Exception("Required at least one special symbol");
        return true;
    }
}
