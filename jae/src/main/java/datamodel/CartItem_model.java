
package datamodel;

class CartItem_model {

    Double price;
    String name;
    int quantity;
    String image;

    public Double get_price() {
        return price;
    }

    public void set_price(Double price) {
        this.price = price;
    }

    public String get_name() {
        return name;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public int get_quantity() {
        return quantity;
    }

    public void set_quantity(int quantity) {
        this.quantity = quantity;
    }

    public String get_image() {
        return image;
    }

    public void set_image(String image) {
        this.image = image;
    }

}