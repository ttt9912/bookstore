package ch.thts.business.service;

import ch.thts.business.data.Book;
import ch.thts.entity.BookEntity;
import ch.thts.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;

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
        return book;
    }
}
