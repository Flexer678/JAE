package server;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Locale.Category;
import java.util.concurrent.ThreadLocalRandom;

import datamodel.Item_model;

public class BookApi {

    private static String[] randomList = {"dart", "atomic", "python", "Java"};
    
    public String[] getRandomList() {
        return randomList;
    }

    public static void main(String[] args) throws IOException {
       // get_product_details_by_id("4EE27A69BA1F7E8DD8F077AF946D3B3D");
    }


    public void setRandomList(String[] randomList) {
        this.randomList = randomList;
    }



    private static String url = "https://us-central1-readify-21f57.cloudfunctions.net/app2/";
    
    
 

       public static ArrayList<Item_model> get_search_results(String bookName) throws IOException{
        
        URL link = new URL(url + "search/"+bookName);

        // Creating an HTTP connection
        HttpURLConnection MyConn = (HttpURLConnection) link.openConnection();

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
           //System.out.println(response.toString());
            return make_data_list(response.toString());
        } else {
            return null;
        }
        
    }

    public static ArrayList<Item_model> get_random_books() throws IOException{
        return get_search_results(getRandomElement(randomList));
        
    }

    

     public static Item_model get_product_details_by_id(String id ) throws IOException{
    
        URL link = new URL(url+"details/"+id);

        // Creating an HTTP connection
        HttpURLConnection MyConn = (HttpURLConnection) link.openConnection();

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
             //System.out.println(response.toString());
            return  make_data(response.toString());

        } else {
            //return null;
        }
        return null;
        
    }
   
    
  

     public static Item_model make_data(String response) {
        response = response.substring(response.indexOf("{") + 1, response.length() - 3);
        Item_model data =Item_model.book_to_map_details(response + "}");

        return data;

    }


    
    private static ArrayList<Item_model> make_data_list(String response) {
        ArrayList<Item_model> returnData = new ArrayList<Item_model>();
        response = response.substring(response.indexOf(":[", 1) + 2, response.length() - 3);
        // System.out.println(response);
        String[] keyValuePairs = response.split("},");

        for (String s : keyValuePairs) {

            Item_model data =Item_model.book_to_map(s + "}");
            returnData.add(data);
        }
        return returnData;

    }

    private static String getRandomElement(String[] list) {
        Random rand = new Random();
        return list[rand.nextInt(list.length)];
    }

}

