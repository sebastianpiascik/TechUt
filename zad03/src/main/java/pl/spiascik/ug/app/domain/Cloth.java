package pl.spiascik.ug.app.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cloth {

    private int id;
    private String name;
    private Date productionDate;
    private double price;
    private boolean isWaterproof;


    public Cloth(String name, String productionDateString, double price, boolean isWaterproof) {
        java.sql.Date productionDate=null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(productionDateString);
            productionDate = new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.name = name;
        this.productionDate = productionDate;
        this.price = price;
        this.isWaterproof = isWaterproof;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isWaterproof() {
        return isWaterproof;
    }

    public void setWaterproof(boolean waterproof) {
        isWaterproof = waterproof;
    }

    public String toString(){
        return "Nazwa: "+this.name+", cena: "+this.price+", data produkcji: "+this.productionDate;
    }

}

