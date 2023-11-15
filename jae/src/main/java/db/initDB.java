package db;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.io.InputStream;

public class initDB {
    private static final String dbUrl = "https://cosr4s-jae-default-rtdb.firebaseio.com";

    public initDB(){
        InputStream serviceAccount = this.getClass().getResourceAsStream("/Users/elwood/Documents/dbPrivateKeyTopSneakyDontShare.json");
        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl(dbUrl)
                    .build();

            FirebaseApp.initializeApp(options);

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        FirebaseDatabase fireDB = FirebaseDatabase.getInstance(dbUrl);
        DatabaseReference ref = fireDB.getReference().child("testdata");
        ref.setValueAsync("I'm writing data", new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
                    System.out.println("Data could not be saved " + databaseError.getMessage());
                } else {
                    System.out.println("Data saved successfully.");
                }
            }
        });
    }
}
