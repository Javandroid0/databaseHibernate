package com.javandroid.databasehibernate.Controller;

import com.javandroid.databasehibernate.Service.ImageService;
import com.javandroid.databasehibernate.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/upload")
    public String showUploadForm() {
        return "upload"; // returns upload.html (upload form)
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file, Model model) {
        try {
            Long imageName = imageService.saveImage(file);
            model.addAttribute("message", "Image uploaded successfully");
            model.addAttribute("imageId", imageName);
            System.out.println(imageName);
        } catch (Exception e) {
            model.addAttribute("message", "Failed to upload image");
        }
        return "upload"; // Redirect or return the same view with message
    }

    @GetMapping("/view/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> viewImage(@PathVariable Long id) {
        Image image = imageService.getImageById(id);
        if (image == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .header("Content-Type", "image/jpeg") // or other appropriate type
                .body(image.getData());
    }

}

