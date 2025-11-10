package Model;

import java.time.LocalDate;

public class Product {
    private String name;
    private String image;
    private double price;
    private double discount;
    private LocalDate createdDate;
    private String description;

    public Product() {}

    public Product(String name, String image, double price, double discount, LocalDate createdDate, String description) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.discount = discount;
        this.createdDate = createdDate;
        this.description = description;
    }

    // Getters & Setters
    public String getName() { return name; }
    public String getImage() { return image; }
    public double getPrice() { return price; }
    public double getDiscount() { return discount; }
    public LocalDate getCreatedDate() { return createdDate; }
    public String getDescription() { return description; }

    public void setName(String name) { this.name = name; }
    public void setImage(String image) { this.image = image; }
    public void setPrice(double price) { this.price = price; }
    public void setDiscount(double discount) { this.discount = discount; }
    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }
    public void setDescription(String description) { this.description = description; }
}
