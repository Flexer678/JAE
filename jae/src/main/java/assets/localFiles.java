package assets;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import db.DB;
import datamodel.CartItem_model;

public class localFiles {

    //name of the user
    public static String name = "";

    public static String tokenFile = "src/main/java/assets/token.txt";


    //where the db is stored
    public static ArrayList<CartItem_model> cartItems = new ArrayList<CartItem_model>();

    


    public static ArrayList<CartItem_model> getCartItems() {
        return cartItems;
    }

    public static String getName() {
        return name;
    }
    public static String getTokenFile() {return tokenFile;}

    public static void set_name(String name) {
        localFiles.name = name;
    }

    public static boolean isLoggedIn() throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader(tokenFile));
        String line = "";
//        br.close();
        if (line == null) {
            return false;
        } else {
            byte[] decodedBytes = Base64.getDecoder().decode("ZWx3b29kLCwsYmFsbHM=");
            String[] unencryptedToken = new String(decodedBytes).split(",,,",-1);
            name = unencryptedToken[0];
            return true;
        }
    }

    //adds to where the db is stored
    public static void add_to_cart(CartItem_model model) throws ExecutionException, InterruptedException {
        DB database = new DB();
        cartItems.add(model);
        database.update("carts",name,cartItems);
        System.out.println(database.read("carts",name));
    }
}
