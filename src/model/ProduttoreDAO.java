package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProduttoreDAO {

    public ArrayList<Produttore> doRetrieveAll(){

        ArrayList<Produttore> listaProduttori=new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT pIva,nome,via,cap,citta FROM produttore ");

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Produttore produttore= new Produttore();
                produttore.setpIva(rs.getString(1));
                produttore.setNome(rs.getString(2));
                produttore.setVia(rs.getString(3));
                produttore.setCAP(rs.getInt(4));
                produttore.setCitta(rs.getString(5));

                listaProduttori.add(produttore);
            }
            return listaProduttori;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //dato un produttore  vengono mostrati tutti i suoi prodotti
    public ArrayList<Prodotto> doRetrieveAllByProduttore(Produttore produttore) {

        ArrayList<Prodotto> prodotti = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps =
                    con.prepareStatement("SELECT prodotto.id,prodotto.produttore,prodotto.categoria,prodotto.nome,prodotto.descrizione,prodotto.offerta,prodotto.prezzo,prodotto.disponibili,prodotto.immagine FROM prodotto where prodotto.produttore=?");
            ps.setString(1, produttore.getpIva());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prodotto prodotto = new Prodotto();
                prodotto.setId(rs.getInt(1));
                prodotto.setProduttore(rs.getString(2));
                prodotto.setCategoria(rs.getInt(3));
                prodotto.setNome(rs.getString(4));
                prodotto.setDescrizione(rs.getString(5));
                prodotto.setOfferta(rs.getBoolean(6));
                prodotto.setPrezzo(rs.getDouble(7));
                prodotto.setDisponibili(rs.getInt(8));
                prodotto.setImmagine(rs.getString(9));

                prodotti.add(prodotto);
            }
            return prodotti;
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }


    }
}
