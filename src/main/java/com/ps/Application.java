package com.ps;

import com.ps.routes.BankRouteBuilder;
import org.apache.camel.main.Main;
import org.apache.camel.spi.PropertiesComponent;

public class Application {
    public static void main(String[] args) throws Exception {
        Main main = new Main();

        // add property file
        main.setDefaultPropertyPlaceholderLocation("classpath:application.properties");

        // register the required routes
        main.configure().addRoutesBuilder(BankRouteBuilder.class);

        // run the application
        main.run(args);
    }
}
