package shopping;

import Pages.*;
//import item.java from sec/widgets
import assets.localFiles;
import db.initDB;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        if (localFiles.isSignIn) {
            runhPages(args);

        } else {
            runSiginIn(args);
            startDB(args);
        }

    }

    private static void startDB(String[] args) {
        initDB database = new initDB();
        //Sample hashmap for writing to DB, to be replaced by input from cart and login pages.
        Map<String, Object> docData = new HashMap<>();
        docData.put("name", "Los Angeles");
        docData.put("state", "CA");
        docData.put("country", "USA");
        docData.put("regions", Arrays.asList("west_coast", "socal"));
        database.update("test","data", docData);
    }

    private static void runhPages(String[] args) {
        homePage runhPage = new homePage();
        runhPage.run(args);
    }

    private static void runSiginIn(String[] args) {
        SignInPage runSPage = new SignInPage();
        runSPage.run(args);
    }

}