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
        Scanner f = new Scanner(new File("As3Q2.txt"));    // for word list
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
        //answerAsString = "CHORE";     // for testing
        answerAsString = words.get(rand.nextInt(words.size()));
        System.out.println(answerAsString); // also for testing

        // convert the answer string to a char arraylist
        populateCharacters(answerAsString, answer);

        System.out.println("Let's play wordle!");
        numGuesses = 0;         // make sure we start at 0 guesses

        // assume that we want to play at least one gaje
        do{
            /* we can either create new arraylists here
             * and let garbage collection get rid of the old
             * ones or use .clear() to empty out the existing
             */
            
            // reset array lists for each guess
            // guess = new ArrayList<>();
            // unmatched = new ArrayList<>();
            // result = new ArrayList<>();
            guess.clear();
            unmatched.clear();
            result.clear();

            // get guess from user make sure it's got 5 letters
            System.out.print("Guess #" + ++numGuesses + ": ");
            
            /* allow the guess to be in any case
             * convert the guess to upper case
             */
            guessAsString = kb.next().toUpperCase();

            // make sure the input is a 5 letter word
            /* this could be done using a do-while loop
             * but error prompt would have to be accounted for
             */
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
                // get the coorsponding chars from guess and answer
                char answerChar = answer.get(i);
                char guessChar = guess.get(i);
                
                // if they match we have a direct match
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
                // get the cooresponding chars from both the answer and the hint lists
                char answerChar = answer.get(i);
                char resultChar = result.get(i);
                
                // only test on positions in the list that match unmatched positions
                if (resultChar == '_'){         // if it is not a match
                    // if the answer char is in the unmatched list, update corresponding result element to lowercase
                    if (unmatched.contains(answerChar)){
                        // get the position of the match in guess, assign lowercase to the corresponding result position
                        result.set(guess.indexOf(answerChar), Character.toLowerCase(answerChar));
                        unmatched.remove((Character)answerChar);   // remove from unmatched;
                    }// end current char is in unmatched
                }// end if not matched                
            }// end for 

            // print result of guess 
            // prints the codes a A or _
            System.out.println();
            for (Character c : result) 
                System.out.print(c + " ");
                
            System.out.println();
        // terminate the loop after 6 guesses or a correcdt guess
        }while (numGuesses < 6 && !answer.equals(guess));

        // display result
        System.out.println(answer.equals(guess) ? "You guessed today's Wordle!" : "Sorry not today! Answer: " + answerAsString);
    }// end main

    // add Characters to array list from String
    public static void populateCharacters(String word, ArrayList<Character> list){
        for (int i=0; i<word.length(); i++){
            list.add(word.charAt(i));
        }// enbd for       
    }// end populate character
}
