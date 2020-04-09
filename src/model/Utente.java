package model;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Utente
{

    private int id;
    private String username ;
    private String email;
    private boolean admin;
    private  String password;
    private String citta;
    private String ddn;
    private int carrello;

    public Utente() {
    }

    public Utente(String username,String email, String password,String ddn,String citta)
    {
       this.username=username;
       this.email=email;
       this.password=password;
       this.ddn=ddn;
       this.citta=citta;

    }
    public Utente(int carrello,String username,String email, String password,String ddn,String citta, boolean admin)
    {
        this.carrello=carrello;
        this.username=username;
        this.email=email;
        this.password=password;
        this.ddn=ddn;
        this.citta=citta;
        this.admin=admin;
    }

    public Utente(String username,String email, String password,String ddn,String citta, boolean admin)
    {

        this.username=username;
        this.email=email;
        this.password=password;
        this.ddn=ddn;
        this.citta=citta;
        this.admin=admin;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }


    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getDdn() {
        return ddn;
    }

    public void setDdn(String ddn) {
        this.ddn = ddn;
    }

    public int getCarrello() {
        return carrello;
    }

    public void setCarrello(int carrello) {
        this.carrello = carrello;
    }

    public void setPassword(String password) {
        try {
            MessageDigest digest =
                    MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(password.getBytes(StandardCharsets.UTF_8));
            this.password = String.format("%040x", new
                    BigInteger(1, digest.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }




}
