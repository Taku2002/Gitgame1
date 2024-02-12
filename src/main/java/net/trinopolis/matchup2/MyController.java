package net.trinopolis.matchup2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.net.URI;
import java.util.Optional;

@RestController
public class MyController {

    @Autowired
    private ImageManager imageManager;

    @PostMapping("/upload/image")
    public ResponseEntity<String> uploadImage(@RequestBody MultipartFile file) {
        imageManager.uploadImage(file);
        return ResponseEntity.ok("Image uploaded successfully");
    }

    @Autowired
    private MediaSelector mediaSelector;

    @GetMapping("/random/media")
    public ResponseEntity<URI> getRandomMedia() {
        // Get a random media URI
        return Optional.ofNullable(mediaSelector.selectRandomMedia())
                .map(ResponseEntity::ok) // Map to ResponseEntity.ok if URI is present
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)); // Otherwise, return 404
    }
}

