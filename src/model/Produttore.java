package model;

public class Produttore {
    private String pIva;
    private String nome;
    private String via;
    private int CAP;
    private String citta;

    public Produttore(){};

    public Produttore(String pIva,String nome,String via,int CAP,String citta){
             this.pIva=pIva;
            this.CAP = CAP;
            this.citta = citta;
            this.nome = nome;
            this.via = via;
    }

    public String getpIva() {
        return pIva;
    }

    public void setpIva(String pIva) {
        this.pIva = pIva;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCAP() {
        return CAP;
    }

    public void setCAP(int CAP) {
        this.CAP = CAP;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }


}
