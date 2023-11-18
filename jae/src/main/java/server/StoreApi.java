package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreApi {
    public static void main(String args[]) throws Exception {
        // Providing the website URL
        URL url = new URL("https://us-central1-readify-21f57.cloudfunctions.net/app/search/dart/");

        // Creating an HTTP connection
        HttpURLConnection MyConn = (HttpURLConnection) url.openConnection();

        // Set the request method to "GET"
        MyConn.setRequestMethod("GET");

        // Collect the response code
        int responseCode = MyConn.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == MyConn.HTTP_OK) {
            // Create a reader with the input stream reader.
            BufferedReader in = new BufferedReader(new InputStreamReader(MyConn.getInputStream()));
            String inputLine;

            // Create a string buffer
            StringBuffer response = new StringBuffer();

            // Write each of the input line
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            // Show the output
             System.out.println(response.toString());
           // makeData(response.toString());

        } else {
            System.out.println("Error found !!!");
        }
    }

   

    public static ArrayList<Datas> make_data(String response) {
        ArrayList<Datas> returnData = new ArrayList<Datas>();
        response = response.substring(response.indexOf(":[", 1) + 2, response.length() - 3);
        // System.out.println(response);
        String[] keyValuePairs = response.split("},");

        for (String s : keyValuePairs) {

            Datas.to_map(s + "}");
            // System.out.println(s + "}");
            // System.out.println("");
        }
        return null;

    }

}

class Datas {
    String title;
    Double price;
    String image;

    Datas(String title, Double price, String image) {
        this.title = title;
        this.price = price;
        this.image = image;

    }

    public static Datas to_map(String roughData) {

        String name = roughData.substring(roughData.indexOf("\"title\":") + 9,
                roughData.indexOf("\",\"", roughData.indexOf("\"title\":") + 9));
        // Double price =
        // Double.parseDouble(roughData.substring(roughData.indexOf("\"price\":") + 8,
        // roughData.indexOf("\",\"", startIndex)));
        Double price = 11.0;
        String image = "";

        Datas newData = new Datas(name, price, image);
        System.out.println(newData.title);
        return newData;
    }

}
