package assets;


import java.util.ArrayList;
import db.DB;
import datamodel.CartItem_model;

public class localFiles {

    //name of the user
    public static String name = "";


    //where the db is stored
    public static ArrayList<CartItem_model> cartItems = new ArrayList<CartItem_model>();

    


    public ArrayList<CartItem_model> getCartItems() {
        return cartItems;
    }


    public static Boolean isSignIn = false;

    public static String getName() {
        return name;
    }

    public static void set_name(String name) {
        localFiles.name = name;
    }

    //adds to where the db is stored
    public static void add_to_cart(CartItem_model model) {
        cartItems.add(model);
        DB.update("carts",name,cartItems);
    }
}
