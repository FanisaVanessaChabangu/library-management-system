package com.example.library_management_system.service;

import com.example.library_management_system.model.Book;
import com.example.library_management_system.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private List<Book> mockBooks;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize mock data
        mockBooks = new ArrayList<>();
        mockBooks.add(new Book());
        mockBooks.add(new Book());
    }

    @Test
    void getAllBooks() {
        when(bookRepository.findAll()).thenReturn(mockBooks);

        List<Book> result = bookService.getAllBooks();

        assertEquals(mockBooks.size(), result.size());
        assertEquals(mockBooks.get(0).getTitle(), result.get(0).getTitle());

        verify(bookRepository, times(1)).findAll();
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    void getBookById() {
        Long bookId = 1L;
        Book book = new Book();
        book.setId(bookId);
        book.setTitle("Book 1");
        book.setAuthor("Author 1");

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));

        Optional<Book> result = Optional.of(bookService.getBookById(bookId));

        assertEquals(book.getTitle(), result.get().getTitle());
        assertEquals(book.getAuthor(), result.get().getAuthor());

        verify(bookRepository, times(1)).findById(bookId);
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    void saveBook() {
        Book book = new Book();
        book.setTitle("New Book");
        book.setAuthor("New Author");

        when(bookRepository.save(book)).thenReturn(book);

        Book savedBook = bookService.saveBook(book);

        assertEquals(book.getTitle(), savedBook.getTitle());
        assertEquals(book.getAuthor(), savedBook.getAuthor());

        verify(bookRepository, times(1)).save(book);
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    void deleteBook() {
        Long bookId = 1L;

        bookService.deleteBook(bookId);

        verify(bookRepository, times(1)).deleteById(bookId);
        verifyNoMoreInteractions(bookRepository);
    }
}
