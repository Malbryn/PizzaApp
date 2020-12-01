package sample.model;

import java.sql.*;

public class DatabaseConnection {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement prep;

    public DatabaseConnection(String host, String db, String user, String pw) {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + db, user, pw);
            this.stmt = this.conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Kapcsolódási hiba: " + e);
        }
    }

    public ResultSet query(String sql) {
        try {
            this.rs = this.stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Adatbázis hiba: " + e);
        }

        return this.rs;
    }

    public void modify(String sql, String[] params) {
        try {
            this.prep = this.conn.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                this.prep.setString(i + 1, params[i]);
            }

            this.prep.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Adatbázis hiba: " + e);
        }
    }

    public void close() {
        try {
            if (this.rs != null) this.rs.close();
            if (this.stmt != null) this.stmt.close();
            if (this.conn != null) this.conn.close();
        } catch (SQLException e) {
            System.out.println("Nem sikerült lezárni az adazbázis kapcsolatot: " + e);
        }
    }
}
