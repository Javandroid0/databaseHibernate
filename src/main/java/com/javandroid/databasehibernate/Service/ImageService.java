package com.javandroid.databasehibernate.Service;

import com.javandroid.databasehibernate.Repo.ImageRepository;
import com.javandroid.databasehibernate.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Long saveImage(MultipartFile file) throws IOException {
        Image image = new Image(file.getOriginalFilename(), file.getBytes());

        imageRepository.save(image);
        return image.getId();
    }

    public Image getImageById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    // You can add additional methods to retrieve images if needed
}

