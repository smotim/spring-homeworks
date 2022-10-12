package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class BookRepository implements ProjectRepository<Book> {

    private final Logger logger = Logger.getLogger(BookRepository.class);
    private static final Map<Long, Book> repo = new ConcurrentHashMap<>();
    private static Long lastIndex = 0l;

    @Override
    public List<Book> retreiveAll() {
        return new ArrayList<>(repo.values());
    }

    @Override
    public void store(Book book) {
        if (book.getAuthor().isBlank() && book.getTitle().isBlank() && book.getSize() == null)
        {
            return;
        }
        book.setId(lastIndex++);
        logger.info("store new book: " + book);
        repo.put(book.getId(), book);
    }

    @Override
    public boolean removeItemById(Integer bookIdToRemove) {
            if (!repo.containsKey(bookIdToRemove)) {
                String error = String.format("There is no book with this id", bookIdToRemove);
                logger.error(error);
                return false;
            }
            repo.remove(bookIdToRemove);
            return true;
    }
}
