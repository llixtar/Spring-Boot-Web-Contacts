package com.example.app.SpringBootWebContacts.service;

import com.example.app.SpringBootWebContacts.entity.FavoriteContact;
import com.example.app.SpringBootWebContacts.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class FavoriteContactService {

    @Autowired
    FavoriteRepository repository;

    public List<FavoriteContact> getFavorites() throws URISyntaxException, IOException {
        return repository.getFavorites();
    }
}
