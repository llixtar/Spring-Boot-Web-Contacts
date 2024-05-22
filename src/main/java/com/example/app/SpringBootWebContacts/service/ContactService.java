package com.example.app.SpringBootWebContacts.service;

import com.example.app.SpringBootWebContacts.entity.Contact;
import com.example.app.SpringBootWebContacts.repository.ContactRepository;
import com.example.app.SpringBootWebContacts.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ContactService {

    @Autowired
    ContactRepository repository;

    public List<Contact> getContacts() {
        Iterable<Contact> iterable = repository.findAll();
        List<Contact> list =
                StreamSupport.stream(iterable.spliterator(), false)
                        .map(contact -> new Contact(contact.getId(),
                                Constants.URL_IMAGES + contact.getImg(),
                                contact.getName(),
                                contact.getSurname(),
                                contact.getPhone()))
                        .toList();
        return new ArrayList<>(list);
    }
}
