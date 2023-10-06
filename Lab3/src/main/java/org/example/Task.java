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

    public String getEnteredText() {
        return enteredText;
    }

    public void setEnteredText(String enteredText) {
        this.enteredText = enteredText;
    }

    public String getReplacementText() {
        return replacementText;
    }

    public void setReplacementText(String replacementText) {
        this.replacementText = replacementText;
    }

    public int getWordLength() {
        return wordLength;
    }

    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }
    public String changeSpecialWordsToReplacementString() {
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
        return finalText.toString();
    }

    private boolean isValidPassword (String password){
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
            return false;
        if (!upperCaseMatcher.find())
            return false;
        if (!lowerCaseMatcher.find())
            return false;
        if (!digitsMatcher.find())
            return false;
        if (!specialSymbolsMatcher.find()) {
            return false;
        }
        return true;
    }

    public String printPasswordValidity(String password) {
        if (isValidPassword(password)) {
            return "Your password is valid";
        } else {
            return "Your password is invalid. " + getValidationErrorMessage(password);
        }
    }

    private String getValidationErrorMessage(String password) {
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
            return "Minimum length is 8 characters";
        if (!upperCaseMatcher.find())
            return "Required at least one capital letter";
        if (!lowerCaseMatcher.find())
            return "Required at least one small letter";
        if (!digitsMatcher.find())
            return "Required at least one number";
        if (!specialSymbolsMatcher.find()) {
            return "Required at least one special symbol";
        }
        return "Your password is valid";
    }
}
