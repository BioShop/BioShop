package model;

public class Prodotto {

    private int id;
    private String produttore;
    private String nome;
    private String descrizione;
    private boolean offerta;
    private double prezzo;
    private int disponibili;
    private String immagine;
    private int categoria;


    public Prodotto(){}



    public Prodotto(String produttore, int categoria, String nome, String descrizione, boolean offerta, double prezzo, int disponibili, String immagine)
    {
        this.produttore = produttore;
        this.nome = nome;
        this.descrizione = descrizione;
        this.offerta = offerta;
        this.prezzo = prezzo;
        this.disponibili = disponibili;
        this.immagine = immagine;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduttore() {
        return produttore;
    }



    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public boolean isOfferta() {
        return offerta;
    }

    public void setOfferta(boolean offerta) {
        this.offerta = offerta;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getDisponibili() {
        return disponibili;
    }

    public void setDisponibili(int disponibili) {
        this.disponibili = disponibili;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}
