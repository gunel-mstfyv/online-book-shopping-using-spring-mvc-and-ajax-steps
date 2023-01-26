package az.developia.bookshoppinggunelm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import az.developia.bookshoppinggunelm.file.StorageProperties;
import az.developia.bookshoppinggunelm.file.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class BookshoppingGunelMApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookshoppingGunelMApplication.class, args);
	}
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.init();
		};
	}
}
