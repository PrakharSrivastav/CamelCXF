package com.ps;

import com.ps.routes.BankRouteBuilder;
import org.apache.camel.main.Main;
import org.apache.camel.spi.PropertiesComponent;

public class Application {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.setDefaultPropertyPlaceholderLocation("classpath:application.properties");
        main.configure().addRoutesBuilder(BankRouteBuilder.class);
        main.run(args);
    }
}
