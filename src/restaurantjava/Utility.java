package restaurantjava;
import checkinput.CheckInput;

public class Utility {

    UI ui = new UI();
    StaffManagement staff;

    public Utility(StaffManagement staff) {
        this.staff = staff;

    }

    public boolean start() {
        int mainMenuInput = ui.showMainMenu();
        boolean continueMainMenu = true;

        switch (mainMenuInput) {

            case 1:
                handleManageEmployee();
                break;
            case 2:
                handleStatisticsMenu();
                break;
            case 3:
                continueMainMenu = false;
                break;
            default :
                System.out.println("You didn't enter a number that matched the choice");
        }
        return continueMainMenu;
    }

    public void handleManageEmployee() {
        boolean continueHandleManageEmployee = true;
        while (continueHandleManageEmployee) {
            int choice1 = ui.showManageEmployeeMenu();
            switch (choice1) {
                case 1:
                    System.out.println("\nAll employees:");
                    staff.printAll();
                    break;
                case 2:
                    System.out.print("Enter employee ID:");
                    int id = CheckInput.readUserInputInt();
                    staff.showEmployeeInformation(id);
                    break;

                case 3:
                    System.out.print("Update employee by ID:");
                    int id2 = CheckInput.readUserInputInt();
                    staff.updateEmployee(id2);
                    break;

                case 4:
                    System.out.println("\nAdd new employee:");
                    System.out.println("Choose profession:\n1.Chef\n2.Waiter\n3.Bartender\n4.WasherUp");
                    System.out.print("Enter number:");
                    int choice3 = CheckInput.readUserInputInt();

                    switch (choice3) {
                        case 1:
                            createEmployeeChef();
                            break;
                        case 2:
                            createEmployeeWaiter();
                            break;
                        case 3:
                            createEmployeeBartender();
                            break;
                        case 4:
                            createEmployeeWasherUp();
                            break;
                        default:
                            System.out.println("You didn't enter a profession that matched the choice.");
                    }
                    break;

                case 5:
                    System.out.println("\nRemove employee by ID:");
                    System.out.print("Write ID of an employee that you want to remove:");
                    int id3 = CheckInput.readUserInputInt();
                    staff.removeEmployee(id3);
                    break;

                case 6:
                    continueHandleManageEmployee = false;
                    break;
                default:
                    // TODO fix if wrong input
                    System.out.println("You didn't enter a number that matched the choice");
            }
        }
    }

    public void handleStatisticsMenu() {
        boolean continueHandleStatistics = true;
        while (continueHandleStatistics) {
            int choice2 = ui.showStatisticsMenu();
            switch (choice2) {
                case 1:
                    System.out.println("\nShow average salary:");
                    System.out.println(staff.calculateAverageSalary());
                    break;
                case 2:
                    System.out.println("\nShow average salary per profession:");
                    System.out.print("Enter Chef, Bartender, Waiter or WasherUp: ");
                    String profession = CheckInput.readUserInputString();
                    System.out.println(staff.calculateAverageSalaryProfession(profession));
                    break;
                case 3:
                    System.out.println("\nShow total bonus:");
                    System.out.println(staff.calculateTotalBonusOverall());
                    break;
                case 4:
                    System.out.println("\nShow total bonus per profession:");
                    System.out.print("Enter Chef, Bartender, Waiter or WasherUp: ");
                    
                    String profession2 = CheckInput.readUserInputString();
                    if(profession2.equalsIgnoreCase("Chef") || profession2.equalsIgnoreCase("Bartender")
                || profession2.equalsIgnoreCase("Waiter") || profession2.equalsIgnoreCase("WasherUp"))
                    System.out.println(staff.calculateBonusProfession(profession2));
                    break;
                case 5:
                    System.out.println("\nShow gender distribution:");
                    staff.printGenderPercentTotal();
                    break;
                case 6:
                    System.out.println("\nShow gender distribution per profession:");
                    System.out.print("Enter Chef, Bartender, Waiter or WasherUp: ");
                    String profession3 = CheckInput.readUserInputString();
                    if(profession3.equalsIgnoreCase("Chef") || profession3.equalsIgnoreCase("Bartender")
                || profession3.equalsIgnoreCase("Waiter") || profession3.equalsIgnoreCase("WasherUp"))
                    staff.printGenderPercentProfession(profession3);
                    break;
                case 7:
                    System.out.println("\nShow highest and lowest salary:");
                    System.out.println("Higest salary is " + staff.highestSalary()
                            + " and lowest salary is " + staff.lowestSalary());
                    break;
                case 8:
                    continueHandleStatistics = false;
                    break;
                default:
                    // TODO fix if wrong input
                    System.out.println("You didn't enter a number that matched the choice");
            }
        }
    }

    public void createEmployeeBartender() {

        System.out.println("Enter full name");
        String name = CheckInput.readUserInputString();
        System.out.println("Enter address");
        String address = CheckInput.readUserInputString();
        System.out.println("Enter gender:\n1.male\n2.female\n3.unknown");
        int genderInt = CheckInput.readUserInputInt();
        GenderType gender;
        if (genderInt == 1) {
            gender = GenderType.MALE;
        } else if (genderInt == 2) {
            gender = GenderType.FEMALE;
        } else if (genderInt == 3) {
            gender = GenderType.UNKNOWN;
        }
        else {
            System.out.println("You entered no valid choice, gender is set to unknown");
            gender = GenderType.UNKNOWN;
        }

        System.out.println("Enter Salary");
        double salary = CheckInput.readUserInputInt();

        System.out.println("Enter number of drinkrecipes known:");
        int numberDrinks = CheckInput.readUserInputInt();

        Bartender bartender = new Bartender("Bartender", name, address, gender, salary, numberDrinks);
        staff.addEmployee(bartender);
        System.out.println("New employee added:");
        bartender.print();
    }

    public void createEmployeeChef() {

        System.out.println("Enter full name");
        String name = CheckInput.readUserInputString();
        System.out.println("Enter address");
        String address = CheckInput.readUserInputString();
        System.out.println("Enter gender:\n1.male\n2.female\n3.unknown");
        int genderInt = CheckInput.readUserInputInt();
        GenderType gender;
        if (genderInt == 1) {
            gender = GenderType.MALE;
        } else if (genderInt == 2) {
            gender = GenderType.FEMALE;
        } else if (genderInt == 3) {
            gender = GenderType.UNKNOWN;
        }
         else {
            System.out.println("You entered no valid choice, gender is set to unknown");
            gender = GenderType.UNKNOWN;
        }

        System.out.println("Enter Salary");
        double salary = CheckInput.readUserInputInt();

        System.out.println("Enter experiencelevel:\n1.Head\n2.Assistant");
        int levelInt = CheckInput.readUserInputInt();
        ExperienceLevelType level;
        if (levelInt == 1) {
            level = ExperienceLevelType.HEADCHEF;
        } else if (levelInt == 2) {
            level = ExperienceLevelType.ASSISTANTCHEF;
        }
        else {
            System.out.println("You entered no valid choice, experiencelevel is set to Assistant");
            level = ExperienceLevelType.ASSISTANTCHEF;
        }

        Chef chef = new Chef("Chef", name, address, gender, salary, level);
        staff.addEmployee(chef);
        System.out.println("New employee added:");
        chef.print();
    }

    public void createEmployeeWaiter() {

        System.out.println("Enter full name");
        String name = CheckInput.readUserInputString();
        System.out.println("Enter address");
        String address = CheckInput.readUserInputString();
        System.out.println("Enter gender:\n1.male\n2.female\n3.unknown");
        int genderInt = CheckInput.readUserInputInt();
        GenderType gender;
         if (genderInt == 1) {
            gender = GenderType.MALE;
        } else if (genderInt == 2) {
            gender = GenderType.FEMALE;
        } else if (genderInt == 3) {
            gender = GenderType.UNKNOWN;
        }
        else {
            System.out.println("You entered no valid choice, gender is set to unknown");
            gender = GenderType.UNKNOWN;
        }

        System.out.println("Enter Salary");
        double salary = CheckInput.readUserInputInt();

        System.out.println("Enter number of years experience:");
        int years = CheckInput.readUserInputInt();

        Waiter waiter = new Waiter("Waiter", name, address, gender, salary, years);
        staff.addEmployee(waiter);
        System.out.println("New employee added:");
        waiter.print();
    }

    public void createEmployeeWasherUp() {

        System.out.println("Enter full name");
        String name = CheckInput.readUserInputString();
        System.out.println("Enter address");
        String address = CheckInput.readUserInputString();
        System.out.println("Enter gender:\n1.male\n2.female\n3.unknown");
        int genderInt = CheckInput.readUserInputInt();
        GenderType gender;
         if (genderInt == 1) {
            gender = GenderType.MALE;
        } else if (genderInt == 2) {
            gender = GenderType.FEMALE;
        } else if (genderInt == 3) {
            gender = GenderType.UNKNOWN;
        }
        else {
            System.out.println("You entered no valid choice, gender is set to unknown");
            gender = GenderType.UNKNOWN;
        }

        System.out.println("Enter Salary");
        double salary = CheckInput.readUserInputInt();

        System.out.println("Enter number of years of employment:");
        int years = CheckInput.readUserInputInt();

        WasherUp washerUp = new WasherUp("WasherUp", name, address, gender, salary, years, 0);
        staff.addEmployee(washerUp);
        System.out.println("New employee added:");
        washerUp.print();
    }

}