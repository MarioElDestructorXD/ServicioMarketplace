package mx.edu.utez.marketplace.product.model;

import mx.edu.utez.marketplace.status.model.Status;
import mx.edu.utez.marketplace.subcategory.model.Subcategory;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String brand;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<ProductImage> images;

    public Product(long id, String name, String description, double price, int queality, String brand, Status status, Subcategory subcategory, List<ProductImage> images) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = queality;
        this.brand = brand;
        this.status = status;
        this.subcategory = subcategory;
        this.images = images;
    }

    public Product(String name, String description, double price, int queality, String brand, Status status, Subcategory subcategory, List<ProductImage> images) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = queality;
        this.brand = brand;
        this.status = status;
        this.subcategory = subcategory;
        this.images = images;
    }


    public Product() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int queality) {
        this.quantity = queality;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public List<ProductImage> getImages() {
        return images;
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
    }
}
