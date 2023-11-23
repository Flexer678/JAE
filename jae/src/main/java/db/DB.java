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

public class DB {
    static Firestore fireDB;

    public DB(){
        InputStream serviceAccount = getClass().getResourceAsStream("dbKey.json");
        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (fireDB == null) {FirebaseApp.initializeApp(options);}

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        fireDB = FirestoreClient.getFirestore();
    }

    public static void update(String coll, String doc, ArrayList<CartItem_model> docData) {
        HashMap<String, CartItem_model> productMap = new HashMap<>();
        for (CartItem_model product : docData) {
            productMap.put(product.get_name(), product);
        }
        ApiFuture<WriteResult> future = fireDB.collection(coll).document(doc).set(productMap);
        try {
            WriteResult result = future.get();
            System.out.println("updated :)" + result);
        } catch (Exception e) {
            System.out.println("error :(" + e);
        }
    }

    public static ArrayList<Object> read(String coll, String doc) throws ExecutionException, InterruptedException {
        DocumentReference docRef = fireDB.collection(coll).document(doc);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        Map<String, Object> data = document.getData();
        if (document.exists()) {
            System.out.println("Document data: " + document.getData());
        } else {
            System.out.println("No such document!");
        }
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
