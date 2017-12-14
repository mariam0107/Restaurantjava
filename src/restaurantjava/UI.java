package restaurantjava;

import java.util.Scanner;
import checkinput.CheckInput;

public class UI {

    public static Scanner scanner = new Scanner(System.in);

    public int showMainMenu() {
        System.out.println("**************************************");
        System.out.println("Welcome to Restaurant Java\nMain menu:");
        System.out.println("**************************************");
        System.out.println("1.Manage employee");
        System.out.println("2.Show statistics");
        System.out.println("3.Terminate Restaurant Java");
        System.out.print("Enter your choice:");

        int mainMenuInput = CheckInput.readUserInputInt();
        return mainMenuInput;
    }

    public int showManageEmployeeMenu() {
        System.out.println("--------------------------------------");
        System.out.println("Manage employee:");
        System.out.println("--------------------------------------");
        System.out.println("1.Show all staff information");
        System.out.println("2.Show individual employee");
        System.out.println("3.Update employee information");
        System.out.println("4.Add new employee");
        System.out.println("5.Remove employee");
        System.out.println("6.Go back to main menu");
        System.out.print("Enter your choice:");

        int employeeMenuInput =  CheckInput.readUserInputInt();
        return employeeMenuInput;
    }

    public int showStatisticsMenu() {
        System.out.println("--------------------------------------");
        System.out.println("Show statistics:");
        System.out.println("--------------------------------------");
        System.out.println("1.Show average salary");
        System.out.println("2.Show average salary per profession");
        System.out.println("3.Show total bonus");
        System.out.println("4.Show total bonus per profession");
        System.out.println("5.Show gender distribution");
        System.out.println("6.Show gender distribution per profession");
        System.out.println("7.Show highest and lowest salary");
        System.out.println("8.Go back to main menu");
        System.out.print("Enter your choice:");

        int statisticsMenuInput =  CheckInput.readUserInputInt();
        return statisticsMenuInput;
    }

}