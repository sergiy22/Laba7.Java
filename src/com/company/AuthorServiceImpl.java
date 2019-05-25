package com.company;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorServiceImpl implements AuthorService {

    private BookService bookService;
    private BookValidatorService bookValidatorService;

    public BookValidatorService getBookValidatorService() {
        return bookValidatorService;
    }

    public void setBookValidatorService(BookValidatorService bookValidatorService) {
        this.bookValidatorService = bookValidatorService;
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }


    @Override
    public int getTotalBooks(String author) {

        List<Book> books = bookService.findBookByAuthor(author);


        List<Book> filtered = books.stream().filter(
                x -> bookValidatorService.isValid(x))
                .collect(Collectors.toList());

        return filtered.size();


    }
}
