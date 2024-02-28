package logic.classes;

public class User {
    private String name, email, address, password;
    private GeneralData attributes;

    public User(
            String name, 
            String email, 
            String address, 
            GeneralData attributes, 
            String password
    ) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.attributes = attributes;
        this.password = password;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public GeneralData getAttributes() {
        return attributes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAttributes(GeneralData attributes) {
        this.attributes = attributes;
    }
}

/*

class PartidaSP: public Partida{
private:
	bool PAnterior;
public:
	PartidaSP();
	PartidaSP(dtFecha*, float, bool,std::vector<Jugador*>,std::vector<Videojuego*>);

	virtual ~PartidaSP();

	bool getPAnterior();
	float getDuracionTotal();

	void setPAnterior(bool);
};

class PartidaMP: public Partida{
private:
	bool EnVivo;
public:
	PartidaMP();
	PartidaMP(dtFecha*, float, bool,std::vector<Jugador*>,std::vector<Videojuego*>);

	virtual ~PartidaMP();

	bool getEnVivo();
	float getDuracionTotal();

	void setEnVivo(bool);
};





*/