package db;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.cloud.firestore.Firestore;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class initDB {
    Firestore fireDB;

    public initDB(){
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

    public void update(String coll, String doc, Map<String, Object> docData) {
        // Create a Map to store the data we want to set
        // Add a new document (asynchronously) in collection "cities" with id "LA"
        ApiFuture<WriteResult> future = fireDB.collection(coll).document(doc).set(docData);
        try {
            WriteResult result = future.get();
            System.out.println("updated :)" + result);
        } catch (Exception e) {
            System.out.println("error :(" + e);
        }
    }
}
