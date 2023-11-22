package db;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.cloud.firestore.Firestore;
import datamodel.CartItem_model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DB {
    static Firestore fireDB;

    public DB(){
        InputStream serviceAccount = getClass().getResourceAsStream("dbKey.json");
        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        fireDB = FirestoreClient.getFirestore();
    }

    public static void update(String coll, String doc, ArrayList<CartItem_model> docData) {
        ApiFuture<WriteResult> future = fireDB.collection(coll).document(doc).set(docData);
        try {
            WriteResult result = future.get();
            System.out.println("updated :)" + result);
        } catch (Exception e) {
            System.out.println("error :(" + e);
        }
    }
}
