package datamodel;

public class Item_model {

    // constructor

    private String name;

    public String get_name() {
        return name;
    }

    public void set_name(String name) {
        this.name = name;
    }

    private Double price;

    public Double get_price() {
        return price;
    }

    public void set_price(Double price) {
        this.price = price;
    }

    private String image_url;

    public String get_image_url() {
        return image_url;
    }

    public void set_image_url(String image_url) {
        this.image_url = image_url;
    }

    public Item_model Item_model(String name, Double price, String image_url) {
        this.name = name;
        this.price = price;

        this.image_url = image_url;

        Item_model model = new Item_model();
        model.set_name(this.name);
        model.set_price(this.price);
        model.set_image_url(this.image_url);

        return model;
    }

}
