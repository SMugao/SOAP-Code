package com.example.demo;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SOAPGuestConnector extends WebServiceGatewaySupport {

    public Object callWebService(String url, Object request){
        return getWebServiceTemplate().marshalSendAndReceive(url, request);
    }

}
