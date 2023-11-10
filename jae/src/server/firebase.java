public class firebase {
    FileInputStream serviceAccount =
new FileInputStream("server/serviceAccountKey.json");

FirebaseOptions options = new FirebaseOptions.Builder()
  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
  .setDatabaseUrl("https://cosr4s-jae-default-rtdb.firebaseio.com")
  .build();

FirebaseApp.initializeApp(options);
}
