package restaurantjava;


public class Waiter extends Employee {

    private int experienceYear;

    public Waiter(String professions,String fullName, String address, GenderType gender, double salary, int experienceYear) {
        super(professions ,fullName, address, gender, salary);
        this.experienceYear = experienceYear;
    }

    public int getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(int experienceYear) {
        this.experienceYear = experienceYear;
    }
    
//    @Override
//    public double calculateSalary() {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
    
    @Override
    public double calculateBonus() {
        if(experienceYear<=5)
            return 2000;
        else if(experienceYear>5 && experienceYear<=10)
            return 3000;
        else if(experienceYear>10)
            return 5000;
        return 0;
    }

    @Override
    public void print() {
        System.out.println(super.toString() + ", Bonus = " +calculateBonus()+ ", ExperienceYear = " +experienceYear);
    }
}