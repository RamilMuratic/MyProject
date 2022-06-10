package ru.myapp.clothes;

public class Clothes {

    private String name;
    private double price;
    private String category;
    private String size;
    private String color;
    private String producingCountry;

    public Clothes(String name, double price, String category, String size, String color, String producingCountry) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.size = size;
        this.color = color;
        this.producingCountry = producingCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProducingCountry() {
        return producingCountry;
    }

    public void setProducingCountry(String producingCountry) {
        this.producingCountry = producingCountry;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", producingCountry='" + producingCountry + '\'' +
                '}';
    }
}
