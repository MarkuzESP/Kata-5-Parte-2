package kata5Model;

public class Mail {
    private final String mail;
    
    public Mail (String mail) {
        this.mail = mail;
    }
    
    public String getMail(){
        return mail;
    }
    
    public String getDomain(){
        // El dominio se toma leyendo a partir del caracter que sigue a la @
        return mail.split("@")[1];
    }
}
