package server;

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

import datamodel.Item_model;

public class StoreApi {

    private static String url = "https://us-central1-fakestore-redirect.cloudfunctions.net/app/";
    public static void main(String args[]) throws Exception {
       get_products_by_category("jewelery");
  
    }


    public static ArrayList<Item_model> get_all() throws IOException{
    
        URL link = new URL(url + "all");

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
           
            return make_data_list(response.toString());

        } else {
            return null;
        }
        
    }
        public static ArrayList<String> get_categories() throws IOException{
    
        URL link = new URL(url + "categories"  );

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
            String res = response.toString();
             res = res.substring(response.indexOf(":[", 1) + 3, res.length() - 2);
            String[] keyValuePairs = res.split("\",\"");
            ArrayList<String> returnData = new ArrayList<String>();
         
             for (String s : keyValuePairs) {

       
            returnData.add(s);
        }
             return returnData;
            
        } else {
            //return null;
        }
        return null;
   
        
    }
     public static ArrayList<Item_model>  get_products_by_category(String categ) throws IOException{

        String filter = categ.replace(" ", "%20");
        String ursl = url + "productCateg/"+filter;;
        System.out.println(ursl);
        URL link = new URL(url+"productCateg/"+categ);

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
            System.out.println(response.toString());
            return  make_data_list(response.toString());

        } else {
            //return null;
        }
        return null;
        
    }
   
    
    public static Item_model get_product_by_id(String id) throws IOException{
    
        URL link = new URL(url + "product/"+id);

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
        Item_model data =Item_model.store_to_map(response + "}");

        return data;

    }


    
    private static ArrayList<Item_model> make_data_list(String response) {
        ArrayList<Item_model> returnData = new ArrayList<Item_model>();
        response = response.substring(response.indexOf(":[", 1) + 2, response.length() - 3);
        // System.out.println(response);
        String[] keyValuePairs = response.split("},");

        for (String s : keyValuePairs) {

            Item_model data =Item_model.store_to_map(s + "}");
            returnData.add(data);
        }
        return returnData;

    }

}

