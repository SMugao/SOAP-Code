package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SOAPGuestConfig {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

        marshaller.setContextPath("localhost._8080.webservice");
        return marshaller;
    }

    @Bean
    public SOAPGuestConnector soapConnector(Jaxb2Marshaller marshaller){
        SOAPGuestConnector client = new SOAPGuestConnector();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
