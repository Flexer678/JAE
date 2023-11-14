package shopping;

import Pages.*;
//import item.java from sec/widgets
import assets.localFiles;

public class Main {

    public static void main(String[] args) {

        if (localFiles.isSignIn) {
            runhPages(args);

        } else {
            runSiginIn(args);
        }

    }

    private static void runhPages(String[] args) {
        homePage runhPage = new homePage();
        runhPage.run(args);
    }

    private static void runSiginIn(String[] args) {
        SignInPage runSPage = new SignInPage();
        runSPage.run(args);
    }

}