package com.interview.restservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.interview.restservice.Address;

import org.junit.jupiter.api.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

class ContactTests {
    Contact contact;

    String street = "Test Street";
    String city = "Richmond";
    String state = "Virginia";
    String zip = "23111";

    private final Address address = new Address(street, city, state, zip);

    String first = "Markel";
    String middle = "J";
    String last = "Spellman";

    private final Name name = new Name(first, middle, last);

    String number = "8042525509";
    Phone.PhoneType type = Phone.PhoneType.mobile;
    private final Phone phone = new Phone(number, type);
    ArrayList<Phone> phones = new ArrayList<>();

    String email = "markel.spellman@gmail.com";

    @BeforeEach
    public void setUp() {
        phones.add(phone);
        contact = new Contact(name, address, phones, email);
    }

    @AfterEach
    public void tearDown() {
        phones = null;
    }

    @Test
    public void initializeContact() {
        assertTrue(contact instanceof Contact);
    }

}
