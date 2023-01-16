package base;

public class Guitar {
    private int id;
    private String name;
    private String brand;
    private String type;
    private int strings;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStrings() {
        return strings;
    }

    public void setStrings(int strings) {
        this.strings = strings;
    }

    @Override
    public String toString() {
        return "base.Guitar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", strings=" + strings +
                "}";
    }
    public String print(){
        return "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", strings=" + strings +"."+'\n';
    }
}
