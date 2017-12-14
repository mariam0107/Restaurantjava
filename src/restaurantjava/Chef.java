package restaurantjava;


public class Chef extends Employee {

    private ExperienceLevelType experience;
    

    public Chef(String professions, String fullName, String address, GenderType gender, double salary, ExperienceLevelType experience) {
        super(professions, fullName, address, gender, salary);
        this.experience = experience;
    }

    public ExperienceLevelType getExperience() {
        return experience;
    }

    public void setExperience(ExperienceLevelType experience) {
        this.experience = experience;
    }
    
//    @Override
//    public double calculateSalary() {
//        
//    }
    @Override
    public double calculateBonus() {
       double bonus = 0;
       if(experience.equals(ExperienceLevelType.ASSISTANTCHEF))
       {
           bonus = getSalary() * 0.1;
       }
       else if(experience.equals(ExperienceLevelType.HEADCHEF))
       {
           bonus = getSalary() * 0.2;  
       }
       return bonus;
    }

    @Override
    public void print() {
        System.out.println(super.toString() + ", Bonus = " +calculateBonus()+ ", ExperienceLevel = " +experience);
    }
}