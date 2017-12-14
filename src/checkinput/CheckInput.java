package checkinput;

import java.util.InputMismatchException;
import java.util.Scanner;
import restaurantjava.UI;

public class CheckInput {

    public static int readUserInputInt() {

        //Scanner sc=new Scanner(System.in);
        int a=0;
        System.out.println("ENTER THE INTEGER");

        try {
            a = UI.scanner.nextInt();
            try {

                if (a < 0) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("NO negative numbers please....ENTER AGAIN");
                readUserInputInt();
            }

        } catch (InputMismatchException e) {
            System.out.println("YOU ENTERED A STRING,ENTER AGAIN");
            readUserInputInt();
        } 

//        while (!UI.scanner.hasNextInt()) {
//            System.out.print("You didn't enter a number, please try again: ");
//            UI.scanner.next();
//        }
//        int inputInt = UI.scanner.nextInt();
//        UI.scanner.nextLine();
        return a;
    }

    public static String readUserInputString() {
        while (!UI.scanner.hasNextLine()) {
            System.out.print("You didn't enter letters, please try again: ");
            UI.scanner.next();
        }
        String inputString = UI.scanner.nextLine();
        return inputString;
    }
}
