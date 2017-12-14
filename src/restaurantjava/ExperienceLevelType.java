package restaurantjava;


public enum ExperienceLevelType {

    ASSISTANTCHEF,HEADCHEF;
    
    // To custom print a name for each enum type
    @Override
    public String toString() {
        
        switch (this) {
            case ASSISTANTCHEF : 
                return "Assistant chef";
            case HEADCHEF : 
                return "Head chef";
            default :
                return "Not valid Experience Level Type enum"; //Should never execute
        }
    }   
}
