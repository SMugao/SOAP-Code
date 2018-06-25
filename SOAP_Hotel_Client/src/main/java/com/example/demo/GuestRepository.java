package com.example.demo;

import localhost._8080.webservice.Guest;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class GuestRepository {

    public static final Map<String, Guest> guests = new HashMap<>();

    @PostConstruct
    public void initData(){
        Guest joseph = new Guest();
        joseph.setName("Joseph");
        joseph.setPhoneNumber("0712345678");
        joseph.setEmail("joseph@gmail.com");
        joseph.setCheckIn("12/07/2018");
        joseph.setCheckOut("19/07/2018");

        guests.put(joseph.getName(), joseph);

        Guest jane = new Guest();
        jane.setName("Jane");
        jane.setPhoneNumber("0709876543");
        jane.setEmail("jane@gmail.com");
        jane.setCheckIn("12/08/2018");
        jane.setCheckOut("19/08/2018");

        guests.put(jane.getName(), jane);

        Guest rose = new Guest();
        rose.setName("Rose");
        rose.setPhoneNumber("0745678909");
        rose.setEmail("rose@gmail.com");
        rose.setCheckIn("12/09/2018");
        rose.setCheckOut("19/09/2018");

        guests.put(rose.getName(), rose);
    }

    public Guest findGuest(String name) {
        Assert.notNull(name, "The guest's name should be present");
        return guests.get(name);
    }

}
