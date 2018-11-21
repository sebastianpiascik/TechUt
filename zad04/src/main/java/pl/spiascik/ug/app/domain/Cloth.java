package pl.spiascik.ug.app.domain;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Cloth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date productionDate;
    private double price;
    private boolean isWaterproof;

    @ManyToOne
    private Wearer wearer;

    @OneToMany
    private Manufacturer manufacturer;

    @ManyToMany
    private Type type;



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

    public Cloth(){
        super();
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

    public Wearer getWearer() {
        return wearer;
    }

    public void setWearer(Wearer wearer) {
        this.wearer = wearer;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}

