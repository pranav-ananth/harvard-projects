/**
 * File: com.wordle.Wordle.java
 * @author Pranav Ananth
 * @version 12/21/2024
 * This module is the starter file for the com.wordle.Wordle assignment.
 * This program creates a com.wordle.Wordle game.
 */

package com.wordle;

import java.awt.Color;
import java.util.*;
import java.util.List;
import javax.swing.Timer;

public class Wordle {
    
    /* Private instance variables */
    // TODO: Add any extra instance variables here, if any
    private WordleGWindow gw;
    private String word;
    private Map<String, String> mapOfGuesses = new HashMap<String, String>();
    private Timer timer = new Timer(500, e -> colorRow());
    private static final Color[] RAINBOW_COLORS = {
            new Color(255, 0, 0), // Red
            new Color(255, 165, 0), // Orange
            new Color(207, 207, 34), // Yellow
            new Color(144, 238, 144), // Green
            new Color(37, 146, 212), // Blue
            new Color(75, 0, 130), // Indigo
            new Color(148, 0, 211) // Violet
    };
    private int colorIndex = 0;
    
    public void run() {
        // DEBUG: useful for testing
        word = chooseWord(); // choose random word
        gw = new WordleGWindow();
        gw.addEnterListener((s) -> enterAction(s));
        System.out.println("Guess word is : " + word);
    }
    
    /**
     * @return a word that is balanced choice from the dictionary
     * Extension : Make more balanced choices from the dictionary.
     * Returns a random word from com.wordle.WordleDictionary. If that word ends in an S, 66% of those will be rerolled.
     */
    public String chooseWord(){
        while(true) {
            int i = getRandomNumber(0, WordleDictionary.FIVE_LETTER_WORDS.length - 1);
            String chosenWord = ((String) WordleDictionary.FIVE_LETTER_WORDS[i]).toUpperCase();
            if(chosenWord.charAt(chosenWord.length()-1) == 'S') {
                if(getRandomNumber(0, 2) == 2) {
                    return chosenWord;
                }
            }
            else {
                return chosenWord;
            }
        }
    }

    /**
     *
     * @param min
     * @param max
     * @return A random number in the range between min and max
     */
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    /*
     * Called when the user hits the RETURN key or clicks the ENTER button,
     * passing in the string of characters on the current row.
     */
    public void enterAction(String s) {
        if(s.length() < 5) {
            System.out.println(listOfPossibleWords(mapOfGuesses, WordleDictionary.FIVE_LETTER_WORDS));
        }
        else {
            boolean found = false;
            for (int i = 0; i < WordleDictionary.FIVE_LETTER_WORDS.length; i++) {
                if (s.compareToIgnoreCase( (String) WordleDictionary.FIVE_LETTER_WORDS[i]) == 0) {
                    found = true;
                    break;
                }
            }
            if (found) {
                String output = getHint(s, word);
                mapOfGuesses.put(s, output);
                System.out.println("The output from gethint is " + output);
                for (int i = 0; i < s.length(); i++) {
                    char ch = output.charAt(i);
                    // Color squares/keys
                    if (Character.isUpperCase(ch)) {
                        gw.setSquareColor(gw.getCurrentRow(), i, WordleGWindow.CORRECT_COLOR);
                        gw.setKeyColor(String.valueOf(ch), WordleGWindow.CORRECT_COLOR);
                    }
                    else if (ch == '*') {
                        gw.setSquareColor(gw.getCurrentRow(), i, WordleGWindow.MISSING_COLOR);
                        gw.setKeyColor(s.substring(i, i+1), WordleGWindow.MISSING_COLOR);
                    }
                    else {
                        if (gw.getKeyColor(String.valueOf(ch).toUpperCase()) != WordleGWindow.CORRECT_COLOR) {
                            gw.setKeyColor(String.valueOf(ch).toUpperCase(), WordleGWindow.PRESENT_COLOR);
                        }
                        gw.setSquareColor(gw.getCurrentRow(), i, WordleGWindow.PRESENT_COLOR);
                    }
                }
                // Check if solution is right
                if(output.equals(word)) {
                    gw.showMessage("Nice work!");
                    timer.start();
                }
                else {
                    // Check if there are still guesses left
                    if(gw.getCurrentRow() < gw.N_ROWS - 1) {
                        gw.setCurrentRow(gw.getCurrentRow()+1);
                    }
                    else {
                        gw.showMessage("Too bad...the word was " + word.toLowerCase());
                    }
                }
            }
            else {
                gw.showMessage("Not in word list");
            }
        }

    }

    /**
     * @param guess the user's guess
     * @param word the secret word to be guessed
     * @return a String version of the hint where a capital letter
     * represents a correct guess at the correct location, a lower
     * case letter represents a correct guess at the wrong location,
     * and a '*' represents an incorrect letter (neither in the
     * correct place nor a correct letter anywhere in the word)
     *
     * You will use this helper method when coloring the squares.
     * It's also the crucial method that is tested in codePost.
     *
     * Examples:
     * word        = "CLASS"
     * guess       = "SASSY"
     * returns:      "sa*S*"
     *
     * word        = "FLUFF"
     * guess       = "OFFER"
     * returns:      "*ff**"
     *
     * word        = "STACK"
     * guess       = "TASTE"
     * returns:      "tas**"
     *
     * word        = "MYTHS"
     * guess       = "HITCH"
     * returns:      "h*T**"
     *
     */

    public static String getHint(String guess, String word) {
        StringBuilder hint = new StringBuilder("*****");
        // Boolean array to track matched letters in the word
        boolean[] matched = new boolean[word.length()];

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == word.charAt(i)) {
                hint.setCharAt(i, Character.toUpperCase(guess.charAt(i)));
                matched[i] = true; // Mark this position as matched
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            if (hint.charAt(i) != '*')
                continue; // Skip already matched characters
            char guessChar = guess.charAt(i);

            // Check if the guessed character exists elsewhere in the word
            for (int j = 0; j < word.length(); j++) {
                if (guessChar == word.charAt(j) && !matched[j]) {
                    hint.setCharAt(i, Character.toLowerCase(guessChar));
                    matched[j] = true; // Mark this position as matched
                    break; // Stop checking after finding the first match
                }
            }
        }

        return hint.toString();
    }

    /**

     * @param guessToClue a Map of guesses (so far) with their associated clues
     * @param dictionary the dictionary used for this com.wordle.Wordle
     * @return a List of all the possible words (given the guesses and clues so far)
     * example:
     * guessToClue = {OMENS=**e**, HELMS=*el**, GRASP=G****, LYART=l****}
     * returns the following list of possible words: [glide, glued, guile]
     * Required Extension : Create an option that lists all possible words that are legal given the previous guesses
     */

    public static List<String> listOfPossibleWords(Map<String, String> guessToClue, String[] dictionary) {
        List<String> list = new ArrayList<>();
        for(String word : dictionary) {
            Boolean newIndex = true;
            for (String guess : guessToClue.keySet()) {
                String clue = guessToClue.get(guess);
                String hint = getHint(guess, word.toUpperCase());
                if(!clue.equals(hint)) {
                    newIndex = false;
                    break;
                }
            }
            if(newIndex) {
                list.add(word);
            }
        }

        return list;
    }

    /**
     * Extension: Enhance the graphics when the user wins the game.
     * Changes the color of the current row to the next color of the rainbow. Once all the colors
     * have been cycled through, the color switches back to the correct guess color.
     */

    public void colorRow() {
        Color nextColor = RAINBOW_COLORS[colorIndex];
        for(int i = 0; i < gw.N_COLS; i++) {
            gw.setSquareColor(gw.getCurrentRow(), i, nextColor);
        }

        if(colorIndex == RAINBOW_COLORS.length - 1) {
            timer.stop();
            for(int i = 0; i < gw.N_COLS; i++) {
                gw.setSquareColor(gw.getCurrentRow(), i, WordleGWindow.CORRECT_COLOR);
            }
        }
        else
            colorIndex++;
    }

/* Startup code */

    public static void main(String[] args) {
        new Wordle().run();
    }


}