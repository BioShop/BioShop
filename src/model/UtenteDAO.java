package model;

import java.sql.*;


public class UtenteDAO {


    public Utente doRetrieveByUsernamePassword(String username,String password){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id, carrello,username,email, passwordhash,admin,ddnascita,citta FROM utente WHERE username=? AND passwordhash=SHA1(?)");
            ps.setString(1,username );
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Utente u = new Utente();
                u.setId(rs.getInt(1));
                u.setCarrello(rs.getInt(2));
                u.setUsername(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setAdmin(rs.getBoolean(5));
                u.setDdn(rs.getString(6));
                u.setCitta(rs.getString(7));

                return u;

            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void doSave(Utente utente){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO utente (carrello,username,email,passwordhash,admin,ddnascita,citta) VALUES(?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,utente.getCarrello());
            ps.setString(2,utente.getUsername());
            ps.setString(3,utente.getEmail());
            ps.setString(4,utente.getPassword());
            ps.setBoolean(5,utente.isAdmin());
            ps.setString(6,utente.getDdn());
            ps.setString(7,utente.getCitta());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            utente.setId(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
