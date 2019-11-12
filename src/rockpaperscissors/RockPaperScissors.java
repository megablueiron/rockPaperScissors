/*
 * Michael Botros
 * Nov 12, 2019
 * This is a rock paper scissors program that pits a user against a computer and tells the user their score
 */

package rockpaperscissors;
import java.util.Scanner;
/**
 *
 * @author mibot3117
 */
public class RockPaperScissors {
    //declaring global variables that would be used in main and custom methods
    static int amountWon = 0;
    static int amountLost = 0;
    static int amountTied = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //creating a new scanner object
        Scanner keyedInput = new Scanner(System.in);
        
        //declaring all variables and constants
        final int CHOICE_RANGE = 2;
        int opponentChoice = 0; 
        int playerChoice = 0;
        String playerChoiceString;
        
        //creating a string based array that holds all the possible answers that the user can use
        String [] choice = {"rock","paper","scissors"};
        
        //creating a menu using a do while loop that will repeat as long as the user doesn't use the exit option
        do {
            System.out.println("------------Rock Paper Scissors-------------");
            System.out.println("Type 'rock' to select rock");
            System.out.println("Type 'paper' to select paper");
            System.out.println("Type 'scissors' to select scissors");
            System.out.println("Type anything else to exit");
            System.out.println("Your score: " + amountWon);
            System.out.println("Enemy score: " + amountLost);
            System.out.println("Stalemate count: " + amountTied);
            
            //takes the users choice and makes it lowercase to make it match the possible choices
            playerChoiceString = keyedInput.nextLine();
            playerChoiceString.toLowerCase();
            
            //converts the user's choice into a numerical value
            if (playerChoiceString.equals (choice[0])) {
                playerChoice = 1;
            } else if (playerChoiceString.equals (choice[1])) {
                playerChoice = 2;
            } else if (playerChoiceString.equals (choice[2])) {
                playerChoice = 3;
            } else {
                playerChoice = 4;
            }
            
            //randomly generating the opponents choice
            opponentChoice = randomGenerator(CHOICE_RANGE);
            
            //Taking the player's and opponent's choices and figuring out the result
            result(playerChoice, opponentChoice);
            
            } while (playerChoice!=4);
        }
    
/**
 * result() takes two choices between 1 and 3 and puts it through nested if statements that determine the correct outcome
 * @param n1 is the player's choice stored as an integer
 * @param n2 is the opponent's choice stored as an integer
 * @return none
 */
public static void result(int n1, int n2) {
    
    
    if (n1 == 1) {
        //determining all possible outcomes if the player selects rock and then outputting results
        if (n2 == 1) {
            System.out.println("Your play");
            printRock();
            System.out.println("Opponent's play");
            printRock();
            System.out.println("You tied!");
            increaseTied();
        }
        else if (n2 == 2) {
            System.out.println("Your play");
            printRock();
            System.out.println("Opponent's play");
            printPaper();
            System.out.println("You lost!");
            increaseLost();
        }
        else {
            System.out.println("Your play");
            printRock();
            System.out.println("Opponent's play");
            printScissors();
            System.out.println("You won!");
            increaseWon();
        }
    }
    else if (n1 == 2) {
        //determining all possible outcomes if the player selects paper and then outputting results
        if (n2 == 1) {
            System.out.println("Your play");
            printPaper();
            System.out.println("Opponent's play");
            printRock();
            System.out.println("You won!");
            increaseWon();
        }
        else if (n2 == 2) {
            System.out.println("Your play");
            printPaper();
            System.out.println("Opponent's play");
            printPaper();
            System.out.println("You tied!");
            increaseTied();
        }
        else {
            System.out.println("Your play");
            printPaper();
            System.out.println("Opponent's play");
            printScissors();
            System.out.println("You lost!");
            increaseLost();
        }
        
    }
    else {
        //determining all possible outcomes if the player selects scissors and then outputting results
        if (n2 == 1) {
            System.out.println("Your play");
            printScissors();
            System.out.println("Opponent's play");
            printRock();
            System.out.println("You lost!");
            increaseLost();
        }
        else if (n2 == 2) {
            System.out.println("Your play");
            printScissors();
            System.out.println("Opponent's play");
            printPaper();
            System.out.println("You won!");
            increaseWon();
        }
        else {
            System.out.println("Your play");
            printScissors();
            System.out.println("Opponent's play");
            printScissors();
            System.out.println("You tied!");
            increaseTied();
        }
    }
}

/**
 * randomGenerator() randomly generates a number between 1 and n1
 * @param n1 the range of numbers stored as an integer
 * @return the resulting random number as an integer
 */
public static int randomGenerator(int n1) {
    
    int randomNumber = (int)Math.round(Math.random()*n1+1);
    return(randomNumber);
}

/**
 * increaseWon() increases the global variable amountWon by 1
 */
public static void increaseWon() {
    amountWon = amountWon + 1;
}

/**
 * increaseLost() increases the global variable amountLost by 1
 */
public static void increaseLost() {
    amountLost = amountLost + 1;
}

/**
 * increaseTied() increases the global variable amountTied by 1
 */
public static void increaseTied() {
    amountTied = amountTied + 1;
}

/**
 * printRock() outputs ASCII art for rock on the output stream
 */
public static void printRock() {
    System.out.println("    _______\n" + "---'   ____)\n" + "      (_____)\n" + "      (_____)\n" + "      (____)\n" + "---.__(___)");

}

/**
 * printPaper() outputs ASCII art for paper on the output stream
 */
public static void printPaper() {
    System.out.println("     _______\n" + "---'    ____)____\n" + "           ______)\n" + "          _______)\n" + "         _______)\n" + "---.__________)");
}

/**
 * printScissors() outputs ASCII art for scissors on the output stream
 */
public static void printScissors() {
    System.out.println("    _______\n" + "---'   ____)____\n" + "          ______)\n" + "       __________)\n" + "      (____)\n" + "---.__(___)");
}

}


