/**
 * Simple version of Wordle, player gets 6 guesses, all 5-letter guesses are valid
 * - reads list from file and randomly selects answer
 * - displays result with:
 *    - uppercase letter for direct match (letter in correct position)
 *    - lowercase letter for indirect match (letter in word but different position)
 *    - underscore for letter that is not in word 
 * - uses Character array lists, with an auxiliary list for indirect matches
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
public class Wordle{
    public static void main(String[] args) throws FileNotFoundException{
        // constants
        final int WORD_LENGTH = 5;      // word length obviously

        // create objects needed for i/o and random number
        Scanner f = new Scanner(new File("ReadMe.txt"));    // for word list
        Scanner kb = new Scanner(System.in);                // user input/guesses
        Random rand = new Random();                         // to get word from list

        // Arraylists for the word, the guess the hint and the analysis
        ArrayList<Character> answer = new ArrayList<>();    // game's answer as list 
        ArrayList<Character> guess = new ArrayList<>();     // user's guess as list
        ArrayList<Character> result = new ArrayList<>();    // result of guess
        ArrayList<Character> unmatched = new ArrayList<>(); // auxiliary list to help find indirect matches

        // variables
        String answerAsString;          // the word to be guessed
        String guessAsString;           // guess read from the keyboard

        int numGuesses = 0;             // keep track of how many guesses have been made

        // get the wordle answer of the day
        ArrayList<String> words = new ArrayList<>();
        while(f.hasNext()){
            words.add(f.next());
        }
        answerAsString = "CHORE";     // for testing

        // convert the String into an ArrayList of Characters
        // String answerAsString = words.get(rand.nextInt(words.size()));
        populateCharacters(answerAsString, answer);

        System.out.println("Let's play wordle!");
        numGuesses = 0;         // make sure we start at 0 guesses

        // assume that we want to play at least one gaje
        do{
            // reset array lists for each guess
            // guess = new ArrayList<>();
            // unmatched = new ArrayList<>();
            // result = new ArrayList<>();
            guess.clear();
            unmatched.clear();
            result.clear();

            // get guess from user make sure it's got 5 letters
            System.out.print("Guess #" + ++numGuesses + ": ");
            guessAsString = kb.next().toUpperCase();

            // make sure the input is a 5 letter word
            while(guessAsString.length() != WORD_LENGTH){    // ensure guess has 5 chars
                System.out.print("Your guess must be 5 letters in length. Guess again: ");
                guessAsString = kb.next().toUpperCase();    
            }// end force 5 letter word

            // convert the guess to an ArrayList of Characters
            populateCharacters(guessAsString, guess);

            // print out the guess
            for (Character c : guess) 
                System.out.print(c + " ");

            // analyse the guess
            // go through all the letters to see if there is a direct match: pairwise comparison
            for (int i=0; i<WORD_LENGTH; i++){
                char answerChar = answer.get(i);
                char guessChar = guess.get(i);
                if (answerChar == guessChar){
                    result.add(i, answerChar);  // if direct match, set the corresponding result element to the letter
                }// end direct match
                else {
                    result.add(i, '_');         // not a direct match, set underscore for now   
                    unmatched.add(guessChar);   // add to list of of unmatched letters 
                }// end not direct match        // note this is an unmatched guess letter 
            }// end for, scan for direct matches

            // go through the letters in the answer to find the indirect matches
            for (int i=0; i<WORD_LENGTH; i++){
                char answerChar = answer.get(i);
                char resultChar = result.get(i);
                if (resultChar == '_'){         // if it is not a match
                    // if the answer char is in the unmatched list, update corresponding result element to lowercase
                    if (unmatched.contains(answerChar)){
                        // get the position of the match in guess, assign lowercase to the corresponding result position
                        result.set(guess.indexOf(answerChar), Character.toLowerCase(answerChar));
                        unmatched.remove((Character)answerChar);   // remove from unmatched;
                    }
                }                
            } 

            // print result of guess 
            // prints the codes a A or _
            System.out.println();
            for (Character c : result) 
                System.out.print(c + " ");
                
            System.out.println();
        }while (numGuesses < 6 && !answer.equals(guess));

        // display result
        System.out.println(answer.equals(guess) ? "You guessed today's Wordle!" : "Sorry not today! Answer: " + answerAsString);
    }

    // add Characters to array list from String
    public static void populateCharacters(String word, ArrayList<Character> list){
        for (int i=0; i<word.length(); i++){
            list.add(word.charAt(i));
        }        
    }
}
