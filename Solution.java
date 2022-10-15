import java.util.Scanner;
import java.io.*;

import javax.swing.JOptionPane;

public class Solution {
    /**
     * @param args
     */
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int randomnumber = (int)(Math.random()*100+1);
        int guessedNumber = 0;
        int attempts = 1;
        while(guessedNumber != randomnumber){
            String response = JOptionPane.showInputDialog(null,"Enter a number between 1 and 100",5);
            guessedNumber = Integer.parseInt(response);
            JOptionPane.showMessageDialog(null, Guess(guessedNumber, randomnumber, attempts ));
            attempts++;
        }
         
        
    }
        public static String Guess(int guessedNumber, int randomnumber, int attempts){
    while(attempts<=5 && attempts>0) {
        if(guessedNumber <= 0 || guessedNumber > 100){
            return "Make sure that the guess is in the range given:";
        }
        else if(guessedNumber == randomnumber){
            return "Congratulations!! You won the game in "+attempts +" guesses\n Your score is "+50*(6-attempts)+".....";
        }
        else if(guessedNumber > randomnumber){
            
            return "Your guess is greater than the required number, \n Try again in: "+(6-attempts) +" guesses";
            }
               else if(guessedNumber < randomnumber){
            return "Your guess is lower than the required number, \n Try again in: "+(6-attempts) +" guesses";
        }
        else{
            return "Incorrect guess!! Try again";
        }
        
        }
    return "You exceeded maximum attempts Better luck next time.. The number to be guessed is "+randomnumber+".🤖️";
    }
}
