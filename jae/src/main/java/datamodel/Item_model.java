package datamodel;

public class Item_model {



    String title;
    Double price;
    String image;
    int id;
    String description;
    Boolean isBook;

    Item_model(String title,String image , int id, double price, Boolean isBook,String description) {
        this.title = title;
        this.price = price;
        this.image = image;
        this.isBook = isBook;
        this.id = id;
        this.description = description;
        

    }


    public Item_model() {
    }


    //converts stored data to type Item_model for the itemController
    public static Item_model store_to_map(String roughData) {
        //rough data comes in string.

        //initializes them in case of later exception
        Double price = 0.0;
        String image = "", description = "", category = "", name = "";
        int id = 0;
        try {
            name = roughData.substring(roughData.indexOf("\"title\":") + 9,
                    roughData.indexOf("\",\"", roughData.indexOf("\"title\":") + 9));
            price = Double.parseDouble(roughData.substring((roughData.indexOf("\"price\":")) + 8,
                    roughData.indexOf("\"description\":") - 1));
            image = roughData.substring((roughData.indexOf("\"image\":")) + 9, roughData.indexOf("\"rating\":") - 2);
            id = Integer.parseInt(
                    roughData.substring((roughData.indexOf("\"id\":")) + 5, roughData.indexOf("\"title\":") - 1));
            description = roughData.substring((roughData.indexOf("\"description\":")) + 15,
                    roughData.indexOf("\"category\":") - 2);
            category = roughData.substring((roughData.indexOf("\"category\":")) + 12,
                    roughData.indexOf("\"image\":") - 2);

        } catch (Exception e) {
            System.out.println("somethign went wrong");
        }
        Item_model newData = new Item_model(name,image,id,price, false,description );
        System.out.println(newData.title);
        System.out.println(newData.price);
        System.out.println(newData.image);
        System.out.println(newData.id);
        System.out.println(newData.description);

        System.out.println("\n");

        return newData;
    }

    public static Item_model book_to_map(String roughData) {
        //rough data comes in string.

        //initializes them in case of later exception
        Double price = 0.0;
        String image = "", description = "", category = "", name = "";
        int id = 0;
        try {
            name = roughData.substring(roughData.indexOf("\"title\":") + 9,
                    roughData.indexOf("\",\"", roughData.indexOf("\"title\":") + 9));
            price = Double.parseDouble(roughData.substring((roughData.indexOf("\"price\":")) + 8,
                    roughData.indexOf("\"description\":") - 1));
            image = roughData.substring((roughData.indexOf("\"image\":")) + 9, roughData.indexOf("\"rating\":") - 2);
            id = Integer.parseInt(
                    roughData.substring((roughData.indexOf("\"id\":")) + 5, roughData.indexOf("\"title\":") - 1));
            description = roughData.substring((roughData.indexOf("\"description\":")) + 15,
                    roughData.indexOf("\"category\":") - 2);
            category = roughData.substring((roughData.indexOf("\"category\":")) + 12,
                    roughData.indexOf("\"image\":") - 2);

        } catch (Exception e) {
            System.out.println("somethign went wrong");
        }
        Item_model newData = new Item_model(name,image,id,price, true,description );
        System.out.println(newData.title);
        System.out.println(newData.price);
        System.out.println(newData.image);
        System.out.println(newData.id);
        System.out.println(newData.description);

        System.out.println("\n");

        return newData;
    }



}
