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

    private String ADD_SINGLE_CLOTH = "INSERT INTO Cloth (name, type, color, fabric, producer) VALUES ('BN01', 'hoodie', 'black' , 'cotton', 'NIKE')";
    private String DELETE_ALL_CLOTHES = "DELETE FROM Cloth";

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

            statement.executeUpdate(ADD_SINGLE_CLOTH);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Connection getConnection() {
        return connection;
    }

<<<<<<< HEAD
    public void addCloth(Cloth cloth) {
=======
    void clearClothes() {
        try {
            deleteAllClothesStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int addCloth(Cloth cloth) {
        int count = 0;
        try {
            addClothStmt.setString(1, cloth.getName());
            addClothStmt.setString(2, cloth.getType());
            addClothStmt.setString(3, cloth.getColor());
            addClothStmt.setString(4, cloth.getFabric());
            addClothStmt.setString(5, cloth.getProducer());

            count = addClothStmt.executeUpdate();
>>>>>>> parent of 88ed625... fix err

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void showAllClothes() throws SQLException{

        statement = connection.createStatement();
        try {
            ResultSet rs = statement.executeQuery("SELECT id, name, type, color, fabric, producer FROM Cloth");

            while (rs.next()) {

                System.out.println(rs.getInt("id")+","+rs.getString("name")+","+rs.getString("type")+","+rs.getString("color")+","+rs.getString("fabric")+","+rs.getString("producer"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAllCloth(List<Cloth> clothes) {

        try {
            connection.setAutoCommit(false);
            for (Cloth cloth : clothes) {
                addClothStmt.setString(1, cloth.getName());
                addClothStmt.setString(2, cloth.getType());
                addClothStmt.setString(3, cloth.getColor());
                addClothStmt.setString(4, cloth.getFabric());
                addClothStmt.setString(5, cloth.getProducer());
                addClothStmt.executeUpdate();
            }
            connection.commit();

        } catch (SQLException exception) {

            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }



    public static void main(String[] args) throws SQLException {

        ClothService clothService = new ClothService();
<<<<<<< HEAD
        clothService.showAllClothes();
=======
>>>>>>> parent of 88ed625... fix err

    }
}