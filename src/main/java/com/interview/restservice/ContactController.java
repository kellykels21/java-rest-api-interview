package com.interview.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class ContactController {

    @Autowired
    private ContactRepository repository;

    @GetMapping("/contacts")
    public List<Contact> getContact() {
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        for (Contact contact : repository.findAll()) {
          contacts.add(contact);
        }
        return contacts;
    }

    @GetMapping("/contacts/{id}")
    public Optional<Contact> findByContactId(@PathVariable("id") String id ) {
        return repository.findById(id);
    }

    @GetMapping("/contacts/call-list")
    public List<Contact> findByContactId() {
        ArrayList<Contact> results = new ArrayList<Contact>();
        for (Contact contact : repository.findAll()) {
            ArrayList<Phone> contactPhoneList = contact.getPhone();
            for (Phone phone : contactPhoneList) {
                if (phone.getType().equals(Phone.PhoneType.home)) {
                    results.add(contact);
                }
            }
        }

        List<Contact> result = results.stream()
                .sorted(Comparator.comparing(x -> x.getName().getLast(), String::compareToIgnoreCase))
                .collect(Collectors.toList());

        return result;
    }

    @PutMapping("/contacts/{id}")
    public Contact updateContactById(@PathVariable("id") String id, @RequestBody Contact oldContact) {
        Optional<Contact> result = repository.findById(id);
        Contact contact = result.get();

        contact.setName(oldContact.getName());
        contact.setAddress(oldContact.getAddress());
        contact.setPhone(oldContact.getPhone());
        contact.setEmail(oldContact.getEmail());

        repository.save(contact);
        return contact;
    }

    @DeleteMapping("/contacts/{id}")
    public void updateContactById(@PathVariable("id") String id) {
        Optional<Contact> result = repository.findById(id);
        Contact contact = result.get();

        repository.delete(contact);
    }

    @PostMapping("/contacts")
    @ResponseBody
    public Contact createContact(@RequestBody Contact contact) {
        repository.save(contact);
        return contact;
    }
}
