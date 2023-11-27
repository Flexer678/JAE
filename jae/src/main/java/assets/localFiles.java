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

    //user token file
   public static String tokenFile = "\\Users\\user\\Documents\\alex file\\java school proj\\SHOPPING\\JAE\\jae\\src\\main\\java\\assets\\token.txt";
   
    public static String tokenFiles = new File("jae/src/main/java/assets/token.txt").getAbsolutePath();
    //tokenFile.concat("path to the property file");

    //intermediate storage of cart items
    public static ArrayList<CartItem_model> cartItems = new ArrayList<CartItem_model>();


    //getter for cartItems
    public static ArrayList<CartItem_model> getCartItems() {
        return cartItems;
    }

    //getter for name
    public static String getName() {
        return name;
    }
    //getter for tokenFile
    public static String getTokenFile() {return tokenFile;}

    //setter for name
    public static void set_name(String name) {
        localFiles.name = name;
    }

    public static void logout(){
        try {
            String tokenFileName = localFiles.getTokenFile();
        BufferedWriter br = new BufferedWriter(new FileWriter(tokenFileName));
        br.write(""); // writes the edited string buffer to the new file
        br.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    //checks for a user token in tokenFile. if found, bypass login screen and login as that user.
    public static boolean isLoggedIn() throws IOException {
       
        File reader = new File( tokenFiles );
        BufferedReader br = new BufferedReader(new FileReader(reader));
        String line = br.readLine();
        br.close();
        if (line == null) {
            return false;
        } else {
            //decode and split token to get username, set name to found username.
            byte[] decodedBytes = Base64.getDecoder().decode(line);
            String[] unencryptedToken = new String(decodedBytes).split(",,,",-1);
            name = unencryptedToken[0];
            return true;
        }
    }

    //writes cartItems arraylist to firestore db in collection carts, document username
    public static void add_to_cart(CartItem_model model) throws ExecutionException, InterruptedException {
        DB database = new DB();
        cartItems.add(model);
        database.update("carts",name,cartItems);
        System.out.println(database.read("carts",name));
    }
}
