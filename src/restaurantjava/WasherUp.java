package restaurantjava;


public class WasherUp extends Employee {
   
    private int employedYears;
    private int destroyedItems;

    public WasherUp(String professions, String fullName, String address, GenderType gender, double salary, int employedYears, int destroyedItems) {
        super(professions, fullName, address, gender, salary);
        this.employedYears = employedYears;
        this.destroyedItems = destroyedItems;
    }
    
    public int getEmployedYears() {
        return employedYears;
    }

    public void setEmployedYears(int employedYears) {
        this.employedYears = employedYears;
    }

    public int getDestroyedItems() {
        return destroyedItems;
    }

    public void setDestroyedItems(int destroyedItems) {
        this.destroyedItems = destroyedItems;
    }
    
//    @Override
//    public double calculateSalary() {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
    
    @Override
    public double calculateBonus() {      
        double bonus = (employedYears * 1000) - (destroyedItems * 100);
        if(bonus>0)
            return bonus;
        else
            return 0;
    }
    
    // TODO Add a new method to calculate new salary if bonus<0

    @Override
    public void print() {
        System.out.println(super.toString() + ", Bonus = " +calculateBonus()+ ", EmployedYears = " +
                employedYears+ ", DestroyedItems = " +destroyedItems);
    }
}