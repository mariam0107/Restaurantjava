package restaurantjava;


public enum GenderType {

    FEMALE,MALE,UNKNOWN;
    
//    // To print enum type in lowercase
//    @Override
//    public String toString() {
//        return this.name().toLowerCase();
//    }
    
    // To custom print a name for each enum type
    @Override
    public String toString() {
        
        switch (this) {
            case FEMALE : 
                return "Female";
            case MALE : 
                return "Male";
            case UNKNOWN : 
                return "Unknown";
            default :
                return "Not valid GenderType enum"; //Should never execute
        }
    }   
}