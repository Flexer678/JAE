package datamodel;

public class Item_model {

    // constructor

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    private String image_url;

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Item_model Item_model(String name, Double price, String image_url) {
        this.name = name;
        this.price = price;

        this.image_url = image_url;

        Item_model model = new Item_model();
        model.setName(this.name);
        model.setPrice(this.price);
        model.setImage_url(this.image_url);

        return model;
    }

}
