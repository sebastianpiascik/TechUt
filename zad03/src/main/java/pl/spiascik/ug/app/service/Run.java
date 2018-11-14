package pl.spiascik.ug.app.service;

import pl.spiascik.ug.app.domain.Cloth;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Run {

    public static void main(String[] args) throws SQLException {

        ClothServiceJDBC clothService = new ClothServiceJDBC();

        // Prepare clothes
        Cloth cloth1 = new Cloth("T01","t-shirt","Company 1");
        Cloth cloth2 = new Cloth("T02","t-shirt","Company 2");
        Cloth cloth3 = new Cloth("T03","t-shirt","Company 3");
        Cloth cloth4 = new Cloth("T04","hoodie","Company 4");

        // Create clothes list
        List<Cloth> clothes= new ArrayList<>();
        clothes.add(cloth1);
        clothes.add(cloth2);
        clothes.add(cloth3);
        clothes.add(cloth4);

        // Execute query, add all clothes from list
        clothService.addAllClothes(clothes);
//        clothService.addCloth(cloth1);

        // Show all clothes
        System.out.println("Lista ubrań:");
        clothService.showAllClothes();
        System.out.println("\n");

        // Show only hoodies
        System.out.println("Lista bluz:");
        clothService.showAllHoodies();
        System.out.println("\n");

        System.out.println("Usuwam T03");
        clothService.removeCloth("T03");
        System.out.println("\n");

        // Show all clothes
        System.out.println("Lista ubrań:");
        clothService.showAllClothes();
        System.out.println("\n");

        //Search for clothes from company
        clothService.searchCompany("Company 4");
    }
}
