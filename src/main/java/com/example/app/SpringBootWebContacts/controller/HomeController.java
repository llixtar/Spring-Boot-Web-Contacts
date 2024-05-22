package com.example.app.SpringBootWebContacts.controller;

import com.example.app.SpringBootWebContacts.service.ContactService;
import com.example.app.SpringBootWebContacts.service.FavoriteContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.URISyntaxException;

@Controller
public class HomeController {

    @Autowired
    ContactService contactService;
    @Autowired
    FavoriteContactService favoriteService;

    @GetMapping("/")
    public String getHome(Model model) throws URISyntaxException, IOException {
        model.addAttribute("contacts", contactService.getContacts());
        model.addAttribute("favorites", favoriteService.getFavorites());
        return "home";
    }
}
