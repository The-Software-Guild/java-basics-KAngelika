import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class RockPaperScissors {
    public static void main(String[] args) {
        String choice = "";
        int compChoice = 1;
        int noRounds = 0;
        int userRoundsNum = 0;
        String response = "";

        Scanner keyboard = new Scanner(System.in);
        Random generator = new Random();

        while (true) {
            do{
                System.out.println("How many rounds would you like to play? ");
                String userRounds = keyboard.nextLine();
                try {
                    userRoundsNum = Integer.parseInt(userRounds);
                } catch (NumberFormatException e){
                    System.out.println("You have not entered a valid number!");
                    userRoundsNum = -999;
                }
            } while (!isValidRoundsNum(userRoundsNum));

            if ((userRoundsNum < 1) || (userRoundsNum > 10)) {
                System.out.println("You have entered too few or too many rounds!");
                System.out.println("You have exited the program");
                break;
            } else {
                do {
                    int choiceNum = 0;
                    do {
                        System.out.println("Please choose a number: 1 = rock, 2 = paper or 3 = scissors");
                        choice = keyboard.nextLine();
                        try {
                            choiceNum = Integer.parseInt(choice);
                        }catch (NumberFormatException e) {
                            System.out.println("You have not entered a number!");
                        }

                    } while (!isValidUserChoice(choiceNum));

                    int computChoice = generator.nextInt(3) + 1;

                    printResult(choiceNum, computChoice);

                    noRounds = noRounds + 1;
                }while (noRounds < userRoundsNum) ;
            }
            do {
                System.out.println("Would you like to continue? Please answer Y / N");
                response = keyboard.nextLine();
            } while (!isValidResponse(response));

            if (response.equalsIgnoreCase("N")) {
                System.out.println("Thanks for playing!");
                break;
            }
        }
    }

    private static boolean isValidRoundsNum(int userRoundsNum) {
        return (userRoundsNum >= 1) && (userRoundsNum <= 10);
    }
    private static void printResult(int choiceNum, int computChoice) {
        switch (choiceNum) {
            case 1:
                System.out.println("User choice: rock");
                if (computChoice == 1) {
                    System.out.println("Computer choice: rock ");
                    System.out.println("Result: tie");
                } else if (computChoice == 2) {
                    System.out.println("ComputerChoice: paper");
                    System.out.println("Result: computer wins");
                } else {
                    System.out.println("Computer choice: scissors");
                    System.out.println("Result: user wins");
                }
                break;
            case 2:
                System.out.println("User choice: paper");
                if (computChoice == 1) {
                    System.out.println("Computer choice: rock");
                    System.out.println("Result: computer wins");
                } else if (computChoice == 2) {
                    System.out.println("Computer choice: paper");
                    System.out.println("Result: tie");
                } else {
                    System.out.println("Computer choice: scissors");
                    System.out.println("Result: user wins");
                }
                break;
            case 3:
                System.out.println("User choice: scissors");
                if (computChoice == 1) {
                    System.out.println("Computer choice: rock");
                    System.out.println("Result: computer wins");
                } else if (computChoice == 2) {
                    System.out.println("Computer choice: paper");
                    System.out.println("Result: user wins");
                } else {
                    System.out.println("Computer choice: scissors");
                    System.out.println("Result: tie");
                }
        }
    }

    public static boolean isValidUserChoice (int choice) {
        ArrayList<Integer> validChoices = new ArrayList<>(Arrays.asList(1,2,3));
        return  validChoices.contains(choice);
    }
    public static boolean isValidResponse (String response) {
        return response.equalsIgnoreCase("N") || response.equalsIgnoreCase("Y");
    }

}
