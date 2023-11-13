package shopping;

import Pages.homePage;
//import item.java from sec/widgets

public class Main {
    public Boolean isSignIn = false;

    public static void main(String[] args) {
        homePage run = new homePage();

        run.run(args);
        ;
    }
}