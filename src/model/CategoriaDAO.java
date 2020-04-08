package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDAO {

    //doRetrieveAll:Mostra tutte le categorie presenti in un db
    public ArrayList<Categoria> doRetrieveAll(){

        ArrayList<Categoria> listCategoria=new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id,descrizione,nome FROM categoria ");

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt(1));
                categoria.setNome(rs.getString(3));
                categoria.setDescrizione(rs.getString(2));

                listCategoria.add(categoria);
            }
            return listCategoria;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //data una categoria vengono mostrati tutti i prodotti che ne fanno parte
    public ArrayList<Prodotto> doRetrieveAllByCat(Categoria categoria){

        ArrayList<Prodotto> prodotti=new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            int idC=categoria.getId();
            PreparedStatement ps =
                    con.prepareStatement("SELECT prodotto.id,prodotto.produttore,prodotto.categoria,prodotto.nome,prodotto.descrizione,prodotto.offerta,prodotto.prezzo,prodotto.disponibili,prodotto.immagine FROM prodotto where prodotto.categoria=?");
            ps.setInt(1,categoria.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
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
