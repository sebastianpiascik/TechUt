package domain;
public class Cloth {

    private long id;

    private String name;
    private String type;
    private String color;
    private String fabric;
    private String producer;

    public Cloth() {
    }

    public Cloth(String name, String type, String color, String fabric, String producer) {
        super();
        this.name = name;
        this.type = type;
        this.color = color;
        this.fabric = fabric;
        this.producer = producer;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

}

