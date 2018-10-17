package service;
import domain.Cloth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClothService {

    private Connection connection;

    private String url = "jdbc:hsqldb:hsql://localhost/workdb";

    private String createTableCloth = "CREATE TABLE Cloth(id bigint GENERATED BY DEFAULT AS IDENTITY, name varchar(50) UNIQUE, type varchar(50), color varchar(30), fabric varchar(50), producer varchar(100))";

    private PreparedStatement addClothStmt;
    private PreparedStatement deleteAllClothesStmt;
    private PreparedStatement getAllClothesStmt;

    private Statement statement;

    public ClothService() {
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();

            ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
            boolean tableExists = false;
            while (rs.next()) {
                if ("Cloth".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
                    tableExists = true;
                    break;
                }
            }

            if (!tableExists)
                statement.executeUpdate(createTableCloth);

            addClothStmt = connection.prepareStatement("INSERT INTO Cloth (name, type, color, fabric, producer) VALUES ('BN01', 'hoodie', 'black' , 'cotton', 'NIKE')");
            deleteAllClothesStmt = connection.prepareStatement("DELETE FROM Cloth");
            getAllClothesStmt = connection.prepareStatement("SELECT id, name, type, color, fabric, producer FROM Cloth");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Connection getConnection() {
        return connection;
    }

    void clearClothes() {
        try {
            deleteAllClothesStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCloth(Cloth cloth) {

    }

    public List<Cloth> getAllClothes() {
        List<Cloth> persons = new ArrayList<Cloth>();

        try {
            ResultSet rs = getAllClothesStmt.executeQuery();

            while (rs.next()) {
                Cloth p = new Cloth();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setType(rs.getString("type"));
                p.setColor(rs.getString("color"));
                p.setFabric(rs.getString("fabric"));
                p.setProducer(rs.getString("producer"));
                persons.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public static void main(String[] args) throws SQLException {

        ClothService clothService = new ClothService();

        clothService.getAllClothes();

    }
}
