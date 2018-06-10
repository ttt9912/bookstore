package ch.thts.business;

import ch.thts.data.Book;
import ch.thts.data.Rating;
import ch.thts.entity.BookEntity;
import ch.thts.entity.BookRepository;
import ch.thts.integration.RatingAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService implements IBookService {

    private final BookRepository bookRepository;
    private final RatingAdapter ratingAdapter;

    @Autowired
    public BookService(BookRepository bookRepository, RatingAdapter ratingAdapter) {
        this.bookRepository = bookRepository;
        this.ratingAdapter = ratingAdapter;
    }

    @Override
    public List<Book> getAllBooks() {
        final List<BookEntity> bookEntities = (List<BookEntity>) bookRepository.findAll();
        return createBooks(bookEntities);
    }

    private List<Book> createBooks(List<BookEntity> bookEntities) {
        return bookEntities.stream()
                .map(this::createBook)
                .collect(Collectors.toList());
    }

    private Book createBook(BookEntity entity) {
        Book book = new Book();
        book.setTitle(entity.getTitle());
        book.setRating(createRating(entity.getId()));
        return book;
    }

    private Rating createRating(long id){
        return ratingAdapter.getRatingById(id);
    }
}
