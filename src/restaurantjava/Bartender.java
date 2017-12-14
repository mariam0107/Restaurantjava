package restaurantjava;


public class Bartender extends Employee {

    private int numberDrinks;

    public Bartender(String professions, String fullName, String address, GenderType gender, double salary, int numberDrinks) {
        super(professions,fullName, address, gender, salary);
        this.numberDrinks = numberDrinks;
    }

    public int getNumberDrinks() {
        return numberDrinks;
    }

    public void setNumberDrinks(int numberDrinks) {
        this.numberDrinks = numberDrinks;
    }
    
//    @Override
//    public double calculateSalary() {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

    @Override
    public double calculateBonus() {
        return (numberDrinks * 10);
    }

    @Override
    public void print() {
        System.out.println(super.toString() + ", Bonus = " +calculateBonus()+ " NumberDrinks = " +numberDrinks);
    }
}