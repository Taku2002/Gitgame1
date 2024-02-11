package net.trinopolis.matchup2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

@RestController
public class MyController {

    @Autowired
    private ImageManager imageManager;

    @Autowired
    private MediaSelector mediaSelector;

    @PostMapping("/upload/image")
    public ResponseEntity<String> uploadImage(@RequestBody MultipartFile file) {
        imageManager.uploadImage(file);
        return ResponseEntity.ok("Image uploaded successfully");
    }

    @GetMapping("/random/media")
    public ResponseEntity<URI> getRandomMedia() {
        URI mediaUri = mediaSelector.selectRandomMedia();
        return ResponseEntity.ok(mediaUri);
    }
}

