package com.ps;

import com.ps.routes.CountryRouteBuilder;
import org.apache.camel.main.Main;

public class Application {
    public static void main(String[] args) throws Exception {
        Main main = new Main();

        // add property file
        main.setDefaultPropertyPlaceholderLocation("classpath:application.properties");

        // register the required routes
        // main.configure().addRoutesBuilder(BankRouteBuilder.class);
        // main.configure().addRoutesBuilder(TempRouteBuilder.class);
        main.configure().addRoutesBuilder(CountryRouteBuilder.class);
        // run the application
        main.run(args);
    }
}
