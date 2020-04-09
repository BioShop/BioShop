package model;

import java.sql.*;

public class CarrelloDAO {

    public void doSave(Carrello carrello) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO carrello (prezzo) VALUES(?)", Statement.RETURN_GENERATED_KEYS);

            ps.setDouble(1, carrello.getPrezzo());



            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            int id = rs.getInt(1);
            carrello.setId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
