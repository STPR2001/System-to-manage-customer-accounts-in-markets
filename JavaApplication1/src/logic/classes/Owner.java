package logic.classes;

public class Owner extends User{

    public Owner() {}

    public Owner(
            String name, 
            String email, 
            String adress, 
            GeneralData attributes, 
            int id, 
            String password
    ) {
        super(name, email, adress, attributes, password);
    }
}
