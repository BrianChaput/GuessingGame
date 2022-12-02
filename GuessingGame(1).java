// Brian Chaput
// CS-145
// 9-24-22
//
// This program plays a guessing game with the user. The program thinks of a number 
// between 1 and 100 and the user guesses until they are right.  After 
// each guess, the program tells the user whether the guess is too high or too low.  

import java.util.*;

public class GuessingGame {

  //This method calls the intro method, and then the playGame method
  public static void main(String[] args) {
    
    Scanner console = new Scanner(System.in);
    
    intro();
    int game = 1;
    int totalGuess = 0;
    int best = 100;
    int totalGame = 0;
    boolean playAgain = true;
    while (playAgain) {
      totalGame++;
      int guess = playGame(console);
      totalGuess += guess;
      if (guess < best) {
        best = guess;
      }
;
      System.out.print("Do you want to play again? ");
      String answer = console.next();
      if (!answer.toLowerCase().startsWith("y")) {
        playAgain = false;
      }
    }
    report(totalGame, totalGuess, best);
  }

  // Introduce the game to the user. 
  public static void intro() {
    System.out.println("This program allows you to play a guessing game.");
    System.out.println("I will think of a number between 1 and 100 and will allow you to");
    System.out.println("guess until you get it.  For each guess, I will tell you");
    System.out.println("whether the right answer is higher or lower than your guess.");
    System.out.println();
  }

  // Play one game, with the user getting guesses until the guess matches the answer.
  // Returns the number of guesses that the user makes.
  public static int playGame(Scanner console) {
    Random r = new Random();
    int answer = r.nextInt(100) + 1;
    System.out.println("I'm thinking of a number between 1 and 100...");
    int guess = 0;
    int count = 0;
    while (guess != answer) {
      System.out.print("Your guess? ");
      guess = console.nextInt();
      count++;
      if (guess < answer) {
        System.out.println("It's higher.");
      } else if (guess > answer) {
          System.out.println("It's lower.");
      }
    }
    System.out.println("You got it right in " + count + " guesses");
    System.out.println();
    return count;
  }


  // Report the overall results of all games played.
  public static void report(int totalGames, int totalGuesses, int bestGame) {
    System.out.println("Overall results:");
    System.out.println("    total games   = " + totalGames);
    System.out.println("    total guesses = " + totalGuesses);
    System.out.println("    guesses/game  = " + ((double) totalGuesses / totalGames));
    System.out.println("    best game     = " + bestGame);
  }
}

