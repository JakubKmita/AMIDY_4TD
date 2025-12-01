import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ZadanieModel {

    private Connection conn;

    public ZadanieModel() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:zadaniasqlite.db");
            initDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initDB() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS zadania (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tresc TEXT NOT NULL)";
        conn.createStatement().execute(sql);
    }

    public void dodajZadanie(String tresc) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO zadania(tresc) VALUES(?)");
        ps.setString(1, tresc);
        ps.executeUpdate();
    }

    public void usunZadanie(int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM zadania WHERE id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public List<String> pobierzZadania() throws SQLException {
        List<String> lista = new ArrayList<>();
        ResultSet rs = conn.createStatement().executeQuery("SELECT id, tresc FROM zadania");

        while (rs.next()) {
            lista.add(rs.getInt("id") + ": " + rs.getString("tresc"));
        }
        return lista;
    }
}
