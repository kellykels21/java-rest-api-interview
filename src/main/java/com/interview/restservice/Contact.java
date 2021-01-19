package com.interview.restservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Contact {
    @Id private String contactId;

    private String email;

    @JsonProperty("name")
    private Name name;

    @JsonProperty("address")
    private Address address;

    @JsonProperty("phone")
    private ArrayList<Phone> phone;

    public Contact(Name name, Address address, ArrayList<Phone> phone, String email) {
        this.contactId = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<Phone> getPhone() {
        return phone;
    }

    public void addPhoneNumber(Phone phone) {
         this.phone.add(phone);
    }

    public void setPhone(ArrayList<Phone> phones) { this.phone = phones; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return contactId;
    }
}
