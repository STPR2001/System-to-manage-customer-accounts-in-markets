package logic.classes;
public class Organization {
    private int id;
    private String name, description, city, address;
    private boolean isPublic, trustVerifiedAccounts;
    private String password;

    public Organization() {
    }

    public Organization(
            Integer id, 
            String name, 
            String description, 
            Boolean isPublic, 
            Boolean trustVerifiedAccounts, 
            String password,
            String city,
            String address
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isPublic = isPublic;
        this.trustVerifiedAccounts = trustVerifiedAccounts;
        this.password = password;
        this.city = city;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    public String getCity(){
        return city;
    }
    
    public String getAddress(){
        return address;
    }

    public boolean isIsPublic() {
        return isPublic;
    }

    public boolean isTrustVerifiedAccounts() {
        return trustVerifiedAccounts;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public void setTrustVerifiedAccounts(boolean trustVerifiedAccounts) {
        this.trustVerifiedAccounts = trustVerifiedAccounts;
    }
    
    public void setPassword (String password){
        this.password = password;
    }
    
    
}
