package logic.classes;
public class Client extends User {

    public Client() {}
    
    public Client(
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
