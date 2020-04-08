package model;

import java.sql.*;
import java.util.ArrayList;

public class ProdottoDAO {

    //Remove:cancella un prodotto
    public void remove(Prodotto prodotto){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("delete from prodotto where id=?");

             ps.setInt(1,prodotto.getId());

            ResultSet rs = ps.executeQuery(); //eseguo la query

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //Inserisci prodotto serve per inserire un nuovo prodotto;
    public void inserisciProdotto(Prodotto prodotto){

        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Prodotto (produttore,categoria,nome,descrizione,offerta,prezzo,disponibili,immagine) VALUES(?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

                ps.setString(1,prodotto.getProduttore());
                ps.setInt(2,prodotto.getCategoria());
                ps.setString(3,prodotto.getNome());
                ps.setString(4,prodotto.getDescrizione());
                ps.setBoolean(5,prodotto.isOfferta());
                ps.setDouble(6,prodotto.getPrezzo());
                ps.setInt(7,prodotto.getDisponibili());
                ps.setString(8,prodotto.getImmagine());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            int id = rs.getInt(1);
            prodotto.setId(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // doRetrieveAll restituisce un arraylist contenente tutti i prodotti presenti nel db
    public ArrayList<Prodotto> doRetrieveAll(){

        ArrayList<Prodotto> prodotti=new ArrayList<>();//creo un arraylist dove inserirò tutti i prodotti presenti nel db
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id,produttore,categoria,nome,descrizione,offerta,prezzo,disponibili,immagine FROM prodotto ");

            ResultSet rs = ps.executeQuery(); //eseguo la query

            while(rs.next()) {
                Prodotto prodotto=new Prodotto(); //creo il nuovo prodotto che prende gli attributi dal db
                prodotto.setId(rs.getInt(1));
                prodotto.setProduttore(rs.getString(2));
                prodotto.setCategoria(rs.getInt(3));
                prodotto.setNome(rs.getString(4));
                prodotto.setDescrizione(rs.getString(5));
                prodotto.setOfferta(rs.getBoolean(6));
                prodotto.setPrezzo(rs.getDouble(7));
                prodotto.setDisponibili(rs.getInt(8));
                prodotto.setImmagine(rs.getString(9));

                prodotti.add(prodotto); //aggiungo il prodotto all'arraylist
            }
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //restituisce tutti i prodotti con quel nome
    public ArrayList<Prodotto> doRetrieveByName(String nome){

        ArrayList<Prodotto> prodotti=new ArrayList<>();//creo un arraylist dove inserirò tutti i prodotti presenti nel db
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id,produttore,categoria,nome,descrizione,offerta,prezzo,disponibili,immagine FROM prodotto WHERE nome=?");
            ps.setString(1,nome);//?=nome
            ResultSet rs = ps.executeQuery(); //eseguo la query

            while(rs.next()) {
                Prodotto prodotto=new Prodotto(); //creo il nuovo prodotto che prende gli attributi dal db
                prodotto.setId(rs.getInt(1));
                prodotto.setProduttore(rs.getString(2));
                prodotto.setCategoria(rs.getInt(3));
                prodotto.setNome(rs.getString(4));
                prodotto.setDescrizione(rs.getString(5));
                prodotto.setOfferta(rs.getBoolean(6));
                prodotto.setPrezzo(rs.getDouble(7));
                prodotto.setDisponibili(rs.getInt(8));
                prodotto.setImmagine(rs.getString(9));

                prodotti.add(prodotto); //aggiungo il prodotto all'arraylist
            }
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
