package shopping;

import Pages.*;
//import item.java from sec/widgets
import assets.localFiles;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        if (localFiles.isLoggedIn()) {
            run_hPages(args);
        } else {
            run_SignIn(args);
        }

    }

    private static void run_hPages(String[] args) {
        HomePage runhPage = new HomePage();
        runhPage.run(args);
    }

    private static void run_SignIn(String[] args) {
        SignInPage runSPage = new SignInPage();
        runSPage.run(args);
    }

}