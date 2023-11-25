package datamodel;


//this class is used to store all the information about the item
//we use the id to search for the item in the api database
public class Item_model {



    public String title;
    public Double price;
    public String image;
    public static String id;
    String description;
    Boolean isBook;
    String bookId;

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


public String getId() {
        return id;
}


public void setId(String id) {
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
Item_model(String title,String image , String id, double price, Boolean isBook,String description) {
        this.title = title;
        this.price = price;
        this.image = image;
        this.isBook = isBook;
        this.id = id;
        this.description = description;
        

    }




    public Item_model() {
    }


    public static Item_model set_data(String title,String image , String id, double price, Boolean isBook,String description){
        Item_model newData = new Item_model(title,image,id,price, true,description );
        return newData;
    }

   



//converts stored data to type Item_model for the itemController
    public static Item_model store_to_map(String roughData) {
        //rough data comes in string.

        //initializes them in case of later exception
        Double price = 0.0;
        String image = "", description = "", name = "", id = "0";

        //this converts the string into individual item variables
        try {
            name = roughData.substring(roughData.indexOf("\"title\":") + 9,
                    roughData.indexOf("\",\"", roughData.indexOf("\"title\":") + 9));
            price = Double.parseDouble(roughData.substring((roughData.indexOf("\"price\":")) + 8,
                    roughData.indexOf("\"description\":") - 1));
            image = roughData.substring((roughData.indexOf("\"image\":")) + 9, roughData.indexOf("\"rating\":") - 2);
            id =roughData.substring((roughData.indexOf("\"id\":")) + 5, roughData.indexOf("\"title\":") - 1);
            description = roughData.substring((roughData.indexOf("\"description\":")) + 15,
                    roughData.indexOf("\"category\":") - 2);
          

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
        System.out.println(roughData);
        //initializes them in case of later exception
        Double price = 0.0;
        String image = "", description = "n/a", name = "";id = "0";
        try {
            name = roughData.substring(roughData.indexOf("\"title\":") + 9,
                    roughData.indexOf("\",\"", roughData.indexOf("\"title\":") + 9));
            price = 12.99;
        image = roughData.substring((roughData.indexOf("\"img\":")) + 7, roughData.indexOf("\"url_number\":")-2);
                id = roughData.substring((roughData.indexOf("\"url_number\":")) + 15,roughData.length()-2 );
          

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


public static Item_model book_to_map_details(String roughData) {
      //rough data comes in string.
        System.out.println(roughData);
        //initializes them in case of later exception
        Double price = 0.0;
        String image = "", description = "n/a", name = "";id = "0";
        try {
            name = roughData.substring(roughData.indexOf("\"title\":") + 9,
                    roughData.indexOf("\",\"", roughData.indexOf("\"title\":") + 9));
        price = 12.99;
        image = roughData.substring((roughData.indexOf("\"image\":")) + 9, roughData.indexOf("\"pages\":")-2);
        id = roughData.substring((roughData.indexOf("\"id\":")) + 6,roughData.indexOf("\"},") );
        description = roughData.substring(roughData.indexOf("\"details\"")+ 11, roughData.indexOf("\"image\"")-2);

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

//converts Itemmodel to Cartitem model 
//this us uded to by the add to cart functions in the thing
public static  CartItem_model itemmodel_to_CartItem_model(Item_model model){
        CartItem_model newCartItem = new CartItem_model();
        newCartItem.set_price(model.price);
        newCartItem.set_name(model.title);
        newCartItem.set_quantity(1);
        newCartItem.set_image(model.image);
        newCartItem.set_id(model.id);
        newCartItem.set_item_type(model.isBook);
        System.out.println(model.price);
        System.out.println(model.title);
        System.out.println(model.image);
        
        return newCartItem;
}


}
