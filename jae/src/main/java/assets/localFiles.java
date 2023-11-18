package assets;


import datamodel.CartItem_model;

public class localFiles {
    public static String name = "";


    //where the db is stored
    public ArrayList<CartItem_model> = new ArrayList<CartItem_model>();


    public static Boolean isSignIn = false;

    public static String getName() {
        return name;
    }

    public static void set_name(String name) {
        localFiles.name = name;
    }
}
