package utils;

import pages.AccountCreationPage;


    public class PageInitializer {
        public static AccountCreationPage accountCreationPage;



        public static void initializePageObjects() {
            accountCreationPage = new AccountCreationPage();

        }
    }

