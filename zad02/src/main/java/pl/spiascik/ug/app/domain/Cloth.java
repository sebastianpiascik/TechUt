package pl.spiascik.ug.app.domain;

public class Cloth {

    private long id;

    private String name;
    private String type;
    private String color;
    private String producer;

    public Cloth(String name, String type, String color, String producer) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

}

