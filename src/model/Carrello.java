package model;

public class Carrello {
    private int id;
    private double prezzo;

    public Carrello(){}

    public Carrello(Double prezzo){
        this.prezzo=prezzo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
