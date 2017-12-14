package restaurantjava;

import checkinput.CheckInput;
import java.util.ArrayList;

public class StaffManagement {

    private ArrayList<Employee> staff = new ArrayList<>();

    public StaffManagement() {
        Chef chef1 = new Chef("Chef", "Bosse Hedman", "Home is were your heart is", GenderType.UNKNOWN, 25_000, ExperienceLevelType.HEADCHEF);
        Chef chef2 = new Chef("Chef", "Ingmar Jansson", "The big red building", GenderType.MALE, 20_000, ExperienceLevelType.ASSISTANTCHEF);
        Bartender b1 = new Bartender("Bartender", "Emily Smith", "Gamla Stan 123", GenderType.FEMALE, 17_000, 100);
        Bartender b2 = new Bartender("Bartender", "Jon Jonsson", "Slussen 11", GenderType.MALE, 10_000, 7);
        Waiter w1 = new Waiter("Waiter", "Samhal Meri", "Rågsved 9", GenderType.FEMALE, 14_000, 3);
        Waiter w2 = new Waiter("Waiter", "Noa Mark", "T-Centralen", GenderType.MALE, 7_000, 6);
        WasherUp wa1 = new WasherUp("WasherUp", "Tanya Wash", "Liljeholmen 4", GenderType.FEMALE, 8_000, 5, 3);
        WasherUp wa2 = new WasherUp("WasherUp", "Thomas Kras", "Mariatorget 3", GenderType.MALE, 5_000, 4, 300);

        staff.add(chef1);
        staff.add(chef2);
        staff.add(b1);
        staff.add(b2);
        staff.add(w1);
        staff.add(w2);
        staff.add(wa1);
        staff.add(wa2);
    }

    public int getNumberOfEmployees() {
        return staff.size();
    }

    public void addEmployee(Employee obj) {
        staff.add(obj);
    }

    public boolean removeEmployee(int id) {
        // Employee objToRemove = null;  // Alternative way to remove th employee
        for (Employee e : staff) {
            if (e.getID() == id) {
                System.out.println("The employee to be removed:");
                e.print();
                staff.remove(e);
                return true;
            }
        }
        System.out.println("No employee matching the ID, no employee was removed");
        return false;
//  // Alternative way to remove th employee
//        if (objToRemove!=null) {
//            staff.remove(objToRemove);
//        } 
//        else {
//            
//        }
    }

    public void updateEmployee(int Id) {
        Employee emp = null;
        for (Employee employee : staff) {
            if (employee.getID() == Id) {
                emp = employee;
                break;
            }
        }
        if (emp != null) {
            System.out.println("\nThe employee to be updated:");
            emp.print();

            System.out.println("\nWhat information do you want to update:\n1.Address\n2.Salary\n3.Profession specific feature");
            int choice = CheckInput.readUserInputInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter new address:");
                    String newAddress = CheckInput.readUserInputString();
                    emp.setAddress(newAddress);
                    System.out.println("Address was updated:" + emp.getAddress());
                    break;
                case 2:
                    System.out.println("Enter new salary:");
                    double newSalary = CheckInput.readUserInputInt();
                    emp.setSalary(newSalary);
                    System.out.println("Salary was updated:" + emp.getSalary());
                    break;
                case 3:
                    //System.out.println("Profession specific feature");
                    switch (emp.getProfessions()) {
                        case "Chef":
                            System.out.println("Enter experiencelevel:\n1.Head\n2.Assistant");
                            int levelInt = CheckInput.readUserInputInt();
                            if (levelInt == 1) {
                                ((Chef) emp).setExperience(ExperienceLevelType.HEADCHEF);
                            } else if (levelInt == 2) {
                                ((Chef) emp).setExperience(ExperienceLevelType.ASSISTANTCHEF);
                            } else {
                                System.out.println("You entered no valid choice, experiencelevel is set to Assistant");
                                ((Chef) emp).setExperience(ExperienceLevelType.ASSISTANTCHEF);
                            }
                            break;
                        case "Bartender":
                            System.out.println("Enter number of drinks known:");
                            int newNumberOfDrinks = CheckInput.readUserInputInt();
                            ((Bartender) emp).setNumberDrinks(newNumberOfDrinks);
                            break;
                        case "Waiter":
                            System.out.println("Profession specific feature not avaible for update");
                            break;
                        case "WasherUp":
                            System.out.println("Enter number of destroyed items:");
                            int newNumberOfItems = CheckInput.readUserInputInt();
                            ((WasherUp) emp).setDestroyedItems(newNumberOfItems);
                            break;
                        default:
                            break;
                    }
                    break;
            }

            System.out.println("New updated employee information:");
            emp.print();
        } else {
            System.out.println("No employee matching the ID, no employee was updated");
        }
    }

    public void showEmployeeInformation(int id) {
        boolean foundEmployee = false;
        for (Employee employee : staff) {
            if (employee.getID() == id) {
                employee.print();
                foundEmployee = true;
                break;
            }
        }
        if (!foundEmployee) {
            System.out.println("No employee matching the ID");
        }
    }

    // METHOD CURRENTLY NOT USED
    public Employee getEmployeeFromList(int id) {
        Employee emp = null;
        for (Employee employee : staff) {
            if (employee.getID() == id) {
                emp = employee;
                return emp;
            }
        }
        System.out.println("Employee not found");
        return emp;
    }

    public double calculateAverageSalary() {
        double sum = 0;
        double averageSalary = 0;
        if (staff.size() > 0) {
            for (Employee employee : staff) {
                sum += (employee.getSalary());
            }
            averageSalary = sum / staff.size();
            return averageSalary;
        }
        return sum;
    }

    public double calculateAverageSalaryProfession(String proffesion) {

        if (staff.size() < 1) {
            System.out.println("No employees yet");
            return 0.0;
        } else if (proffesion.equalsIgnoreCase("Chef") || proffesion.equalsIgnoreCase("Bartender")
                || proffesion.equalsIgnoreCase("Waiter") || proffesion.equalsIgnoreCase("WasherUp")) {
            double averageIndividualSalary = 0;
            int count = 0;

            for (Employee employee : staff) {
                if (employee.getProfessions().equalsIgnoreCase(proffesion)) {
                    averageIndividualSalary = averageIndividualSalary + employee.getSalary();
                    count++;
                }
            }
            return (averageIndividualSalary / count); // if wrong String argument get NaN here
        } else {
            System.out.println("Not a valid profession");
            return 0.0;
        }
    }

    public double calculateTotalBonusOverall() {
        double bonus = 0;
        if (staff.size() > 0) {
            for (Employee employee : staff) {
                bonus += (employee.calculateBonus());
            }
        }
        return bonus;
    }

    public double calculateBonusProfession(String proffesion) {
        double individualbonus = 0;
        if (staff.size() < 1) {
            System.out.println("No employees yet");
            return 0.0;
        } else if (proffesion.equalsIgnoreCase("Chef") || proffesion.equalsIgnoreCase("Bartender")
                || proffesion.equalsIgnoreCase("Waiter") || proffesion.equalsIgnoreCase("WasherUp")) {
            for (Employee employee : staff) {
                if (employee.getProfessions().equalsIgnoreCase(proffesion)) {
                    individualbonus = individualbonus + employee.calculateBonus();
                }
            }
            return (individualbonus);
        } else {
            System.out.println("Not a valid profession");
            return 0.0;
        }
    }

    public void printGenderPercentTotal() {
        double male = 0.0, female = 0.0, unknown = 0.0;

        if (staff.size() > 0) {
            for (Employee employee : staff) {
                if (employee.getGender().name().equals("MALE")) {
                    male++;
                } else if (employee.getGender().name().equals("FEMALE")) {
                    female++;
                } else if (employee.getGender().name().equals("UNKNOWN")) {
                    unknown++;
                }

            }
            System.out.println("Percentage of males is: " + ((male / staff.size()) * 100) + " %");
            System.out.println("Percentage of females is: " + ((female / staff.size()) * 100) + " %");
            System.out.println("Percentage of unknown is: " + ((unknown / staff.size()) * 100) + " %");
        } else {
            System.out.println("No employees yet");
        }
    }

    public void printGenderPercentProfession(String profession) {
        double male = 0.0, female = 0.0, unknown = 0.0;

        if (staff.size() > 0) {
            if (profession.equalsIgnoreCase("Chef") || profession.equalsIgnoreCase("Bartender") || profession.equalsIgnoreCase("Waiter") || profession.equalsIgnoreCase("WasherUp")) {
                for (Employee employee : staff) {
                    GenderType g = employee.getGender();
                    String p = employee.getProfessions();
                    if ((g == GenderType.MALE) && (p.equalsIgnoreCase(profession))) {
                        male++;
                    } else if ((g == GenderType.FEMALE) && (p.equalsIgnoreCase(profession))) {
                        female++;
                    } else if ((g == GenderType.UNKNOWN) && (employee.getProfessions().equalsIgnoreCase(profession))) {
                        unknown++;
                    }
                }
                double sum = male + female + unknown;
                System.out.println("Percentage of males is: " + ((male / sum) * 100) + " %");
                System.out.println("Percentage of females is: " + ((female / sum) * 100) + " %");
                System.out.println("Percentage of unknown is: " + ((unknown / sum) * 100) + " %");
            } else {
                System.out.println("Not a valid profession");
            }
        }
        else
            System.out.println("No employees yet");
    }

    // TODO Do we need to check something here with staff in highestSalary()
    public double highestSalary() {

        if (staff.size() > 0) {
            Employee temporaryEmployee = staff.get(0);
            double max = temporaryEmployee.getSalary();

            for (int i = 1; i < staff.size(); i++) {
                if (max < staff.get(i).getSalary()) {
                    max = staff.get(i).getSalary();
                }

            }
            return max;
        } else {
            return 0.0;
        }
    }

    public double lowestSalary() {
        if (staff.size() > 0) {
            Employee temporaryEmployee = staff.get(0);
            double min = temporaryEmployee.getSalary();

            for (int i = 1; i < staff.size(); i++) {
                if (min > staff.get(i).getSalary()) {
                    min = staff.get(i).getSalary();
                }

            }
            return min;
        } else {
            return 0.0;
        }
    }

    public void printAll() {
        if (staff.size() > 0) {
            for (Employee e : staff) {
                e.print();
            }
        } else {
            System.out.println("No employees yet");
        }
    }
}
