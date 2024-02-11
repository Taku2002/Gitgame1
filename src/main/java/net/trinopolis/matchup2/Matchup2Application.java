package net.trinopolis.matchup2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.net.URI;

@SpringBootApplication
public class Matchup2Application {

	public static void main(String[] args) {
		SpringApplication.run(Matchup2Application.class, args);
	}


}

@Component
class MediaSelector {

	private static final String UPLOAD_DIR = "/path/to/upload/directory/";

	public URI selectRandomMedia() {
		// Logic to select a random image from the uploaded images directory
		// Assuming images are stored in the UPLOAD_DIR directory
		Path uploadPath = Paths.get(UPLOAD_DIR);
		try {
			// Get a random image file from the directory
			Path[] imageFiles = Files.walk(uploadPath).filter(Files::isRegularFile).toArray(Path[]::new);
			if (imageFiles.length > 0) {
				Random random = new Random();
				Path randomImagePath = imageFiles[random.nextInt(imageFiles.length)];
				return randomImagePath.toUri();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
