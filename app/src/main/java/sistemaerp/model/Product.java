package sistemaerp.model;

public class Product {
    
    private String description;
    private String sku;
    private String equipment;
    private int quantity;


    public Product(String description, String sku, int quantity, String equipment){

        this.description = description;
        this.sku = sku;
        this.equipment = equipment;
        this.quantity = quantity;

    }

    //Getters
    public String getDescription() {
        return description;
    }


    public String getSku() {
        return sku;
    }


    public String getEquipment() {
        return equipment;
    }


    public int getQuantity() {
        return quantity;
    }

}
