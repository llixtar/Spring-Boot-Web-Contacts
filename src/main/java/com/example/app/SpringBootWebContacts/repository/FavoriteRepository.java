package com.example.app.SpringBootWebContacts.repository;

import com.example.app.SpringBootWebContacts.entity.FavoriteContact;
import com.example.app.SpringBootWebContacts.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class FavoriteRepository {

    private static final Logger LOGGER =
            Logger.getLogger(FavoriteRepository.class.getName());

    List<FavoriteContact> list;

    public List<FavoriteContact> getFavorites() throws IOException {

        File jsonFile = new ClassPathResource(Constants.URL_FILES +
                Constants.FILE_FAVORITES).getFile();
        String path = jsonFile.getAbsolutePath();

        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(path));
            list = gson.fromJson(reader,
                    new TypeToken<List<FavoriteContact>>() {}.getType());
            reader.close();
            return list.stream()
                    .map(favoriteContact -> new FavoriteContact(favoriteContact.getId(),
                            Constants.URL_IMAGES + favoriteContact.getImg(),
                            favoriteContact.getName(),
                            favoriteContact.getPhone()))
                    .toList();
        } catch (Exception ex) {
            LOGGER.info("FavoriteContactRepository msg: " + ex.getMessage());
            // Якщо помилка, повертаємо порожню колекцію
            return Collections.emptyList();
        }
    }
}
