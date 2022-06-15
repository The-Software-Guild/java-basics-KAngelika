import java.util.Scanner;

public class HealthyHearts {
    public static void main (String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("What is your age?");
        String age = keyboard.nextLine();

        int ageNum = -999;
        try{
            ageNum = Integer.parseInt(age);
        }catch(NumberFormatException e){
            System.out.println("You have not entered a valid number!");
        }

        if (ageNum == -999) {
            System.out.println("You cannot proceed with the calculation");
        } else {
            int maxHeartRate = 220 - ageNum;
            int minHRTarget = (int) Math.round(maxHeartRate * 0.5);
            int maxHRTarget = (int) Math.round(maxHeartRate * 0.85);

            System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute");
            System.out.println("Your target zone is " + minHRTarget + " - " + maxHRTarget + " beats per minute");
        }




    }
}
