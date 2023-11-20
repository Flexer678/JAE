package datamodel;


//this class is used to store all the information about the item
//we use the id to search for the item in the api database
public class Item_model {



    public String title;
    public Double price;
    public String image;
    int id;
    String description;
    Boolean isBook;

    public String getTitle() {
        return title;
}


public void setTitle(String title) {
        this.title = title;
}


public Double getPrice() {
        return price;
}


public void setPrice(Double price) {
        this.price = price;
}


public String getImage() {
        return image;
}


public void setImage(String image) {
        this.image = image;
}


public int getId() {
        return id;
}


public void setId(int id) {
        this.id = id;
}


public String getDescription() {
        return description;
}


public void setDescription(String description) {
        this.description = description;
}


public Boolean getIsBook() {
        return isBook;
}


public void setIsBook(Boolean isBook) {
        this.isBook = isBook;
}



//this constructor is for setting the different item models
//we take the api and use this to convert it 
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


    public static Item_model set_data(String title,String image , int id, double price, Boolean isBook,String description){
        Item_model newData = new Item_model(title,image,id,price, true,description );
        return newData;
    }

   



//converts stored data to type Item_model for the itemController
    public static Item_model store_to_map(String roughData) {
        //rough data comes in string.

        //initializes them in case of later exception
        Double price = 0.0;
        String image = "", description = "", category = "", name = "";
        int id = 0;

        //this converts the string into individual item variables
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
        //this converts the item variables into item model
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
