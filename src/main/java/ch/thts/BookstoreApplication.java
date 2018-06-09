package ch.thts;

import ch.thts.entity.BookEntity;
import ch.thts.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner addData(BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new BookEntity("Faust"));
            bookRepository.save(new BookEntity("Bahnwärter Thiel"));
            bookRepository.save(new BookEntity("Kleider machen Leute"));
            bookRepository.save(new BookEntity("Homo Faber"));
            bookRepository.save(new BookEntity("Biedermann und die Brandstifter"));
        };
    }
}
