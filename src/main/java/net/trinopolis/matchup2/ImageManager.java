package net.trinopolis.matchup2;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class ImageManager {

    private static final String UPLOAD_DIR = "/path/to/upload/directory/";

    public void uploadImage(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            // Handle the case when the file is null or empty
            System.out.println("Uploaded file is null or empty.");
            return;
        }

        try {
            // Create the upload directory if it doesn't exist
            Files.createDirectories(Paths.get(UPLOAD_DIR));

            // Get the bytes of the uploaded file
            byte[] bytes = file.getBytes();

            // Specify the file path where you want to save the uploaded image
            Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());

            // Write the bytes to the file
            Files.write(path, bytes);

            // Optionally, you can perform additional processing or save the file path as needed

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
