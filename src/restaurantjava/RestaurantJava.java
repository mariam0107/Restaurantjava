package restaurantjava;


public class RestaurantJava {

    public static boolean continueProgram = true;
    
    public static void main(String[] args) {
       
        StaffManagement s = new StaffManagement();
        
        Utility utility = new Utility(s);
        
        while (continueProgram) {
         continueProgram=utility.start();
        }
        System.out.println("Restaurant Java Terminated.............");
    }  
}