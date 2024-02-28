package logic.classes;
public class LinkedEmail {
    private String address, pin;

    public LinkedEmail() {
    }

    public LinkedEmail(String address, String pin) {
        this.address = address;
        this.pin = pin;
    }

    public String getAddress() {
        return address;
    }

    public String getPin() {
        return pin;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
    
    
}
