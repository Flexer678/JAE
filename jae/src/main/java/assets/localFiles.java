package assets;


import java.util.ArrayList;

import datamodel.CartItem_model;
import datamodel.Item_model;

public class localFiles {
    public static String name = "";


    //where the db is stored
    ArrayList<CartItem_model> cartItems = new ArrayList<CartItem_model>();


    public static Boolean isSignIn = false;

    public static String getName() {
        return name;
    }

    public static void set_name(String name) {
        localFiles.name = name;
    }
}
