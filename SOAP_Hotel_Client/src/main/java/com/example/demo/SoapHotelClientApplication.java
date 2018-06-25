package com.example.demo;

import localhost._8080.webservice.GetGuestRequest;
import localhost._8080.webservice.GetGuestResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapHotelClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapHotelClientApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(SOAPGuestConnector soapGuestConnector){
        return args -> {
            String name = "Joseph";
            if (args.length>0){
                name = args[0];
            }
            GetGuestRequest request = new GetGuestRequest();
            request.setName(name);
            GetGuestResponse response = (GetGuestResponse) soapGuestConnector.callWebService("http://localhost:8080/ws", request);
            System.out.println("The message is: ");
            System.out.println("Guest: "+response.getGuest().getName());
        };
    }

}
