
package datamodel;

//this class is used to store the data of the individual carts

public class CartItem_model {


    Double price;
    String name;
    int quantity;
    String image;
    String id;
    Boolean isBook;

    public void add_quantity() {
        quantity++;
    }

    public void decrease_quantity() {
        quantity++;
    }

    public String get_id() {
        return id;
    }
    public void set_id(String id) {
        this.id = id;
    }

    public Boolean get_isBook() {
        return isBook;
    }

    public void set_item_type(Boolean isBook) {
        this.isBook = isBook;
    }

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

    public void set_data(CartItem_model cartItem_model) {
    }

}