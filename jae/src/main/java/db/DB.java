package db;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.cloud.firestore.Firestore;
import datamodel.CartItem_model;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ExecutionException;
// this class provides i18n, reading, and writing to the firestore database.
public class DB {
    // create new firestore database object
    static Firestore fireDB;

    public DB(){
        //get private key from file and set the credentials in the database options
        InputStream serviceAccount = getClass().getResourceAsStream("dbKey.json");
        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
            // if database is not already init'd, initialize db using the private key specified.
            if (fireDB == null) {FirebaseApp.initializeApp(options);}

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        //set fireDB object to init'ed firestore db.
        fireDB = FirestoreClient.getFirestore();
    }

    //write to db

    public static void update(String coll, String doc, ArrayList<CartItem_model> docData) {
        //due to limitations with the firestore writing method, the input must be a hashmap.
        //since we are using arraylists in the rest of the program, this converts the arraylist into a hashmap
        //that firestore can parse.
        HashMap<String, CartItem_model> productMap = new HashMap<>();
        for (CartItem_model product : docData) {
            productMap.put(product.get_name(), product);
        }
        //write converted data into the database under collection coll, document doc.
        ApiFuture<WriteResult> future = fireDB.collection(coll).document(doc).set(productMap);
        try {
            WriteResult result = future.get();
            System.out.println("updated :)" + result);
        } catch (Exception e) {
            System.out.println("error :(" + e);
        }
    }

    //read from db
    public static ArrayList<Object> read(String coll, String doc) throws ExecutionException, InterruptedException {
        //get collection coll and document doc to read from.
        DocumentReference docRef = fireDB.collection(coll).document(doc);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        Map<String, Object> data = document.getData();
        /***debugging code for verifying database read:
        if (document.exists()) {
            System.out.println("Document data: " + document.getData());
        } else {
            System.out.println("No such document!");
        }***/
        //due to limitations with the firestore reading method, the output must be a hashmap.
        //since we are using arraylists in the rest of the program, this converts the hashmap into an arraylist
        //that our code can parse.
        ArrayList<Object> cartItems = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            Object itemObject = entry.getValue();
            Object itemName = entry.getKey();
            if (itemObject != null) {
                cartItems.add(itemObject);
            } else {
                // Handle the case where the value is not of the expected type
                System.err.println("Unexpected type for item: " + itemName);
            }
        }
    return cartItems;
    }
}
